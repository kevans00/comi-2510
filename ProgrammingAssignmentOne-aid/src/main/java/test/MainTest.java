package test;

import java.util.ArrayList;
import java.lang.Math;
import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.io.FileWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;
import planets.planetai.PlanetaryBody;
import planets.planetai.PlanetaryBodyReader;

public class MainTest {
	private static final Logger logger = LogManager.getLogger(MainTest.class.getName());

	public static final String RESOURCE_PATH = "src\\main\\resources\\in\\";
	public static final String OUTPUT_PATH = "src\\main\\resources\\out\\";
	public static final String PLANET_CSV_FILE = "planet_details.csv";
	public static final String VEHICLE_CSV_FILE = "vehicle_details.csv";
	public static final String DELIMITER = ",";
	public static final int MIN_FILE_NUMBER = 1;
	public static final int MAX_FILE_NUMBER = 21;	

	public static String resourceFolderAbsPath = new File(RESOURCE_PATH).getAbsolutePath();
	public static String outputFolderAbsPath = new File(OUTPUT_PATH).getAbsolutePath();
	public static File planetFile = new File(resourceFolderAbsPath, PLANET_CSV_FILE);
	public static File vehicleFile = new File(resourceFolderAbsPath, VEHICLE_CSV_FILE);

	static PlanetaryBodyReader pb = new PlanetaryBodyReader();
	static ArrayList<PlanetaryBody> planetList = pb.readCSV(planetFile.getPath(), DELIMITER);

	static TransportationVehicleReader tv = new TransportationVehicleReader();
	static ArrayList<TransportationVehicle> vehicleList = tv.readCSV(vehicleFile.getPath(), DELIMITER);

	public static String[] getPlanetData() {
		
		int planetArraySize = planetList.size();
		String planetArray[] = new String[planetArraySize];
		
		for (int i=0; i < planetArraySize; i++) {
			PlanetaryBody entry = planetList.get(i);
			planetArray[i] = entry.getPlanetName();
		}
		
		return planetArray;
	}

	public static String[] getVehicleData() {
		
		int vehicleArraySize = vehicleList.size();
		String vehicleArray[] = new String[vehicleArraySize];
		
		for (int i=0; i < vehicleArraySize; i++) {
			TransportationVehicle entry = vehicleList.get(i);
			vehicleArray[i] = entry.getVehicleName();
		}
		
		return vehicleArray;
	}
	
	public static double calculateOrbitalVelocity(double distFromSunOrigin, double orbitalPeriodInDays) {
		double orbitalVelocity = (METERS_TO_KILOMETERS_FACTOR * Math.sqrt((2 * Math.PI * distFromSunOrigin) / (orbitalPeriodInDays * SECONDS_IN_A_DAY)));
		return orbitalVelocity; // returns in km/h
	}
	
	public static double calculateGravityAssistVelocity(double orbitalVelocity, double transportVehicleVelocity) {
		double gav = (2 * orbitalVelocity) + transportVehicleVelocity;
		return gav; // returns in km/h
	}
	
	/* Drag not required until future assignment
	public static double calculateDrag(String planetBodyClass, double albeto, double orbitalEccentricity) {
		
		double albetoCoefficient = 0.0;
		
		if (planetBodyClass == "Planet") {
			albetoCoefficient = 0.1;
		}
		
		if (planetBodyClass == "Dwarf planet") {
			albetoCoefficient = 0.35;
		}
		
		if (planetBodyClass == "Moon") {
			albetoCoefficient = 0.75;
		}
		
		else {
			return albeto * orbitalEccentricity;
		}
		
		double drag = albetoCoefficient + (albeto * orbitalEccentricity);
		
		return drag; // returns in km/h
	}*/
	
	public static PlanetaryBody getPlanet(String planet) {
		int arraySize = planetList.size();
		PlanetaryBody matchedPlanet = null;
		
		for (int i = 0; i < arraySize; i++ ) {
			PlanetaryBody entry = planetList.get(i);
			formatLogger("Checking line %s for PlanetaryBody %s, found %s", i, planet, entry.getPlanetName());
			if (entry.getPlanetName() == planet) {
				matchedPlanet = planetList.get(i);
				formatLogger("Found match for %s on line %s", matchedPlanet, i);
				break;
			}
		}
		
		return matchedPlanet;
	}
	
	public static double calculateRelativeDistance(PlanetaryBody startingPlanet, PlanetaryBody endingPlanet) {	
		// We are using the relative distance from the sun because this makes most sense; we cannot physically land on the sun
		// so we do not have to account for any distance to/from it
		double distance = Math.abs(startingPlanet.getDistanceSun() - endingPlanet.getDistanceSun());
		return distance; // in km
	}
	
	public static TransportationVehicle getVehicle(String vehicle) {
		int arraySize = vehicleList.size();
		TransportationVehicle matchedVehicle = null;
		
		for (int i = 0; i < arraySize; i++ ) {
			TransportationVehicle entry = vehicleList.get(i);
			
			if (entry.getVehicleName() == vehicle) {
				matchedVehicle = vehicleList.get(i);
			}
		}
		
		return matchedVehicle;
	}
	
	public static double calculateTripTimeHours(double velocity, double distance) {
		double time = distance / velocity; // km and km/hr
		return time; // in hours
	}
	
	public static double calculateTripTimeDays(double velocity, double distance) {
		double time = calculateTripTimeHours(velocity, distance) / HOURS_IN_A_DAY;
		return time; // in days
	}
	
	public static double calculateTriptimeYears(double velocity, double distance) {
		double time = calculateTripTimeDays(velocity, distance) / DAYS_IN_A_YEAR;
		return time; // in years
	}
	
	public static void formatLogger(String message, Object... args) {
		// Helper method that combines formating and logging in one
		String logMessage = String.format(message, args);
		MainTest.logger.debug(logMessage);
	}
	
	public static ArrayList<String> doActualCalculations(TransportationVehicle vehicle, PlanetaryBody startingPlanetaryBody, PlanetaryBody destPlanetaryBody) {
		
		if (startingPlanetaryBody.getPlanetName() == destPlanetaryBody.getPlanetName()) { //Fix bug here; startingPlanetaryBody is null
			// ToDo: what do if startingPlanet == endingPlanet?
			// Maybe we call showMultiEditDialog again and ask for user to select new choices? 
			// Do we calculate it anyway? return 0 kilometers?
			double distance = calculateRelativeDistance(startingPlanetaryBody, destPlanetaryBody);
			formatLogger("Distance: %s", distance);
		}
		
		double distance = calculateRelativeDistance(startingPlanetaryBody, destPlanetaryBody);
		formatLogger("Distance: %s", distance);
		
		double distSunOrigin = startingPlanetaryBody.getDistanceSun();
		double orbitalPeriod = startingPlanetaryBody.getYearLength();
		formatLogger("Origin body distance from the Sun: %s km", distSunOrigin);
		formatLogger("Orbital period: %s days", orbitalPeriod);
		
		double transportVehicleVelocity = vehicle.getMaxSpeed();
		double orbitalVelocity = calculateOrbitalVelocity(distSunOrigin, orbitalPeriod);
		double gav = calculateGravityAssistVelocity(orbitalVelocity, transportVehicleVelocity);
		formatLogger("Vehicle Velocity: %s km/hr", transportVehicleVelocity);
		formatLogger("Orbital Velocity: %s km/hr", orbitalVelocity);
		formatLogger("Gravitational Assist Velocity: %s km/hr", gav);
		
		if (gav < 0) {
			// ToDo: Handle negative velocity with a `catch`
			formatLogger("We cannot have a negative velocity! Calculated value has %s km/hr, (are we going backwards?)", gav);
		}
		else if (gav >= SPEED_OF_LIGHT) {
			// ToDo: Handle exceeding lightspeed with a `catch`
			formatLogger("We have somehow broke through lightspeed! Achieved a speed of %s km/hr, but sadly this is wrong", gav);
		}
		
		ArrayList tripDataArray = new ArrayList();
		
		double tripTimeHours = calculateTripTimeHours(gav, distance);
		double tripTimeDays = calculateTripTimeDays(gav, distance);
		double tripTimeYears = calculateTriptimeYears(gav, distance);
		formatLogger("Trip time: %s hours; %s days; %s years", tripTimeHours, tripTimeDays, tripTimeYears);
		
		tripDataArray.add(startingPlanetaryBody.getPlanetName());
		tripDataArray.add(destPlanetaryBody.getPlanetName());
		tripDataArray.add(distance);
		tripDataArray.add(tripTimeHours);
		tripDataArray.add(tripTimeDays);
		tripDataArray.add(tripTimeYears);
		
		return tripDataArray;
	}
	
	public static ArrayList<String> calculateTrip(PlanetaryDialog pd) {
		String[] planetData = getPlanetData();
		String[] vehicleData = getVehicleData();
		
		pd.setUseTransporationVehicle();
		pd.setUseStartingPlanet();
		pd.setUseDestinationPlanet();
		
		pd.showMultiEditDialog(planetData, vehicleData);
		
		String chosenVehicle = pd.getTransportationVechicleName();
		String startingPlanetName = pd.getStartingPlanetName();
		String destPlanetName = pd.getDestinationPlanetName();
		
		// Create objects for the chosen vehicle and bodies
		TransportationVehicle vehicle = getVehicle(chosenVehicle);
		PlanetaryBody startingPlanetaryBody = getPlanet(startingPlanetName);
		PlanetaryBody destPlanetaryBody = getPlanet(destPlanetName);
		formatLogger("Chosen vehicle: %s; starting planet %s; ending %s", chosenVehicle, startingPlanetName, destPlanetName);

		ArrayList tripDataArray = doActualCalculations(vehicle, startingPlanetaryBody, destPlanetaryBody);

		// ToDo: Handle the stop button
		return tripDataArray;
	}
	
	public static ArrayList<String> calculateNextTrip(PlanetaryDialog pd, PlanetaryDialog pdPrevious) {
		String[] planetData = getPlanetData();
		String[] vehicleData = getVehicleData();
		
		// We don't need to produce more combo boxes because we are using values from the previous trip
		pd.setTransportationVehicleName(pdPrevious.getTransportationVechicleName());
		pd.setStartingPlanetName(pdPrevious.getDestinationPlanetName());
		pd.setUseDestinationPlanet();
		pd.showMultiEditDialog(planetData, vehicleData);
		
		String chosenVehicle = pd.getTransportationVechicleName();
		String startingPlanetName = pd.getStartingPlanetName();
		String destPlanetName = pd.getDestinationPlanetName();
		
		// Create objects for the chosen vehicle and bodies
		TransportationVehicle vehicle = getVehicle(chosenVehicle);
		PlanetaryBody startingPlanetaryBody = getPlanet(startingPlanetName);
		PlanetaryBody destPlanetaryBody = getPlanet(destPlanetName);
		formatLogger("Trip 2 - Chosen vehicle: %s; starting planet %s; ending %s", chosenVehicle, startingPlanetName, destPlanetName);
		
		ArrayList<String> tripDataArray = doActualCalculations(vehicle, startingPlanetaryBody, destPlanetaryBody);

		// ToDo: Handle the stop button
		return tripDataArray;
	}
	
	public static String buildFilename() {
		String fixedName = "ProcessedData";
		Random random = new Random();
		int randomNumber = random.nextInt(MAX_FILE_NUMBER) + 1; // Adding 1 as a hack because this function's range is [0, 21)
		String filename = String.format("%s%s.csv", fixedName, randomNumber);
		
		return filename;
	}
	
	public static void writeToCSVFile(String filename, String data) {
	    try {
	        FileWriter writer = new FileWriter(filename, true);
	        writer.write(data); // Does this automatically append to a new line?
	        writer.close();
	        formatLogger("Successfully wrote contents to '%s'", filename);
	        System.out.println("Successfully wrote to the file.");
	    } 
	    catch (IOException e) {
	        System.out.println(e);
	        e.printStackTrace();
	      }
	}
	
	public static String createCSVFile() {
		String fileName = buildFilename();
		formatLogger("New Filename has %s", fileName);
		
		// Check if file exists. If not, then create it
		String filePath = OUTPUT_PATH + fileName;
        try { 
            File f = new File(filePath); 
  
            if (f.createNewFile()) 
            	formatLogger("File Created at %s", filePath);

            else
                formatLogger("Filename '%s' already exists", fileName); 
            	//createCSVFile(); // Try again
        } 
        catch (IOException e) { 
            System.err.println(e); 
            e.printStackTrace();
        }
        
        return filePath;
	}
	
	public static String makeCSVString(ArrayList<String> inputData) {
		String outputData = new String();
		outputData = String.format(
				"%s,%s,%s,%s,%s,%s", 
				inputData.get(0), // startingPlanetaryBody
				inputData.get(1), // endingPlanetaryBody
				inputData.get(2), // Distance between Bodies (km)
				inputData.get(3), // Travel Time (hours)
				inputData.get(4), // Travel Time (days)
				inputData.get(5));// Travel Time (years)
		
		return outputData;
	}
	
	public static void displayTripModalDialog(PlanetaryDialog pd, ArrayList<String> tripDataArray) {
		// helper to display the final results of the trip
		String modalMessageOne = String.format("This trip would take:\n %s hours\nor\n %s days\nor\n %s years", 
				tripDataArray.get(3), tripDataArray.get(4), tripDataArray.get(5));
		pd.showModalDialog(modalMessageOne);
	}
	
	public static void main(String[] args) {
		
		// Trip 1
		PlanetaryDialog pd = new PlanetaryDialog("Get ready for liftoff! Choose your ride, your starting location, and destination!");
		ArrayList<String> tripOneDataArray = calculateTrip(pd);
		String csvStringOne = makeCSVString(tripOneDataArray);
		formatLogger(csvStringOne);
		displayTripModalDialog(pd, tripOneDataArray);
		
		// Trip 2
		String newTripMessage = String.format("Trip 2 - Select next destination! We currently on %s and riding a %s", pd.getDestinationPlanetName(), pd.getTransportationVechicleName());
		PlanetaryDialog pdSecondTrip = new PlanetaryDialog(newTripMessage);
		ArrayList<String> tripTwoDataArray = calculateNextTrip(pdSecondTrip, pd);
		String csvStringTwo = makeCSVString(tripTwoDataArray);
		formatLogger(csvStringTwo);
		displayTripModalDialog(pdSecondTrip, tripTwoDataArray);
		
		// Trip #3
		String newTripMessageThree = String.format("Trip 3 - Select next destination! We currently on %s and riding a %s", pdSecondTrip.getDestinationPlanetName(), pd.getTransportationVechicleName());
		PlanetaryDialog pdFinalTrip = new PlanetaryDialog(newTripMessageThree);
		ArrayList<String> tripThreeDataArray = calculateNextTrip(pdFinalTrip, pdSecondTrip);
		String csvStringThree = makeCSVString(tripThreeDataArray);
		formatLogger(csvStringThree);
		displayTripModalDialog(pdFinalTrip, tripThreeDataArray);
		
		// Create a new *.csv file
		String filepath = createCSVFile();
		
        // Finally, write contents to the file
		String csvHeaders="Starting Planet, Destination Planet, Distance (KM), Travel Time (hours), Travel Time (days), Travel Trime (years)";
        
		writeToCSVFile(filepath, csvHeaders + "\n");
        writeToCSVFile(filepath, csvStringOne+ "\n");
        writeToCSVFile(filepath, csvStringTwo+ "\n");
        writeToCSVFile(filepath, csvStringThree+ "\n");
	}
}



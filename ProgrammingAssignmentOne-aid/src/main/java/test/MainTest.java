package test;

import java.util.ArrayList;
import java.lang.Math;
import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.io.FileWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.*;

import edu.ccri.assignment.files.poi.PoiElementData;
import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;

import planets.data.ExcelFileIO;
import planets.planetai.PlanetaryBody;
import planets.planetai.PlanetaryBodyReader;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;
import planets.util.PlanetaryConstants;
import planets.util.TravelCalculator;
import planets.util.CrewCalculator;
import planets.util.EasyDebugLogger;
import planets.util.TripFileIO;
import planets.util.PlanetaryConversions;

public class MainTest {
	// private static final Logger logger = LogManager.getLogger(MainTest.class.getName());
	
	public static final String PLANET_CSV_FILE = "planet_details.csv";
	public static final String VEHICLE_CSV_FILE = "vehicle_details.csv";
	public static final String DELIMITER = ",";
		
	public static String resourceFolderAbsPath = new File(PlanetaryConstants.RESOURCE_PATH).getAbsolutePath();
	public static String outputFolderAbsPath = new File(PlanetaryConstants.OUTPUT_PATH).getAbsolutePath();
	public static File planetFile = new File(resourceFolderAbsPath, PLANET_CSV_FILE);
	public static File vehicleFile = new File(resourceFolderAbsPath, VEHICLE_CSV_FILE);

	static PlanetaryBodyReader pb = new PlanetaryBodyReader();
	static ArrayList<PlanetaryBody> planetList = pb.readCSV(planetFile.getPath(), DELIMITER);

	static TransportationVehicleReader tv = new TransportationVehicleReader();
	static ArrayList<TransportationVehicle> vehicleList = tv.readCSV(vehicleFile.getPath(), DELIMITER);
	
	static TravelCalculator tc = new TravelCalculator();
	static EasyDebugLogger log = new EasyDebugLogger();
	static TripFileIO io = new TripFileIO();
	//static ExcelFileIO excel = new ExcelFileIO();
	static CrewCalculator cc = new CrewCalculator();
	static PlanetaryConversions pc = new PlanetaryConversions();
	
	
	public static String[] getPlanetData() {
		
		int planetArraySize = planetList.size();
		//String planetaryClass = planetList.;
		String planetArray[] = new String[planetArraySize];

		for (int i=0; i < planetArraySize; i++) {
			PlanetaryBody entry = planetList.get(i);
			log.formatLogger("Entry has %s", entry);
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

	
	public static PlanetaryBody getPlanet(String planet) {
		int arraySize = planetList.size();
		PlanetaryBody matchedPlanet = null;
		
		for (int i = 0; i < arraySize; i++ ) {
			PlanetaryBody entry = planetList.get(i);
			log.formatLogger("Checking line %s for PlanetaryBody %s, found %s", i, planet, entry.getPlanetName());
			if (entry.getPlanetName() == planet) {
				matchedPlanet = planetList.get(i);
				log.formatLogger("Found match for %s on line %s", matchedPlanet, i);
				break;
			}
		}
		
		return matchedPlanet;
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
	
	
	public static ArrayList<Object> calculateTripData(ArrayList<Object> dialogSelections) {
		//TransportationVehicle vehicle, PlanetaryBody startingPlanetaryBody, PlanetaryBody destPlanetaryBody
		TransportationVehicle vehicle = (TransportationVehicle)dialogSelections.get(0);
		PlanetaryBody startingPlanetaryBody = (PlanetaryBody)dialogSelections.get(1);
		PlanetaryBody destPlanetaryBody = (PlanetaryBody)dialogSelections.get(2);
		
		if (startingPlanetaryBody.getPlanetName() == destPlanetaryBody.getPlanetName()) { //ToDo: Fix bug here; startingPlanetaryBody is null
			double distance = TravelCalculator.calculateRelativeDistance(startingPlanetaryBody, destPlanetaryBody);
			log.formatLogger("Distance: %s", distance);
		}
		
		double distance = TravelCalculator.calculateRelativeDistance(startingPlanetaryBody, destPlanetaryBody);
		log.formatLogger("Distance: %s", distance);
		
		double distSunOrigin = startingPlanetaryBody.getDistanceSun();
		double orbitalPeriod = startingPlanetaryBody.getYearLength();
		log.formatLogger("Origin body distance from the Sun: %s km", distSunOrigin);
		log.formatLogger("Orbital period: %s days", orbitalPeriod);
		
		double transportVehicleVelocity = vehicle.getMaxSpeed();
		double orbitalVelocity = TravelCalculator.calculateOrbitalVelocity(distSunOrigin, orbitalPeriod);
		double gav = TravelCalculator.calculateGravityAssistVelocity(orbitalVelocity, transportVehicleVelocity);
		log.formatLogger("Vehicle Velocity: %s km/hr", transportVehicleVelocity);
		log.formatLogger("Orbital Velocity: %s km/hr", orbitalVelocity);
		log.formatLogger("Gravitational Assist Velocity: %s km/hr", gav);
		
		if (gav < 0) {
			// ToDo: Handle negative velocity with a `catch`
			log.formatLogger("We cannot have a negative velocity! Calculated value has %s km/hr, (are we going backwards?)", gav);
		}
		else if (gav >= PlanetaryConstants.SPEED_OF_LIGHT) {
			// ToDo: Handle exceeding lightspeed with a `catch`
			log.formatLogger("We have somehow broke through lightspeed! Achieved a speed of %s km/hr, but sadly this is wrong", gav);
		}
		
		ArrayList<Object> tripDataArray = new ArrayList<Object>();
		
		double tripTimeHours = TravelCalculator.calculateTripTimeHours(gav, distance);
		double tripTimeDays = TravelCalculator.calculateTripTimeDays(gav, distance);
		double tripTimeYears = TravelCalculator.calculateTriptimeYears(gav, distance);
		log.formatLogger("Trip time: %s hours; %s days; %s years", tripTimeHours, tripTimeDays, tripTimeYears);
		
		double crewMembers = vehicle.getCrew();
		log.formatLogger("There are: %s crew members", crewMembers);
		double hourlyWage = vehicle.getSalary();
		log.formatLogger("Hourly wage per crew member is: %s", hourlyWage);
		double mealsPerDay = vehicle.getMealsPerDay();
		log.formatLogger("Number of meals per day: %s", mealsPerDay);
		int payHoursPerDay = vehicle.getPayHoursPerDay();
		log.formatLogger("Number of paid hours for %s per day: %s", vehicle.getVehicleName(), payHoursPerDay);
		
		
		double crewTotalPay = CrewCalculator.calculateCrewTotalSalary(crewMembers, hourlyWage, tripTimeDays, payHoursPerDay);
		log.formatLogger("Total crew salary for %s crew members is $%s", crewMembers, crewTotalPay);
		double dailyFoodCost = CrewCalculator.calculateCrewFoodCost(crewMembers, transportVehicleVelocity, orbitalVelocity, mealsPerDay);
		log.formatLogger("Daily food cost for %s crew members is $ %s", crewMembers, dailyFoodCost);
		double crewTotalPayEuro = pc.MetricToImperialConversions(crewTotalPay);
		log.formatLogger("Total crew salary in Euros for %s crew members is €%s", crewMembers, crewTotalPayEuro);
		
		if (crewTotalPay > 1000000) {
			// ToDo: Handle excess salary
			log.formatLogger("The total pay of %s exceeds the maximum allowed value of $1,000,000", crewTotalPay);
			}
		else if (crewTotalPay < 0) {
			// ToDo
			log.formatLogger("The total pay of %s is negative - must get paid something.", crewTotalPay);
			}
		
		tripDataArray.add(startingPlanetaryBody.getPlanetName());
		tripDataArray.add(destPlanetaryBody.getPlanetName());
		tripDataArray.add(distance);
		tripDataArray.add(tripTimeHours);
		tripDataArray.add(tripTimeDays);
		tripDataArray.add(tripTimeYears);
		tripDataArray.add(crewMembers);
		tripDataArray.add(crewTotalPay);
		tripDataArray.add(crewTotalPayEuro);
		
		return tripDataArray;
	}
	
	public static ArrayList<Object> getInitialDialogOptions(PlanetaryDialog pd) {
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
		
		double crewMembers = vehicle.getCrew();
		
		log.formatLogger("Chosen vehicle: %s; starting planet %s; ending %s; crew members %s", chosenVehicle, startingPlanetName, destPlanetName, crewMembers);

		ArrayList<Object> tripDataArray = new ArrayList<Object>();
		
		tripDataArray.add(vehicle);
		tripDataArray.add(startingPlanetaryBody);
		tripDataArray.add(destPlanetaryBody);

		
		// ToDo: Handle the stop button
		return tripDataArray;
	}
	
	public static ArrayList<Object> getNextDialogOptions(PlanetaryDialog pd, PlanetaryDialog pdPrevious) {
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
		
		double crewMembers = vehicle.getCrew();
		
		log.formatLogger("Chosen vehicle: %s; starting planet %s; ending %s; crew members %s", chosenVehicle, startingPlanetName, destPlanetName, crewMembers);

		ArrayList<Object> tripDataArray = new ArrayList<Object>();
		
		tripDataArray.add(vehicle);
		tripDataArray.add(startingPlanetaryBody);
		tripDataArray.add(destPlanetaryBody);
		
		// ToDo: Handle the stop button
		return tripDataArray;
	}
	
	
	public static void displayTripModalDialog(PlanetaryDialog pd, ArrayList<Object> tripDataArray) {
		// helper to display the final results of the trip
		String modalMessageOne = String.format("This trip would take:\n %.2f hours\nor\n %.2f days\nor\n %.2f years\n"
												+ "There is/are\n %.2f\n crew members being paid\n $%.2f\nor\n€%.2fs\n for this trip.", 
				tripDataArray.get(3), tripDataArray.get(4), tripDataArray.get(5), tripDataArray.get(6), tripDataArray.get(7), tripDataArray.get(8));
		pd.showModalDialog(modalMessageOne);
	}
	
	private static ArrayList<Object> makeHeaders(){
		ArrayList<Object> headers = new ArrayList<Object>();
		headers.add("Starting Planet");
		headers.add("Destination Planet");
		headers.add("Distance (KM)");
		headers.add("Travel Time (hours)");
		headers.add("Travel Time (days)");
		headers.add("Travel Time (years)");
		headers.add("Total Crew Members");
		headers.add("Total Crew Salary ($)");
		headers.add("Total Crew Salary (€)");
		return headers;
	}
	public static void main(String[] args) {
		
		// Open import Excel File
        ExcelFileIO ex = new ExcelFileIO();
        ex.readFileDetails();
        
        // Create a new ArrayList "lists of lists" for *.xlsx file
        ArrayList<Object> headers = makeHeaders();
        ArrayList<ArrayList<Object>> dataList = new ArrayList<ArrayList<Object>>();
        dataList.add(headers);
        
		// Trip #1 --------------
		PlanetaryDialog pd = new PlanetaryDialog("Get ready for liftoff! Choose your ride, your starting location, and destination!");
		ArrayList<Object> dialogSelections = getInitialDialogOptions(pd);		
		
		ArrayList<Object> tripOneDataArray = calculateTripData(dialogSelections);
		dataList.add(tripOneDataArray);
		displayTripModalDialog(pd, tripOneDataArray);	
		
		// Trip #2 --------------
		String newTripMessage = String.format("Trip 2 - Select next destination! We currently on %s and riding a %s", pd.getDestinationPlanetName(), pd.getTransportationVechicleName());
		PlanetaryDialog pdSecondTrip = new PlanetaryDialog(newTripMessage);
		ArrayList<Object> dialogSelectionsTwo = getNextDialogOptions(pdSecondTrip, pd);
		
		ArrayList<Object> tripTwoDataArray = calculateTripData(dialogSelectionsTwo);
		dataList.add(tripTwoDataArray);
		displayTripModalDialog(pdSecondTrip, tripTwoDataArray);
		
		// Trip #3 --------------
		String newTripMessageThree = String.format("Trip 3 - Select next destination! We currently on %s and riding a %s", pdSecondTrip.getDestinationPlanetName(), pd.getTransportationVechicleName());
		PlanetaryDialog pdFinalTrip = new PlanetaryDialog(newTripMessageThree);
		ArrayList<Object> dialogSelectionsThree = getNextDialogOptions(pdFinalTrip, pdSecondTrip);
		
		ArrayList<Object> tripThreeDataArray = calculateTripData(dialogSelectionsThree);
		dataList.add(tripThreeDataArray);
		displayTripModalDialog(pdFinalTrip, tripThreeDataArray);
	
		// Finally, add `dataList` to Excel Output
		String worksheet = "Trip Summary";
        ExcelFileIO.excelOutputResults(dataList, worksheet);
	}
}



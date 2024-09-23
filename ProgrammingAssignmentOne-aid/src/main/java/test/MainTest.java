package test;

import java.util.ArrayList;
import java.lang.Math;
import java.io.File;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;
import planets.planetai.PlanetaryBody;
import planets.planetai.PlanetaryBodyReader;

public class MainTest {
	private static final Logger logger = LogManager.getLogger(MainTest.class.getName());

	// ToDo: Make this get the CSV better
	public static final String RESOURCE_FOLDER = "src\\main\\resources\\in\\";
	public static final String OUTPUT_FOLDER = "src\\main\\resources\\out\\";
	public static final String PLANET_CSV_FILE = "planet_details.csv";
	public static final String VEHICLE_CSV_FILE = "vehicle_details.csv";
	public static final String DELIMITER = ",";
	public static final int MIN_FILE_NUMBER = 1;
	public static final int MAX_FILE_NUMBER = 21;	

	public static final int SECONDS_IN_A_DAY = 86400;
	public static final int HOURS_IN_A_DAY = 24;
	public static final int DAYS_IN_A_YEAR = 365;

	public static final double METERS_TO_KILOMETERS_FACTOR = 3.6;
	public static final double KG_TO_LB_FACTOR = 2.2046;
	public static final double LN_TO_KG_FACTOR = 0.4536;
	public static final double KM_TO_MI_FACTOR = 0.6214;
	public static final double MI_TO_KM_FACTOR = 1.6093;

	public static final double SPEED_OF_LIGHT = 1080000000; // km/hr

	public static String resourceFolderAbsPath = new File(RESOURCE_FOLDER).getAbsolutePath();
	public static String outputFolderAbsPath = new File(OUTPUT_FOLDER).getAbsolutePath();
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
	
	public static double[] doActualCalculations(TransportationVehicle vehicle, PlanetaryBody startingPlanetaryBody, PlanetaryBody destPlanetaryBody) {
		
		if (startingPlanetaryBody.getPlanetName() == destPlanetaryBody.getPlanetName()) {
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
		
		double timeArray[] = new double[3];
		
		double tripTimeHours = calculateTripTimeHours(gav, distance);
		double tripTimeDays = calculateTripTimeDays(gav, distance);
		double tripTimeYears = calculateTriptimeYears(gav, distance);
		formatLogger("Trip time: %s hours; %s days;   %s years", tripTimeHours, tripTimeDays, tripTimeYears);
		
		timeArray[0] = tripTimeHours;
		timeArray[1] = tripTimeDays;
		timeArray[2] = tripTimeYears;
		
		return timeArray;
	}
	
	public static double[] calculateTrip(PlanetaryDialog pd) {
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

		double timeArray[] = doActualCalculations(vehicle, startingPlanetaryBody, destPlanetaryBody);

		// ToDo: Handle the stop button
		
		return timeArray;
	}
	
	public static double[] calculateNextTrip(PlanetaryDialog pd, PlanetaryDialog pdPrevious) {
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
		
		double timeArray[] = doActualCalculations(vehicle, startingPlanetaryBody, destPlanetaryBody);
		
		return timeArray;
	}
	
	public static String buildFilename() {
		String fixedName = "ProcessedData";
		Random random = new Random();
		int randomNumber = random.nextInt(20) + 1; // Adding 1 as a hack because this function's range starts at 0
		String filename = String.format("%s%s.csv", fixedName, randomNumber);
		
		return filename;
	}
	
	public static String writeCSVFile(String data) {
		
		return "";
	}
	
	public static void main(String[] args) {
		String csvOutputHeader = buildFilename();
		formatLogger("The new filename has %s", csvOutputHeader);
		
		PlanetaryDialog pd = new PlanetaryDialog("Get ready for liftoff! Choose your ride, your starting location, and destination!");
		double tripOneTimeArray[] = calculateTrip(pd);
		double hours = tripOneTimeArray[0];
		double days = tripOneTimeArray[1];
		double years = tripOneTimeArray[2];
		String modalMessage = String.format("The first trip would take %s hours or %s days or %s years", hours, days, years);
		pd.showModalDialog(modalMessage);

		// Trip 2
		String newTripMessage = String.format("Trip 2 - Select next destination! We currently on %s and riding a %s", pd.getDestinationPlanetName(), pd.getTransportationVechicleName());
		PlanetaryDialog pdSecondTrip = new PlanetaryDialog(newTripMessage);
		double tripTwoTimeArray[] = calculateNextTrip(pdSecondTrip, pd);
		double hoursTwo = tripTwoTimeArray[0];
		double daysTwo = tripTwoTimeArray[1];
		double yearsTwo = tripTwoTimeArray[2];
		String modalMessageTwo = String.format("The second trip would take %s hours or %s days or %s years", hoursTwo, daysTwo, yearsTwo);
		pd.showModalDialog(modalMessageTwo);
		
		// ToDo: Trip #3 (basically repeat step 2)
		String newTripMessageThree = String.format("Trip 3 - Select next destination! We currently on %s and riding a %s", pdSecondTrip.getDestinationPlanetName(), pd.getTransportationVechicleName());
		PlanetaryDialog pdFinalTrip = new PlanetaryDialog(newTripMessageThree);
		double tripThreeTimeArray[] = calculateNextTrip(pdFinalTrip, pdSecondTrip);
		double hoursThree = tripThreeTimeArray[0];
		double daysThree = tripThreeTimeArray[1];
		double yearsThree = tripThreeTimeArray[2];
		String modalMessageThree = String.format("The third trip would take %s hours or %s days or %s years", hoursThree, daysThree, yearsThree);
		pd.showModalDialog(modalMessageThree);
		
		//Get the results and format them

		// tripOne details, tripTwo details, tripThree details - ship, starting dest, ending dest, distance, travel times for h, d, y
		
		// ToDo: make a message formatter to format all the results to a CSV
		// Output to a CSV file with a random number between 1-21, formatted as <fixed><random>.csv (e.g. ProcessedData17.csv)
		
	}
}



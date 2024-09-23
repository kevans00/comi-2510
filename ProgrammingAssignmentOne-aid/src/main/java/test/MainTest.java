package test;

import java.util.ArrayList;
import java.lang.Math;

import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;
import planets.planetai.PlanetaryBody;
import planets.planetai.PlanetaryBodyReader;

public class MainTest {
	
// ToDo: Make this get the CSV better
public static final String PLANET_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\planetai\\\\planet_details.csv";
public static final String VEHICLE_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\transportation\\\\vehicle_details.csv";
public static final String DELIMITER = ",";
public static final int SECONDS_IN_A_DAY = 86400;
public static final int HOURS_IN_A_DAY = 24;
public static final int DAY_IN_A_YEAR = 365;
public static final double METERS_TO_KILOMETERS_FACTOR = 3.6;
public static final double KG_TO_LB_FACTOR = 2.2046;
public static final double LN_TO_KG_FACTOR = 0.4536;
public static final double KM_TO_MI_FACTOR = 0.6214;
public static final double MI_TO_KM_FACTOR = 1.6093;

static PlanetaryBodyReader pb = new PlanetaryBodyReader();
static ArrayList<PlanetaryBody> planetList = pb.readCSV(PLANET_CSV, DELIMITER);

static TransportationVehicleReader tv = new TransportationVehicleReader();
static ArrayList<TransportationVehicle> vehicleList = tv.readCSV(VEHICLE_CSV, DELIMITER);

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
	
	public static double calculateOrbitalVelocity(double distFromSun, int orbitalPeriod) {
		double orbitalVelocity = (METERS_TO_KILOMETERS_FACTOR * Math.sqrt((2 * Math.PI * distFromSun) / (orbitalPeriod * SECONDS_IN_A_DAY)));
		
		return orbitalVelocity; // returns in km/h
	}
	
	public static double caculateGravityAssistVelocity(double orbitalVelocity, double transportVehicleVelocity) {
		double gav = (2 * orbitalVelocity) + transportVehicleVelocity;
		return gav;
	}
	
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
	}
	
	public static double calculateTripTime(double velocity, double distance) {
		double time = 0.0;
		
		return time; // in hours
	}
	
	/*
	public static double calculateRelativeDistance(double referenceObject, double objectOneDist, double objectTwoDist) {
		
		
		if (referenceOjbect)
		
		double objectOneDistFromRef = 
		Math.abs()
		return 0.0;
	}*/
	
	public static void main(String[] args) {

		PlanetaryDialog pd = new PlanetaryDialog("Planetary Body Calculator");
		
		String[] planetData = getPlanetData();
		String[] vehicleData = getVehicleData();
		
		pd.setUseTransporationVehicle();
		pd.setUseStartingPlanet();
		pd.setUseDestinationPlanet();

		pd.showMultiEditDialog(planetData, vehicleData);
		
		String chosenVehicle = pd.getTransportationVechicleName();
		String startingPlanet = pd.getStartingPlanetName();
		String endingPlanet = pd.getDestinationPlanetName();
		
		//New psuedocode:
		//CalculateDistance();
		//CalculateTripTime();
		//Handle other misc calculations
		//Get the results and format them
		
		// ToDo: make a message formatter to format all the results?
		pd.showModalDialog("test");
		
	}
}



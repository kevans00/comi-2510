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



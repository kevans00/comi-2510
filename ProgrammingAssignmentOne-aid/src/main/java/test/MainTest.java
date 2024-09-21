package test;

import java.util.ArrayList;
import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;
import planets.planetai.PlanetaryBody;
import planets.planetai.PlanetaryBodyReader;

public class MainTest {
	
public static final String PLANET_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\planetai\\\\planet_details.csv";
public static final String VEHICLE_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\transportation\\\\vehicle_details.csv";
public static final String COMMA_DELIMITER = ",";

	public static void main(String[] args) {

		TransportationVehicleReader reader = new TransportationVehicleReader();
		PlanetaryDialog pd = new PlanetaryDialog("Creating Planetary Dialog");
		
			//Planet getName
			//Planet getDistanceFromSun & getDistanceFromEarth
		//Ask user "Chose your starting planet"
			//Store in startingPlanet
		//Ask user "Chose your destination planet"
			//Store in destinationPlanetOne
		//Ask user "Chose your ship"
			//Store in userShip - doesn't change
		//Inform user of valid range values
		//Calculate ship speed with drag
		//Display time it takes to get to planet
			//Store in time
		//Repeat but start at destinationPlanetOne
		//Ask user "Chose the next destination"
			//Store in destinationPlanetTwo
		//Calculate ship speed with drag
		//Display time it takes to get to planet
			//Store in timeTwo - time = time + timeTwo
		//Repeat but start at destinationPlanetTwo
		//Ask user "Chose the final destination"
			//Store in destinationPlanetThree
		//Calculate ship speed with drag
		//Display total trip time
			//Store in timeThree - time = time + timeThree
		
		pd.getDestinationPlanetName();
		pd.getTransportationVechicleName();
		pd.getDestinationPlanetName();
		
		final String DELIMITER = ",";
		String FILE_LOCATION = "C:\\Users\\Lenovo ThinkPad T430\\eclipse-workspace\\ProgrammingAssignmentOne-aid\\src\\main\\java\\planets\\transportation\\vehicle_details.csv";
		
		ArrayList<TransportationVehicle> list = null;
		TransportationVehicle selectedVehicle = null;
		
		list = reader.readCSV(FILE_LOCATION, DELIMITER);
		selectedVehicle = list.get(1);
		
		for (TransportationVehicle detail:list) {

			if (detail.getMaxSpeed() < 10000)
			{
				System.out.println(detail.getMaxSpeed() + " is less than 10,000");
			}
		}
		
		System.out.println("Vehicle at Index 1 is " + selectedVehicle.getVehicleName());
	}
	
	public ArrayList<PlanetaryBody> GetPlanetData() {
		PlanetaryBodyReader pb = new PlanetaryBodyReader();
		ArrayList<PlanetaryBody> plist = null;
		plist = pb.readCSV(PLANET_CSV, COMMA_DELIMITER);
		
		return plist;
		}
		
	public ArrayList<TransportationVehicle> GetVehicleData() {
		TransportationVehicleReader tv = new TransportationVehicleReader();
		ArrayList<TransportationVehicle> vlist = null;
		vlist = tv.readCSV(VEHICLE_CSV, COMMA_DELIMITER);
		
		return vlist;
	}
	
	}



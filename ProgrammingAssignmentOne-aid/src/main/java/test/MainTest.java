package test;

import java.util.ArrayList;
import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;

public class MainTest {

	public static String GetData() {
		
		return "test eat my dick";
	};
	
	
	
	public static void main(String[] args) {

		final int VELOCITY_MIN = 0;
		final int VELOCITY_MAX = 1080000000;
		TransportationVehicleReader reader = null;
		PlanetaryDialog pd = null;
		
		reader = new TransportationVehicleReader();
		pd = new PlanetaryDialog("Test");
		
		
		String test = GetData();
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
		
		list = reader.readCSV(FILE_LOCATION, DELIMITER);
		
		for (TransportationVehicle detail:list) {
			//print(detail)
			if (detail.getMaxSpeed() < 10000)
			{
				System.out.println(detail.getMaxSpeed() + " is less than 10,000");
				System.out.println("Hey, " + test);
			}
			//System.out.println(detail.getMaxSpeed());		//See if we can print out all of the detail items
			
			}
		}
	}



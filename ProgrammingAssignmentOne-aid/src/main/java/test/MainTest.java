package test;

import java.util.ArrayList;

import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;

public class MainTest {

	public static void main(String[] args) {
		// Load data
		//Ask user "Chose your starting planet"
		//Ask user "Chose your destination planet"
		//Ask user "Chose your ship"
		//Inform user of valid range values
		
		final int VELOCITY_MIN = 0;
		final int VELOCITY_MAX = 1080000000;

		TransportationVehicleReader reader = new TransportationVehicleReader();
	
		final String DELIMITER = ",";
		String FILE_LOCATION = "C:\\Users\\Lenovo ThinkPad T430\\eclipse-workspace\\ProgrammingAssignmentOne-aid\\src\\main\\java\\planets\\transportation\\vehicle_details.csv";
		ArrayList<TransportationVehicle> list = null;
		
		list = reader.readCSV(FILE_LOCATION, DELIMITER);
		
		for (TransportationVehicle detail:list) {
			//print(detail)
			if (detail.getMaxSpeed() < 10000)
			{
				System.out.println(detail.getMaxSpeed() + " is less than 10,000");
			}
			//System.out.println(detail.getMaxSpeed());		//See if we can print out all of the detail items
			
			}
		}
	}



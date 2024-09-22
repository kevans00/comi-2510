package test;

import java.util.ArrayList;
import javax.swing.JFrame; 
import javax.swing.JComboBox;

import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;
import planets.planetai.PlanetaryBody;
import planets.planetai.PlanetaryBodyReader;
import planets.util.DialogFrame;

public class MainTest {
	
public static final String PLANET_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\planetai\\\\planet_details.csv";
public static final String VEHICLE_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\transportation\\\\vehicle_details.csv";
public static final String COMMA_DELIMITER = ",";

	public static void makeFrame() {
		JFrame frame = new JFrame(); // Create frame object
		frame.setTitle("Planetary Travel Calculator"); // Set title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application 'X'-out button; otherwise program will remain 'open' (hidden) when 'X' is pressed
		frame.setResizable(false); // Prevent resizing of window (for now?)
		frame.setSize(400,400); // Set size to be 200x200 pixels

		// Add things into the frame; Invoked via new method for cleanliness ;)
		// ToDo: Change this to grab the actual vehicle values
		String[] vehicles = {"GR86", "Jetpack"};
		
		// Create a combo box (drop-down box element)
		JComboBox jcb = new JComboBox(vehicles);
		
		frame.add(jcb); // add Combo box to the existing frame
		frame.pack(); // Causes Window to be sized to fit the preferred size and layout of its subcomponents. Try commenting this out.
		
		// Make the frame object visible. 
		// NOTE: setVisible must be run last. Otherwise anything items added to the box after this line 
		// won't be visible because it 'technically' wasn't told to be visible later
		frame.setVisible(true);  
	}

	public static void makeVehicleArray() {
		
	}
	
	public static void main(String[] args) {

		TransportationVehicleReader reader = new TransportationVehicleReader();
		PlanetaryDialog pd = new PlanetaryDialog("Creating Planetary Dialog");
		
		// Create Frame
		//makeFrame();
		///makeVehicleArray();
		// Get Data
		// Fill Frame with data
		
		// --------
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
		int arraySize = list.size();
		
		TransportationVehicle vehicleArray[] = new TransportationVehicle[arraySize];
		
		// Add only vehicles from list to the array
		for (int i=0; i < arraySize; i++) {
			vehicleArray[i] = list.get(i);
		}
		
		for (int i=0; i <= arraySize; i++) {
			System.out.printf("Vehicle at Index %s is %s", String.valueOf(i), vehicleArray[i].getVehicleName());
		}
		
		// new DialogFrame();
	}
	
	public ArrayList<PlanetaryBody> GetPlanetData() {
		PlanetaryBodyReader pb = new PlanetaryBodyReader();
		ArrayList<PlanetaryBody> planetList = null;
		planetList = pb.readCSV(PLANET_CSV, COMMA_DELIMITER);
		
		return planetList;
		}
		
	public ArrayList<TransportationVehicle> GetVehicleData() {
		TransportationVehicleReader tv = new TransportationVehicleReader();
		ArrayList<TransportationVehicle> vehicleList = null;
		vehicleList = tv.readCSV(VEHICLE_CSV, COMMA_DELIMITER);
		
		return vehicleList;
	}
	
}



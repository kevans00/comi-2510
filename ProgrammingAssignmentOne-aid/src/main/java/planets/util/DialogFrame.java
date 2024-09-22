package planets.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;

import java.util.ArrayList;

import planets.planetai.PlanetaryBodyReader;
import planets.transportation.TransportationVehicle;
import planets.transportation.TransportationVehicleReader;

public class DialogFrame extends JFrame implements ActionListener{
	public static final String PLANET_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\planetai\\\\planet_details.csv";
	public static final String VEHICLE_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\transportation\\\\vehicle_details.csv";
	public static final String COMMA_DELIMITER = ",";

	JComboBox jcb;
	JLabel chooseVehicleLabel;
	JLabel vehicleSelectLabel;
	
	DialogFrame() {
		
		TransportationVehicleReader reader = new TransportationVehicleReader();
		ArrayList<TransportationVehicle> list = null;
		list = reader.readCSV(VEHICLE_CSV, COMMA_DELIMITER);
		int arraySize = list.size();
		String vehicleArray[] = new String[arraySize];
		
		// Add only vehicles from list to the array
		for (int i=0; i < arraySize; i++) {
			TransportationVehicle entry = list.get(i);
			vehicleArray[i] = entry.getVehicleName();
		}
		
		this.setTitle("Planetary Travel Calculator"); // Set title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application 'X'-out button; otherwise program will remain 'open' (hidden) when 'X' is pressed
		this.setResizable(false); // Prevent resizing of window (for now?)
		this.setSize(500,500); // Set size to be 200x200 pixels
		//frame.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		// Add things into the frame; Invoked via new method for cleanliness ;)
		// ToDo: Change this to grab the actual vehicle values
		//JLabel chooseVehicleText = new JLabel("Test");
		
		// Create a combo box (drop-down box element)
		chooseVehicleLabel = new JLabel("Select your Vehicle", JLabel.CENTER);
		vehicleSelectLabel = new JLabel("You have selected: ", JLabel.CENTER);
		jcb = new JComboBox(vehicleArray);
		jcb.setBounds(200, 200, 200, 40);
		
		this.add(chooseVehicleLabel);
		this.add(jcb); // add Combo box to the existing frame
		this.add(vehicleSelectLabel);
		//this.pack(); // Causes Window to be sized to fit the preferred size and layout of its subcomponents. Try commenting this out.
		
		// Make the frame object visible. 
		// NOTE: setVisible must be run last. Otherwise anything items added to the box after this line 
		// won't be visible because it 'technically' wasn't told to be visible later
		this.setVisible(true);  
	}
	
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource()==planetBox) {
		//System.out.println(planetBox.getSelectedItem());
		
		//if(e.getSource()==vehicleBox) {
		//System.out.println(vehicleBox.getSelectedItem());
	}
	
	public static void main(String[] args) {
		new DialogFrame();
	}
	
}

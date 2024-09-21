package planets.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.ccri.assignment.planets.test.dialog.PlanetaryDialog;

import java.util.ArrayList;

import planets.planetai.PlanetaryBodyReader;
import planets.transportation.TransportationVehicleReader;

public class DialogFrame extends JFrame implements ActionListener {
	public static final String PLANET_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\planetai\\\\planet_details.csv";
	public static final String VEHICLE_CSV = "C:\\\\Users\\\\Lenovo ThinkPad T430\\\\eclipse-workspace\\\\ProgrammingAssignmentOne-aid\\\\src\\\\main\\\\java\\\\planets\\\\transportation\\\\vehicle_details.csv";
	public static final String COMMA_DELIMITER = ",";
	
	
	//I need to be able to assign the first line of the csv into an array variable so I can feed it into the dialog frame
	//csvPlanetFirstLine(planet_csv, delimiter) = planetFirstLine
	//csvVehicleFirstLine(vehicle_csv, delimiter) = vehicleFirstLine
	
	PlanetaryBodyReader br = null;
	TransportationVehicleReader reader = new TransportationVehicleReader();
	PlanetaryDialog pd = new PlanetaryDialog("Creating Planetary Dialog");
	
	
	public DialogFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		//ArrayList planetFirstLine<PlanetaryBody> = br.csvPlanetFirstLine(PLANET_CSV, COMMA_DELIMITER);
		//JComboBox planetBox = new JComboBox(planetFirstLine);
		//planetBox.addActionListener(this);
		//JComboBox vehicleBox = new JComboBox(vehicleFirstLine);
		//vehicleBox.addActionListener(this);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource()==planetBox) {
		//System.out.println(planetBox.getSelectedItem());
		
		//if(e.getSource()==vehicleBox) {
		//System.out.println(vehicleBox.getSelectedItem());
	}
}

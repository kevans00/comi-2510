package planets.transportation;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import planets.planetai.PlanetaryBodyReader;

/**
 * This class creates a TransportationVehicleReader object that reads CSV files into an Array List
 */
public class TransportationVehicleReader {

	private static final Logger logger = LogManager.getLogger(TransportationVehicleReader.class.getName());
	
	//Create string lists for main classification groups
	List<String> AIR_LIST = Arrays.asList("Starship", "Spacecraft", "Aircraft", "Helicopter", "Drone");
	List<String> LAND_LIST = Arrays.asList( "Train", "Bus", "Car", "Motorcycle", "Moon Rover" );
	List<String> SEA_LIST = Arrays.asList( "Submarine", "Cruise Ship", "Boat" );
	
	/**
	 * Default constructor
	 */
	public TransportationVehicleReader() {}
	
	/**
	 * This method opens a CSV file to read and assigns the proper fields to an Array of TransportationVehicle objects
	 * @param csvFile
	 * @param delimiter
	 * @return list
	 */
	public ArrayList<TransportationVehicle> readCSV(String csvFile, String delimiter){
		ArrayList<TransportationVehicle> list = new ArrayList<TransportationVehicle>();
		TransportationVehicle detail = null;
		LineNumberReader ln = null;
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
						
			ln = new LineNumberReader(fr);

			String line = "";
			String[] tempArr;
			
			line = ln.readLine();
			TransportationVehicleReader.logger.debug("Header has line number " + ln.getLineNumber() + " has: " + line);
			TransportationVehicleReader.logger.debug("Beginning Object Classifications");
			
			while ((line = ln.readLine()) != null) {
				TransportationVehicleReader.logger.debug("Line number " + ln.getLineNumber() + " has: " + line);	
				tempArr = line.split(delimiter);
				String classification = tempArr[1];
				TransportationVehicleReader.logger.debug("Classification has " + classification);
				
				//Create Transportation Vehicle object based on classification
				if (AIR_LIST.contains(classification)) {
					TransportationVehicleReader.logger.debug("Creating Air Vehicle object");
					
					detail = new AirVehicle(
							tempArr[0], 
							tempArr[1], 
							Double.parseDouble(tempArr[2]), 
							Double.parseDouble(tempArr[3]), 
							Double.parseDouble(tempArr[4]), 
							Double.parseDouble(tempArr[5]), 
							Double.parseDouble(tempArr[6]), 
							Double.parseDouble(tempArr[7]), 
							Double.parseDouble(tempArr[8]));
					}
				
				else if (LAND_LIST.contains(classification)) {
					TransportationVehicleReader.logger.debug("Creating Land Vehicle object");
					
					detail = new LandVehicle(
							tempArr[0], 
							tempArr[1], 
							Double.parseDouble(tempArr[2]), 
							Double.parseDouble(tempArr[3]), 
							Double.parseDouble(tempArr[4]), 
							Double.parseDouble(tempArr[5]), 
							Double.parseDouble(tempArr[6]), 
							Double.parseDouble(tempArr[7]), 
							Double.parseDouble(tempArr[8]));
					}
		
				else if (SEA_LIST.contains(classification)) {
					TransportationVehicleReader.logger.debug("Creating Sea Vehicle object");
					
					detail = new SeaVehicle(
							tempArr[0], 
							tempArr[1], 
							Double.parseDouble(tempArr[2]), 
							Double.parseDouble(tempArr[3]), 
							Double.parseDouble(tempArr[4]), 
							Double.parseDouble(tempArr[5]), 
							Double.parseDouble(tempArr[6]), 
							Double.parseDouble(tempArr[7]), 
							Double.parseDouble(tempArr[8]));
					}
						list.add(detail);
			}
			ln.close();	
		} catch (IOException ioe)
		{							//ToDo : Fix exception here
			ioe.printStackTrace();
		} finally
		{
			if (null != ln)
			{
				try
				{
					ln.close();
				} catch (IOException ioe)
				{ 							//ToDo : Fix exception here
					ioe.printStackTrace();
				}
			}
		}
		
		return list;
	}
}




package planets.planetai;
import planets.planetai.PlanetaryBody;
import planets.transportation.TransportationVehicleReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// import edu.ccri.assignment.planets.data.DataAccessOperations;


/**
 * This class creates a PlanetaryBodyReader object that reads CSV files into an ArrayList
 */
public class PlanetaryBodyReader {
	private static final Logger logger = LogManager.getLogger(PlanetaryBodyReader.class.getName());
		 
	/**
	 * Default Constructor
	 */
	public PlanetaryBodyReader() {}
	
	/**
	 * This method opens a CSV file to read and assigns the proper fields to an Array of PlanetaryBody objects
	 * @param csvFile
	 * @param delimiter
	 * @return list
	 */
	public ArrayList<PlanetaryBody> readCSV(String csvFile, String delimiter){
		ArrayList<PlanetaryBody> list = new ArrayList<PlanetaryBody>();
		PlanetaryBody detail = null;
		LineNumberReader ln = null;
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			
			ln = new LineNumberReader(fr);
			
			String line = "";
			String[] tempArr;
			
			line = ln.readLine();
			PlanetaryBodyReader.logger.debug("Header has line number " + ln.getLineNumber() + " has: " + line);
			PlanetaryBodyReader.logger.debug("Beginning Object Classifications");
			
			while ((line = ln.readLine()) != null) {
				PlanetaryBodyReader.logger.debug("Line number " + ln.getLineNumber() + " has: " + line);
				tempArr = line.split(delimiter);
				String classification = tempArr[1];
				PlanetaryBodyReader.logger.debug("Classification has " + classification);
				
				//Create Planetary Body object based on classification
				if (classification.contains("Dwarf")) {
					PlanetaryBodyReader.logger.debug("Creating Dwarf planet object");

					detail = new DwarfPlanet(
							tempArr[0], 
							tempArr[1], 
							Double.parseDouble(tempArr[2]), 
							Double.parseDouble(tempArr[3]), 
							Double.parseDouble(tempArr[4]), 
							Double.parseDouble(tempArr[5]), 
							Double.parseDouble(tempArr[6]), 
							Double.parseDouble(tempArr[7]), 
							Double.parseDouble(tempArr[8]), 
							Double.parseDouble(tempArr[9]));
				}
				
				else if (classification.contains("Planet")) {
					PlanetaryBodyReader.logger.debug("Creating Planet object");

					detail = new Planet(
							tempArr[0], 
							tempArr[1], 
							Double.parseDouble(tempArr[2]), 
							Double.parseDouble(tempArr[3]), 
							Double.parseDouble(tempArr[4]), 
							Double.parseDouble(tempArr[5]), 
							Double.parseDouble(tempArr[6]), 
							Double.parseDouble(tempArr[7]), 
							Double.parseDouble(tempArr[8]), 
							Double.parseDouble(tempArr[9]));
				}
				
				else if (classification.contains("Moon")) {
					PlanetaryBodyReader.logger.debug("Creating Moon planet object");

					detail = new Moon(
							tempArr[0], 
							tempArr[1], 
							Double.parseDouble(tempArr[2]), 
							Double.parseDouble(tempArr[3]), 
							Double.parseDouble(tempArr[4]), 
							Double.parseDouble(tempArr[5]), 
							Double.parseDouble(tempArr[6]), 
							Double.parseDouble(tempArr[7]), 
							Double.parseDouble(tempArr[8]), 
							Double.parseDouble(tempArr[9]));
				}
				
				PlanetaryBodyReader.logger.debug("Detail has " + detail);

				list.add(detail);
			}
			
			ln.close();
		} catch (IOException ioe)		//ToDo : Fix exception here
		{
			ioe.printStackTrace();
		} finally
		{
			if (null != ln)
			{
				try
				{
					ln.close();
				} catch (IOException ioe)	//ToDo: Fix exception here
				{
					ioe.printStackTrace();
				}
			}
		}
		return list;
	}	
	
	public static void loadPlanetNamesArray() {
	}
	
}
	



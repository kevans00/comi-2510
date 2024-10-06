package planets.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.File;

import planets.util.EasyDebugLogger;
import planets.util.PlanetaryConstants;

import edu.ccri.assignment.files.poi.AbstractPoiTestDataSource;
import edu.ccri.assignment.files.poi.AbstractPoiWriteElementDataList;
import edu.ccri.assignment.files.poi.PoiElementData;
import edu.ccri.assignment.planets.data.DataAccessOperations;


public class TripFileIO extends AbstractPoiTestDataSource {
	
	public static final int MIN_FILE_NUMBER = 1;
	public static final int MAX_FILE_NUMBER = 21;
	
	public static EasyDebugLogger log = new EasyDebugLogger();
	public static PlanetaryConstants pc = new PlanetaryConstants();

	public TripFileIO() {}
	
	public static String buildCSVFilename() {
		String fixedName = "ProcessedData";
		Random random = new Random();
		int randomNumber = random.nextInt(MAX_FILE_NUMBER) + 1; // Adding 1 as a hack because this function's range is [0, 21)
		String filename = String.format("%s%s.csv", fixedName, randomNumber);
		
		return filename;
	}
	
	public static String createCSVFile() {
		String fileName = buildCSVFilename();
		log.formatLogger("New Filename has %s", fileName);
		
		// Check if file exists. If not, then create it
		String filePath = PlanetaryConstants.OUTPUT_PATH + fileName;
        try { 
            File f = new File(filePath); 
  
            if (f.createNewFile()) 
            	log.formatLogger("File Created at %s", filePath);

            else
                log.formatLogger("Filename '%s' already exists", fileName); 
            	//createCSVFile(); // Try again
        } 
        catch (IOException e) { 	//ToDo - Fix this Exception
            System.err.println(e); 
            e.printStackTrace();
        }
        
        return filePath;
	}

	public static String makeCSVString(ArrayList<Object> inputData) {
		String outputData = new String();
		outputData = String.format(
				"%s,%s,%s,%s,%s,%s", 
				inputData.get(0), // startingPlanetaryBody
				inputData.get(1), // endingPlanetaryBody
				inputData.get(2), // Distance between Bodies (km)
				inputData.get(3), // Travel Time (hours)
				inputData.get(4), // Travel Time (days)
				inputData.get(5));// Travel Time (years)
		
		return outputData;
	}
	
	public static void writeToCSVFile(String filename, String data) {
	    try {
	        FileWriter writer = new FileWriter(filename, true);
	        writer.write(data);
	        writer.close();
	        log.formatLogger("Successfully wrote contents to '%s'", filename);
	        System.out.println("Successfully wrote to the file.");
	    } 
	    catch (IOException e) {		//ToDo - Fix this exception
	        System.out.println(e);
	        e.printStackTrace();
	      }
	}

	@Override
	protected String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getWorksheetNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void handlePoiDataRowResults(ArrayList<PoiElementData> rowDataList) {
		// TODO Auto-generated method stub
		
	}

}

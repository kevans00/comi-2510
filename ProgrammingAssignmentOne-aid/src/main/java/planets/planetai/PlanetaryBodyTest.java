package planets.planetai;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlanetaryBodyTest {
	
private static final Logger logger = LogManager.getLogger(PlanetaryBodyTest.class.getName());

/**
 * This is a test of the PlanetaryBodyReader class to ensure it runs correctly
 * @param args
 */
public static void main(String[] args) {
	
		final String DELIMITER = ",";
		String FILE_LOCATION = "C:\\Users\\Lenovo ThinkPad T430\\eclipse-workspace\\ProgrammingAssignmentOne-aid\\src\\main\\java\\planets\\planetai\\planet_details.csv";
		
		// 1. Create the reader object and then 2. fill a new array using the reader object
		PlanetaryBodyReader reader = new PlanetaryBodyReader();		
		ArrayList<PlanetaryBody> list = reader.readCSV(FILE_LOCATION, DELIMITER);
		
		// Create a new empty array in anticipation to be filled with the planet names
		ArrayList<String> planetNames = new ArrayList<String>();
		
		// Loop through each item in the `list`
		for (PlanetaryBody detail:list) {
			//System.out.println(detail.getPlanetName());		
			planetNames.add(detail.getPlanetName());
		}
		
		System.out.println("The planet names array has " + planetNames);
	}
}

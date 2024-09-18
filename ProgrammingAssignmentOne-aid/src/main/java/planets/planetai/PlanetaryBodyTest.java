package planets.planetai;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlanetaryBodyTest {
	
private static final Logger logger = LogManager.getLogger(PlanetaryBodyTest.class.getName());
	

public static void main(String[] args) {
	
	
		PlanetaryBodyReader reader = new PlanetaryBodyReader();
	
		final String DELIMITER = ",";
		String FILE_LOCATION = "C:\\Users\\Lenovo ThinkPad T430\\eclipse-workspace\\ProgrammingAssignmentOne-aid\\src\\main\\java\\planets\\planetai\\planet_details.csv";
		ArrayList<PlanetaryBody> list = null;
		
		list = reader.readCSV(FILE_LOCATION, DELIMITER);
		//list = PlanetaryBodyReader()
		
		
		for (PlanetaryBody detail:list) {
			//print(detail)
			System.out.println(detail.distanceEarth);		//See if we can print out all of the detail items
		}
	}

}

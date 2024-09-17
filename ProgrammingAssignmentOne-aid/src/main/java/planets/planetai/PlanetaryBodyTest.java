package planets.planetai;
import java.util.ArrayList;

public class PlanetaryBodyTest {

public static void main(String[] args) {
		
		String DELIMITER = ",";
		String FILE_LOCATION = "C:\\Users\\Lenovo ThinkPad T430\\eclipse-workspace\\ProgrammingAssignmentOne-aid\\planet_details.csv";
		ArrayList<PlanetaryBody> list = null;
		
		list = PlanetaryBodyReader.readCSV(FILE_LOCATION, DELIMITER);
		//list = PlanetaryBodyReader()
		
		
		for (PlanetaryBody detail:list) {
			//print(detail)
			System.out.println(detail);
		}
	}

}

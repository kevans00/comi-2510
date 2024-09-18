package planets.transportation;
import java.util.ArrayList;

public class TransportationVehicleTest {
	public static void main(String[] args) {
		
		
		TransportationVehicleReader reader = new TransportationVehicleReader();
	
		final String DELIMITER = ",";
		String FILE_LOCATION = "C:\\Users\\Lenovo ThinkPad T430\\eclipse-workspace\\ProgrammingAssignmentOne-aid\\src\\main\\java\\planets\\planetai\\planet_details.csv";
		ArrayList<TransportationVehicle> list = null;
		
		list = reader.readCSV(FILE_LOCATION, DELIMITER);
		
		for (TransportationVehicle detail:list) {
			//print(detail)
			System.out.println(detail.maxSpeed);		//See if we can print out all of the detail items
		}
	}

}
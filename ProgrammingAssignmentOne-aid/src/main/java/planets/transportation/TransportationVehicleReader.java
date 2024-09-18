package planets.transportation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransportationVehicleReader {

	private static final Logger logger = LogManager.getLogger(TransportationVehicleReader.class.getName());
	
	public TransportationVehicleReader() {}
	
	public ArrayList<TransportationVehicle> readCSV(String csvFile, String delimiter){
		BufferedReader br = null;
		ArrayList<TransportationVehicle> list = new ArrayList<TransportationVehicle>();
		TransportationVehicle detail = null;
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			
			line = br.readLine();
			TransportationVehicleReader.logger.debug("Header = " + line);
			
			while ((line = br.readLine()) != null) {
				TransportationVehicleReader.logger.debug("Line = " + line);	
				tempArr = line.split(delimiter);
				
				detail = new TransportationVehicle(
						tempArr[0], 
						tempArr[1], 
						Double.parseDouble(tempArr[2]), 
						Double.parseDouble(tempArr[3]), 
						Double.parseDouble(tempArr[4]), 
						Double.parseDouble(tempArr[5]), 
						Double.parseDouble(tempArr[6]), 
						Double.parseDouble(tempArr[7]), 
						Double.parseDouble(tempArr[8]));
				
						list.add(detail);
						}
			TransportationVehicleReader.logger.debug("Detail = " + detail) ;
			TransportationVehicleReader.logger.debug("Line = " + line);
			br.close();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		} finally
		{
			if (null != br)
			{
				try
				{
					br.close();
				} catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		}
		return list;
	}
	
}



package planets.transportation;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.LineNumberReader;

public class TransportationVehicleReader {

	private static final Logger logger = LogManager.getLogger(TransportationVehicleReader.class.getName());
	
	public TransportationVehicleReader() {}
	
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
			while ((line = ln.readLine()) != null) {
				TransportationVehicleReader.logger.debug("Line number " + ln.getLineNumber() + " has: " + line);	
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
			//TransportationVehicleReader.logger.debug("Detail = " + detail) ;
			//TransportationVehicleReader.logger.debug("Line = " + line);
			ln.close();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		} finally
		{
			if (null != ln)
			{
				try
				{
					ln.close();
				} catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
	
}



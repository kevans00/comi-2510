package planets.planetai;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class PlanetaryBodyReader {
	
	private static final Logger logger = LogManager.getLogger(PlanetaryBodyReader.class.getName());
	
	
	/**
	 * Default constructor
	 */
	public PlanetaryBodyReader() {}
	
	public ArrayList<PlanetaryBody> readCSV(String csvFile, String delimiter){
		BufferedReader br = null;
		ArrayList<PlanetaryBody> list = new ArrayList<PlanetaryBody>();
		PlanetaryBody detail = null;
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			int counter = 0;
			
			line = br.readLine();
			PlanetaryBodyReader.logger.debug("Header = " + line);
			
			while ((line = br.readLine()) != null) {
				PlanetaryBodyReader.logger.debug("Line = " + line);	
				tempArr = line.split(delimiter);
				
				detail = new PlanetaryBody(
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
				
						list.add(detail);
						}
			PlanetaryBodyReader.logger.debug("Detail = " + detail) ;
			PlanetaryBodyReader.logger.debug("Line = " + line);
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


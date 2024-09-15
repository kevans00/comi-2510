package planets.planetai;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class PlanetaryBodyReader {
	
	/**
	 * Default constructor
	 */
	public PlanetaryBodyReader() {
	}
	
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
			
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
				
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
			}
		}
	}
}

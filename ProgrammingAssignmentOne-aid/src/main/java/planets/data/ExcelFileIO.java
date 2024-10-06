package planets.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import planets.util.PlanetaryConstants;
import planets.util.EasyDebugLogger;

import edu.ccri.assignment.files.poi.AbstractPoiTestDataSource;
import edu.ccri.assignment.files.poi.AbstractPoiWriteElementDataList;
import edu.ccri.assignment.files.poi.PoiElementData;
import edu.ccri.assignment.files.poi.PoiReadElementDataList;
import edu.ccri.assignment.planets.data.FileDataSource;
import edu.ccri.assignment.planets.data.DataAccessElement;
import edu.ccri.assignment.planets.data.DataAccessOperations;

public class ExcelFileIO extends AbstractPoiTestDataSource implements FileDataSource, DataAccessOperations {

	public static EasyDebugLogger log = new EasyDebugLogger();
	
	public static final String INPUT_FILE = "Planets.xlsx";
	public static final String PLANET_DETAILS = "planet_details";
	public static final String TRANSPORT_DETAILS = "transport_vehicle_details";
	
	public static final String OUTPUT_FILENAME_BASE = "ProcessedData";
	public static final int MIN_FILE_NUMBER = 1;
	public static final int MAX_FILE_NUMBER = 21;

	public static String resourceFolderAbsPath = new File(PlanetaryConstants.RESOURCE_PATH).getAbsolutePath();
	public static String outputFolderAbsPath = new File(PlanetaryConstants.OUTPUT_PATH).getAbsolutePath();
	public static File planetFileAbsPath = new File(resourceFolderAbsPath, INPUT_FILE);
	
	private ArrayList<ArrayList<Object>> dataList;
	private ArrayList<Object> rowList;
	private int rows;
	private int cols;

    
	private void setDataList(ArrayList<ArrayList<Object>> dataList) {
		this.dataList = dataList;
	}
	
	private void setRowData(ArrayList<Object> rowList) {
		this.rowList = rowList;
	}
	
	public ArrayList<ArrayList<Object>> getDataList() {
		return this.dataList;
	}
	
	
	private void setRows(int rows) {
		this.rows = rows;
	}

	
	private int getRows() {
		return this.rows;
	}
	
	
	private void setCols(int cols) {
		this.cols = cols;
	}
	
	
	private int getCols() {
		return this.cols;
	}
	
	
	@Override
	public String getFileName() {
		return planetFileAbsPath.getPath();
	}
	
	
	@Override
	public void readFileDetails() {
		PoiReadElementDataList reader = new PoiReadElementDataList(getFileName(), getWorksheetNumber());
		this.skipFirstRow();
		//setDataList(reader.getDataList());
		setRows(reader.getMaxRows());
		setCols(reader.getMaxColumns());
	}
	
	
	@Override
	public DataAccessElement findName(String name) {
		// For each row
		for (int i = 0; i < this.rows; i++) {
			// For each column
			for (int j = 0; j < this.cols; j++) {
				// pass
			}
		}
		return null;
	}


	@Override
	public List<String> getNameList() {
		List<String> nameList = null;
		
		for (ArrayList<Object> row : this.getDataList()) {
			nameList.add(row.get(2).toString());
		}

		return nameList;
	}
	
	
	public void DataOperations() {
		// TODO Auto-generated constructor stub
	}	
	
	
	@Override
	protected int getWorksheetNumber() {
		int num = 0;
		
		/*
		if (worksheetName == PLANET_DETAILS) {
			num = 0;			
		}
		else if (worksheetName == TRANSPORT_DETAILS) {
			num = 1;
		}*/
		
		return num;
	}
	
	
	@Override
	protected void handlePoiDataRowResults(ArrayList<PoiElementData> rowDataList) {
		// Check page
		// Use planetary body index
			// Handle Data at index j for row 
		// Use Transport body index
			// Handle Data at index j for row
	}


	public void addRowListData(ArrayList<Object> tripData){
		ArrayList<Object> rowList = new ArrayList();
		
		for (int i = 0; i < tripData.size(); i++) {
			rowList.add(tripData.get(i));
		}
		
		setRowData(rowList);
	}
	
	public static void excelOutputResults(ArrayList<ArrayList<Object>> dataList, String worksheetName) {
		
		AbstractPoiWriteElementDataList ed = new AbstractPoiWriteElementDataList() {
			
			private ArrayList<ArrayList<Object>> dlist = new ArrayList();
			
			@Override
			protected void setDataList(ArrayList<ArrayList<Object>> dataList) {
				this.dlist = dataList;
			}
		
			@Override
			protected ArrayList<ArrayList<Object>> getDataList() {
				return this.dlist;
			}
	
			@Override
			protected String getFileNamePrefix() {
				Random random = new Random();
				int randomNumber = random.nextInt(MAX_FILE_NUMBER) + 1; // Adding 1 as a hack because this function's range is [0, 21)
				
				String prefix = PlanetaryConstants.OUTPUT_PATH + OUTPUT_FILENAME_BASE + Integer.toString(randomNumber);
				log.formatLogger("Prefix path is: %s", prefix);
				return prefix;
			}
	
			@Override
			protected String getFileNameSuffix() {
				return ".xlsx";
			}
		};

		ed.addDataListWorksheet(dataList, worksheetName);
		ed.writeFile();
	}
}

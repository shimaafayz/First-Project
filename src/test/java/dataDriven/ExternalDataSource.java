package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 ///* this class for load and access the data for excel and json files 
public class ExternalDataSource
{
  static FileInputStream fis = null;
  /////load excel sheet////
  public FileInputStream getFileInputStream()
  {
	  String FilePath = System.getProperty("user.dir")+"/src/test/java/dataDriven/DataSourse.xlsx";
	  File srcFile = new File(FilePath);
	  try {
		fis = new FileInputStream(srcFile);
	} catch (FileNotFoundException e) 
	  {
		
		System.out.println("File data ....not found "+e.getMessage());
	}
	  return fis;
  }
  /////read the data from the excel sheet //////
  public Object[][] getExcelData() throws IOException
  {
	  fis =getFileInputStream();
	  
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 5;
		String[][] arrExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];
		for (int i=0;i<TotalNumberOfRows;i++)
		{ 
			for (int j=0;j<TotalNumberOfCols;j++)
			{
				XSSFRow row = sheet.getRow(i);
				arrExcelData[i][j] = row.getCell(j).toString();
				
			}
			
		}
		wb.close();
		return arrExcelData;
	}
   ////load and read the data from json file ////////////////////// 
  public String fname,lname,email,pass,conpass;
  public void getJsonDataReader() throws FileNotFoundException, IOException, ParseException
  {
 	 String FilePath = System.getProperty("user.dir")+"/src/test/java/data/DataSource.jason";
 	 File srcfile = new File(FilePath);
 	 JSONParser jsonpar = new JSONParser();
 	 JSONArray jsonarr = (JSONArray)jsonpar.parse(new FileReader(srcfile));
 	 for(Object jsonObj :jsonarr)
 	 {
 		 JSONObject person = (JSONObject) jsonObj;
 		 fname = (String)person.get("firstname");
 		 System.out.println(fname);
 	 }
  }
}

package com.qittah.collectedMethod;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

//import data.JasonDataReader;

// this class for copy any data provider in the test script
 
public class DataDriverClass 
{
	 /////////@Data Provider annotation /////////
	  /*@DataProvider(name = "TestData")
		public static Object[][] userData()
		{
			return new Object[][]
			{
				{"ahmed1","mohamed2","ahmed1@gmail.com","12346789","12346789"},
				{"ahmed2","mohamed3","ahmed77@gmail.com","3698752","3698752"}
				
			};
			
		}
	 @Test(priority=1,alwaysRun=true,dataProvider= "TestData")
	 public void registerUser(String fname,String lname,String email,String password, String ConfPass)
	 {
	 
	 }
		
     /////////@Data Provider Excel/////////	
      @DataProvider(name="ExcelData")
      public Object[][] userGetData() throws IOException
      {
	      ExternalDataSource exterData = new ExternalDataSource();
	      return exterData.getExcelData();
      }
      @Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
      public void displayData(String fName,String lName,String Email,String Password,String ConfPassword)
      {
         parClass.registrationMethod(fName, lName, Email, Password, ConfPassword);
      }
      
      
     /////////////@Data Provider CSV/////////
     public void getData() throws IOException
      {
	   
	   String csv_Path = System.getProperty("user.dir")+"/src/test/java/dataDriven/new.csv";
	   reader = new CSVReader(new FileReader(csv_Path));
	   String[] csvCell;
	   while((csvCell =reader.readNext())!=null)
	   {
		   String FirstName = csvCell[0];
		   System.out.println(FirstName);
		   String lastName = csvCell[1];
		   System.out.println(lastName);
		   String Email = csvCell[2];
		   System.out.println(Email);
	   }
	   
	   
  }
  
   ///////////@Data Provider Json ///////////////
     public void getDataJason() throws FileNotFoundException, IOException, ParseException
     {
	   JasonDataReader reader = new JasonDataReader();
	   reader.getDataReader();
	  System.out.println(reader.fname);
     }
   
   */     
}

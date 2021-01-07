package com.test.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.test.BaseTest.TestBase;

public class TestUtil {
	
	private static XSSFSheet ExcelWSheet;	 
	 private static XSSFWorkbook ExcelWBook;	 
	 private static XSSFCell Cell;	 
	 private static XSSFRow Row;
	 public static String filePath = "D:\\GitRapo\\Selenium.Com.OrangeCRM\\Screenshots\\";
	 
	 
	//XLSX excel sheet
	 public static String [][] getTestData (String Filename, String sheetname){
			
			FileInputStream fis = null;
		
				try {
					fis = new FileInputStream(Filename);
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				}
				String datasets [][] = null;
				try {
					ExcelWBook = new XSSFWorkbook(fis);
					//get sheet from excel workbook
					ExcelWSheet = ExcelWBook.getSheet(sheetname);	
						
				    int totalRows = ExcelWSheet.getLastRowNum();
				    int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			    
				    datasets = new String [totalRows][totalCols]; // pass my  count data in array
			
				    for(int i=0; i<totalRows; i++) //Loop work for Rows
		            {  
		                Row= ExcelWSheet.getRow(i+1);
		                 
		                for (int j=0; j<totalCols; j++) //Loop work for colNum
		                {
		                    if(Row==null)
		                    	datasets[i][j]= "";
		                    else
		                    {
		                    	Cell= Row.getCell(j);
		                        if(Cell==null)
		                            datasets[i][j]= ""; //if it get Null value it pass no data 
		                        else
		                        {
		                            String value=Cell.getStringCellValue();
		                         //   System.out.println(value);
		                            datasets[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
		                        }
		                    }
		                }
		            }
	 
				    ExcelWBook.close();
				    fis.close();			
				    return datasets;
				} catch (IOException e) {
				System.out.println("Exception in reading xlsx file" + e.getMessage()); 		
				e.printStackTrace();
			}
				return datasets;      
			
	}
	 
	 //XLS Excel sheet
	 public static String [][] getTestDataXLS (String Filename, String sheetname){
			
			FileInputStream fis = null;
		
				try {
					fis = new FileInputStream(Filename);
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				}
				String XSLdatasets [][] = null;
				try {
					HSSFWorkbook Workbook = new HSSFWorkbook(fis);
					//get sheet from excel workbook
					HSSFSheet Worksheeet = Workbook.getSheet(sheetname);	
						
				    int totalRows = Worksheeet.getLastRowNum();
				    int totalCols = Worksheeet.getRow(0).getPhysicalNumberOfCells();
			    
				    XSLdatasets = new String [totalRows][totalCols]; // pass my  count data in array
			
				    for(int i=0; i<totalRows; i++) //Loop work for Rows
		            {  
				    	HSSFRow XLSRow= Worksheeet.getRow(i+1);
		                 
		                for (int j=0; j<totalCols; j++) //Loop work for colNum
		                {
		                    if(XLSRow==null)
		                    	XSLdatasets[i][j]= "";
		                    else
		                    {
		                    	HSSFCell XLSCell= XLSRow.getCell(j);
		                        if(Cell==null)
		                        	XSLdatasets[i][j]= ""; //if it get Null value it pass no data 
		                        else
		                        {
		                            String value=XLSCell.getStringCellValue();
		                         //   System.out.println(value);
		                            XSLdatasets[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
		                        }
		                    }
		                }
		            }
	 
				    Workbook.close();
				    fis.close();			
				    return XSLdatasets;
				} catch (IOException e) {
				System.out.println("Exception in reading xlsx file" + e.getMessage()); 		
				e.printStackTrace();
			}
				return XSLdatasets;      
			
	}


	
public static void takeScreenShot(String methodName, WebDriver driver) {
	
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with test method name 
       try {
			File targetFile = new File(filePath+methodName+".png");
			
			FileUtils.copyFile(scrFile, targetFile);
			System.out.println("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
}

public static String capture(WebDriver driver,String screenShotName) throws IOException
{
    TakesScreenshot ts = (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
    File destination = new File(dest);
    FileUtils.copyFile(source, destination);        
                 
    return dest;
}



public static Object [][] getTestData1 (String Filename, String sheetname){
		
		FileInputStream excelfile = null;
	
			try {
				excelfile = new FileInputStream(Filename);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ExcelWBook = new XSSFWorkbook(excelfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ExcelWSheet = ExcelWBook.getSheet(sheetname);
			
						    
		  int totalRows = ExcelWSheet.getPhysicalNumberOfRows();
		   //int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells(); //1st method
		    int totalCols = ExcelWSheet.getRow(0).getLastCellNum(); //2nd method
		    
		    Object Data[][]= new Object[1][1]; // pass my  count data in array
		    
			Map<String, String> datamap = new HashMap<String, String>();
		
		    for(int i=0; i<1; i++) //Loop work for Rows
           {  
		    
		    	  for(int j=0; j<totalCols; j++) //Loop work for Rows
		            {  
		    		  
		           
		    		Row row = ExcelWSheet.getRow(i+1);              				  
				  
				  //0th Cell as Key
				  Cell keyCell = ExcelWSheet.getRow(i).getCell(j);
				  
				 // Row row = ExcelWSheet.getRow(testcasenum);
				  
				  //1st Cell as Value
				  Cell valueCell = row.getCell(j);
					  
			
				  String key = keyCell.getStringCellValue().trim();	  
				  String value = valueCell.getStringCellValue().trim();
				 
					  
				  //Putting key & value in dataMap
				  datamap.put(key, value);
                         //  Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
				  Data[0][0]=datamap; 
				  
		            }
           }   
               
		
       return Data;
		
		
}


}
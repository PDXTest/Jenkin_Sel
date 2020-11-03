package com.test.Util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	private static XSSFSheet ExcelWSheet;	 
	 private static XSSFWorkbook ExcelWBook;	 
	 private static XSSFCell Cell;	 
	 private static XSSFRow Row;
	 
		static String Filename = "E:\\Selenium_Work\\com.orangeCRM\\src\\main\\java\\com\\test\\TestData\\TestData.xlsx";
		 static String sheetname =  "test";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object data[][] = getTestData(Filename, sheetname );
		System.out.println(data);
		//System.out.println(data[0][1]);
		}
	
	
			public static Object [][] getTestData (String Filename, String sheetname){
				
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
					
						 
				    
				    int totalRows = ExcelWSheet.getLastRowNum();
				    int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
				    
				    Object Data[][]= new Object[totalRows][totalCols]; // pass my  count data in array
				
				    for(int i=0; i<totalRows; i++) //Loop work for Rows
		            {  
		                Row= ExcelWSheet.getRow(i+1);
		                 
		                for (int j=0; j<totalCols; j++) //Loop work for colNum
		                {
		                    if(Row==null)
		                        Data[i][j]= "";
		                    else
		                    {
		                        Cell= Row.getCell(j);
		                        if(Cell==null)
		                            Data[i][j]= ""; //if it get Null value it pass no data 
		                        else
		                        {
		                            String value=Cell.getStringCellValue();
		                            System.out.println(value);
		                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
		                        }
		                    }
		                }
		            }
		 
				    
				
		        return Data;
				
				
		}

		

		
		
	}



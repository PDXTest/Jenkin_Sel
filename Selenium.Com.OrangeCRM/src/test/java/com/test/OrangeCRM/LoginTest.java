package com.test.OrangeCRM;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.BaseTest.TestBase;
import com.test.Pages.HRMLogin;
import com.test.Util.TestUtil;

public class LoginTest extends TestBase{
	
	HRMLogin HRMlogin;
	String Filename = "E:\\Selenium_Work\\Selenium.Com.OrangeCRM\\src\\main\\java\\com\\test\\TestData\\TestData1.xlsx";
	 String sheetname =  "login";
	 
	// static ExtentReports extent;
	// static ExtentTest test;
	 
	 
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initilition();
		HRMlogin =  new HRMLogin();
	
	}
	 
	
//	@DataProvider (name = "getHRMTestData",  indices = {0})
//	public Object[][] getHRMTestData() {
//	Object data[][]	= TestUtil.getTestData(Filename, sheetname);
//	return data;
		
//	}
	
	  @DataProvider (name = "getHRMTestData") public Object[][] getHRMTestData() { 
		  Object  data[][] = TestUtil.getTestData1(Filename, sheetname); 
	  return data;
	  
	  }
		
	@Test (dataProvider = "getHRMTestData")
	public void HLogin(@SuppressWarnings("rawtypes") Map mapdata) {	
		
		test=extent.startTest("Test Name is : HLogin");
		HRMlogin.Login((String) mapdata.get("username"), (String) mapdata.get("password"));
		
		String dashaboard = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		
		try {
		       org.testng.Assert.assertEquals(dashaboard, "Dashboard");
		       test.log(LogStatus.PASS, "Test is passed");
		       
		       
		       
		} catch (AssertionError e) {
		    	 test.log(LogStatus.FAIL, "Test Failed");
		       throw e;
		     }
		
    }	
		
	

	@Test (dataProvider = "getHRMTestData")
public void HLogin1(@SuppressWarnings("rawtypes") Map mapdata) {	
		
		test=extent.startTest("Test Name is : HLogin");
		HRMlogin.Login((String) mapdata.get("username"), (String) mapdata.get("password"));
		
		String dashaboard = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		
			
		try {
		       Assert.assertEquals(dashaboard, "Dashboard");
		       test.log(LogStatus.PASS, "Test is passed");
		     } catch (AssertionError e) {
		    	 test.log(LogStatus.FAIL, "Test Failed");
		       throw e;
		     }
		
	}

		
	 @AfterMethod     
	    public void getResult(ITestResult result) throws IOException{
	    				
			  if(result.getStatus()==ITestResult.FAILURE) 
			  {
				  
				  String screenShotPath = TestUtil.capture(driver, result.getName().toString().trim());
		            test.log(LogStatus.FAIL, result.getThrowable());
		            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		            
		            
					/*
					 * test.log(LogStatus.FAIL, result.getName());; test.log(LogStatus.FAIL,
					 * result.getThrowable()); String methodName=result.getName().toString().trim();
					 * TestUtil.takeScreenShot(methodName, driver);
					 */
			  
			  }
			  
			  else if(result.getStatus()==ITestResult.SUCCESS) 
			  {
				  test.log(LogStatus.PASS,
			      result.getName()); 
			  } 
			  else if (result.getStatus()==ITestResult.SKIP) 
			  {
			      test.log(LogStatus.SKIP, 
			      result.getName()); 
			   }
			 		
		driver.quit();
	    	
	}
	
	

}

package com.test.OrangeCRM;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.BaseTest.TestBase;
import com.test.Pages.HRMLogin;
import com.test.Pages.UserManagement;
import com.test.Util.TestUtil;

public class UserManagementTest extends  TestBase {
	
	String Filename = "D:\\GitRapo\\Selenium.Com.OrangeCRM\\src\\main\\java\\com\\test\\TestData\\TestData1.xlsx";
	 String sheetname =  "Adduser";
	
	HRMLogin HRMlogin;
	UserManagement usermgmt;
	
	
	
	public UserManagementTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initilition();
		HRMlogin =  new HRMLogin();
	
	}	
	
	  @DataProvider (name = "getHRMTestData") public Object[][] getHRMTestData() { 
		  Object  data[][] = TestUtil.getTestData1(Filename, sheetname); 
	  return data;
	  
	  }
	
	@Test (dataProvider = "getHRMTestData")
	public void AddUsers(@SuppressWarnings("rawtypes") Map mapdata) throws InterruptedException {
		
		test=extent.startTest("Test Name is : ADDUsers");
		
		HRMlogin.Login((String) mapdata.get("username"), (String) mapdata.get("password"));
		
		usermgmt = new UserManagement();	
		
		usermgmt.clickonUsersmenu();	
		
		String dashaboard = "Dashboard";	
		
		try {
		       Assert.assertEquals(dashaboard, "Dashboard");
		       
		       test.log(LogStatus.PASS, "AddUsers test is passed");
		       
		     } catch (AssertionError e) {
		    	 
		       test.log(LogStatus.FAIL, "AddUsers test Failed");
		    	 
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

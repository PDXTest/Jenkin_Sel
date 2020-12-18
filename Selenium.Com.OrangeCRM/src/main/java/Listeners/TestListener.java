package Listeners;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.test.Util.ExtentManager;
import com.test.Util.ExtentTestManager;
import com.test.Util.TestUtil;
import com.test.BaseTest.TestBase;

 
public class TestListener extends TestBase implements ITestListener  {
	
	
 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
 
    public void onStart(ITestContext iTestContext) {
    	test=extent.startTest("Test Execution has Started");
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }
 
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
   //     ExtentTestManager.endTest();
     //   ExtentManager.getReporter().flush();
        driver.quit();
    }
 
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
     //   test.log(LogStatus.INFO, "Test Execution has Started"); 
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        //ExtentReports log operation for passed tests.
       /// test.log(LogStatus.PASS,iTestResult.getName()); 
        test.log(LogStatus.PASS,iTestResult.getName() + " Test is passed"); 
    }
 
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
 
        //Get driver from BaseTest and assign to local webDriver variable.
  	  String screenShotPath = null;
	try {
		screenShotPath = TestUtil.capture(driver, iTestResult.getName().toString().trim());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.log(LogStatus.FAIL, "This test is failed");
  test.log(LogStatus.FAIL, iTestResult.getThrowable());
  test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
    }
 
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}

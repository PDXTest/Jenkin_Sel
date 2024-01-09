package com.test.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {
	
	
	//.properties' files are mainly used in Java programs to maintain project configuration data, database config or project settings 
	//Each parameter in properties file are stored as a pair of strings, in key and value format,
	// You can easily read properties from some file using object of type Properties.
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	public static Properties prop;
	public static String driverpath = ("C:\\Minakshi_Old_laptop\\Jenkin_Sel\\Selenium.Com.OrangeCRM\\src\\main\\java\\com\\test\\Config\\Config.properties");
	
	
	@BeforeSuite
	public static void starttest() {
		
		extent = new ExtentReports("C:\\Minakshi_Old_laptop\\Jenkin_Sel\\Selenium.Com.OrangeCRM\\ExtentReports\\newExtentReports.html", true);

	}
	
	
	public TestBase()  {		
				
		FileInputStream fis;
		try {
			prop = new Properties();
			fis = new FileInputStream(driverpath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public static void Initilition() {
		
		String url = prop.getProperty("project_url");
				
		//System.setProperty("webdriver.gecko.driver", "F:\\Selenium Data\\SeleniumDrivers\\geckodriver\\geckodriver.exe");	
		driver = new FirefoxDriver();
		
		
		//System.setProperty("webdriver.chrome.driver", "F:\\Selenium Data\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
	//	driver = new ChromeDriver();
					
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//driver.get("https://opensource-demo.orangehrmlive.com");
		driver.get(url);
		
	}
	
 
	@AfterSuite
	public void closedriver()
    {
		extent.endTest(test);
		extent.flush();	
	
    }
	
}

package com.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseTest.TestBase;

public class HRMLogin extends TestBase {

	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement btnSubmit;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/h1")
	 WebElement Dashboard;
	
	
	
	public HRMLogin() {
		PageFactory.initElements(driver, this);
	}
	
	
		
	public void Login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		btnSubmit.click();
		
	}



	
	
	

}

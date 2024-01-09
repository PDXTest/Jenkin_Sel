package com.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseTest.TestBase;

public class HRMLogin extends TestBase {

	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(className="oxd-button")
	WebElement btnSubmit;
	
	@FindBy(className="oxd-topbar-header-breadcrumb-module")
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

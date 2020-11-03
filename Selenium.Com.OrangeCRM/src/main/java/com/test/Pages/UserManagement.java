package com.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseTest.TestBase;

public class UserManagement extends TestBase {
	
		
	@FindBy(xpath= "//a[@id='menu_admin_viewAdminModule']/b[contains(text(), 'Admin')]")
	WebElement btnAdmin;
	
	@FindBy(xpath= "//a[@id='menu_admin_UserManagement']")
	WebElement menuusermanagement;
	
	
	@FindBy(xpath= "//a[@id='menu_admin_viewSystemUsers']")
	WebElement menuusers;
	
	//selecting checkbox
	@FindBy(xpath = "//a[text() = 'fiona.grace']/parent::td/preceding-sibling::td/input[@type='checkbox']")
	WebElement AdminUser;
	
	
	
	public UserManagement() {		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonUsersmenu() {
		btnAdmin.click();

		Actions ac = new Actions(driver);
		ac.moveToElement(menuusermanagement).build().perform();	
		
		menuusers.click();		
		//AdminUser.click();
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}

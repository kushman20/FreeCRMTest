package com.rsa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.base.TestBase;

public class HomePage extends TestBase {

	// use page factory -Object Repository
	
	@FindBy(xpath="//a[@class='theme-btn']")
	WebElement 	loginBtn;
	
	@FindBy(xpath="//div[@class='logo']")
	WebElement logoImage;
	
	//Initializing the page object:
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateRCAImage()
	{
		return logoImage.isDisplayed();
	}
	
	public LoginPage clickLogin()
	{
		 loginBtn.click();
		 
		 return new LoginPage();
	}
}

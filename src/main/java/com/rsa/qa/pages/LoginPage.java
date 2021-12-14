package com.rsa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.base.TestBase;

public class LoginPage extends TestBase{

	// use page factory -Object Repository
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	WebElement submitBtn;
	
	@FindBy(xpath ="//h3[contains(text(),'Login')]")
	WebElement loginlogo;
	
	//Initializing the page object:
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateLoginlogo()
	{
		return loginlogo.isDisplayed();
	}
	
	public MyLandingPage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		
		return  new MyLandingPage();
	}
	
	
}

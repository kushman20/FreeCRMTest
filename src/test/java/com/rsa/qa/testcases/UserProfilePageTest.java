package com.rsa.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.TestBase;
import com.rsa.qa.pages.HomePage;
import com.rsa.qa.pages.LoginPage;
import com.rsa.qa.pages.MyLandingPage;
import com.rsa.qa.pages.UserProfilePage;

public class UserProfilePageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	MyLandingPage landingPage;
	UserProfilePage profilePage;
	
	public UserProfilePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialzation();
		homePage= new HomePage();
		loginPage= homePage.clickLogin();
		loginPage= new LoginPage();
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		landingPage.clickOnEditProfileLink();
	    profilePage= new UserProfilePage();
	}
	
	@Test(priority=1)
	
	public void validateProfilePageTitleTest()
	{
	String profilePageTitle=	profilePage.validateProfilePageTitle();
		Assert.assertEquals(profilePageTitle, "Rahul Shetty Academy");
	}
	
	@Test(priority=2)
	public void validateLabelDisplayTest()
	{
		Assert.assertTrue(profilePage.validateLabelText());
	}
	/*
	@Test(priority=3)
	public void notifcationBtntwoClickTest()
	{
         
     Boolean buttonOk= profilePage.notifcationBtntwoClick();
     
		Assert.assertTrue(buttonOk, "button is disable");
	}
	*/
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
	
}

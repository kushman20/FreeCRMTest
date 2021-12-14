package com.rsa.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.TestBase;
import com.rsa.qa.pages.HomePage;
import com.rsa.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	
/*	public HomePageTest()
	{
		super();
	}*/
	
	@BeforeMethod
	public void setup()
	{
		initialzation();
		
		 homePage = new HomePage();
	}
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=  homePage.validateHomePageTitle(); 
		Assert.assertEquals(homePageTitle, "Home | Rahul Shetty Academy","Title is not displayed");
	}
	
	@Test(priority=2)
	public void verifyRCALogo()
	{
		Boolean logo= homePage.validateRCAImage();
		Assert.assertTrue(logo);
	}
	
	@ Test(priority=3)
	public void verifyLoginBtnClickTest()
	{
		loginPage= homePage.clickLogin();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

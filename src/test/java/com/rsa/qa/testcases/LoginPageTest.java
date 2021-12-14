package com.rsa.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.TestBase;
import com.rsa.qa.pages.HomePage;
import com.rsa.qa.pages.LoginPage;
import com.rsa.qa.pages.MyLandingPage;
 /*Important Note : test cases should be independent thats why use before method*/
/* before each test case -- launch the browser and login
 after each test case-- close the browser	*/	  

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	MyLandingPage landingPage;
	
	public LoginPageTest()
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
		 
		 
	}
	
	
	@Test(priority=1)
	
	public void loginPageTitleTest()
	{
		//validate login page title 
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Rahul Shetty Academy","loginPage title not mached");
	}
	
	@Test(priority=2)
	
	public void loginImageTest()
	{
		boolean flag= loginPage.validateLoginlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	
	public void loginTest()
	{
		
		landingPage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

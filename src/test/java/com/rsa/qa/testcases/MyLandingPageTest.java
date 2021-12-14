package com.rsa.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rsa.qa.base.TestBase;
import com.rsa.qa.pages.CoursePage;
import com.rsa.qa.pages.HomePage;
import com.rsa.qa.pages.LoginPage;
import com.rsa.qa.pages.MyLandingPage;
import com.rsa.qa.pages.PracticePage;
import com.rsa.qa.util.TestUtil;

public class MyLandingPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	MyLandingPage landingPage;
	CoursePage coursePage;
	PracticePage practicePage;
	String sheetName="courselist";
	
	public MyLandingPageTest()
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

	}
	
	@Test (priority=1)
	public void landingPageTitleTest()
	{
		String landingPageTitle= landingPage.verifyLandingPageTitle();
		Assert.assertEquals(landingPageTitle, "Rahul Shetty Academy","landing page title not matched");
	}
	
	@Test(priority=2)
	
	public void userNameDisplayTest()
	
	{
	 boolean flag=	landingPage.userNameDisplay("Jagatbondhu");
		Assert.assertTrue(flag, "user name not displayed");
	}
	
	@Test (priority= 3)
	public void verifyCourseLinkTest()
	{
		coursePage =  landingPage.clickOnCourseLink();
	}
	
	@Test (priority=4)
	public void verifyPracticeLinkTest()
	{
		practicePage= landingPage.clickOnPracticePageLink();
	
	}
	
	@DataProvider
	//********************
	public Object[][] getRSATestData()
	{
		Object data[][]=  TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=5, dataProvider="getRSATestData")
	public void validateSearchFunction(String course)
	{
		
		landingPage.verifySearchFunction(course);
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
}

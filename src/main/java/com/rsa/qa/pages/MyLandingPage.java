package com.rsa.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.base.TestBase;

public class MyLandingPage extends TestBase {

	// use page factory -Object Repository

	
	@FindBy(xpath="//a[contains(text(),'All Courses')]")
	WebElement courseLink;
	
	@FindBy(xpath="//a[contains(text(),'Practice')]")
	WebElement practiceLink;
	
	@FindBy(xpath="//input[@id='search-courses']")
	WebElement searchBox;
	
	@FindBy(id="search-course-button")
	WebElement searchBtn;
	
	@FindBy(xpath ="//span[@class='navbar-current-user']")
	WebElement userNameLink;
	
	@FindBy(xpath="//a[normalize-space()='Edit Profile']")
	WebElement editProfileLink;
	//constructor
	public MyLandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyLandingPageTitle()
	{
		return  driver.getTitle();
	}
	public CoursePage clickOnCourseLink()
	{
		courseLink.click();
		return new CoursePage();
	}
	
	public PracticePage clickOnPracticePageLink()
	{
		practiceLink.click();
		
		return new PracticePage();
	}
	
	public boolean userNameDisplay(String name)
	{
		// this way we will not hard code and do efficient coding
	 return	driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).isDisplayed();
	}
	
	public void clickOnEditProfileLink()
	{
		Actions action = new Actions(driver);
		userNameLink.click();
		action.moveToElement(editProfileLink).build().perform();
		editProfileLink.click();
	}
	
	

	public void verifySearchFunction(String cname) {
		// TODO Auto-generated method stub
		searchBox.sendKeys(cname);
		searchBtn.click();
		searchBox.clear();
	}
	
}

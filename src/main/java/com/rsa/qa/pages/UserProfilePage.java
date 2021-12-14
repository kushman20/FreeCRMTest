package com.rsa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.base.TestBase;

public class UserProfilePage extends TestBase {

	// use page factory -Object Repository

	@FindBy(xpath="//h2[contains(text(),'Profile')]")
	WebElement profileLabel;
	
	@FindBy(xpath="//form[normalize-space()='Email me when someone responds to my comments.']//button[@name='button']")
	WebElement notificationBtnSecond;
  

 public UserProfilePage()
 {
	 PageFactory.initElements(driver, this);
 }
 
 public String validateProfilePageTitle()
 {
	 return driver.getTitle();
 }
 public boolean validateLabelText()
 {
	return profileLabel.isDisplayed();
 }

 public boolean notifcationBtntwoClick()
 {
	 notificationBtnSecond.click();
	  return notificationBtnSecond.isEnabled();

 }
}
 
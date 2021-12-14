package com.rsa.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.rsa.qa.util.RsaListener;
import com.rsa.qa.util.TestUtil;



@Listeners(RsaListener.class)

public class TestBase {

	public  static WebDriver driver;
	public static Properties prop;
	
	public ExtentReports extent;
	//public ExtentTest extentLogger;

	public TestBase()
	{
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream("C:\\Users\\kushal\\eclipse-workspaceKM\\FreeCRMTest\\src\\main\\java\\com\\rsa\\qa\\config\\config.properties");

			prop.load(ip);
		}  catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void initialzation()
	{
		String browserName= prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		driver.get(prop.getProperty("url"));

	}
	
	
    

}

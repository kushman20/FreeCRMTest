package com.rsa.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.rsa.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT= 20;
	public static long IMPLICIT_WAIT=10;
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH= "C:\\Users\\kushal\\"
			+ "eclipse-workspaceKM\\FreeCRMTest\\src\\main\\java\\com\\"
			+ "crm\\qa\\testdata\\CRMprojectdata.xlsx";

 public void switchtoFrame()
 
{
    driver.switchTo().frame("mainpanel");
}

 // this is the method to fetch data from excel sheet 
 public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		try {
		 file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	sheet=	book.getSheet(sheetName);
	
	Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 // System.out.println(sheet.getLastRowNum()+"-----"+sheet.getRow(0).getLastCellNum());
	for (int i=0;i<sheet.getLastRowNum();i++)
	{
		for (int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k]= sheet.getRow(i+1).getCell(k).toString();
		//	System.out.println(data[i][k]);
		}
	}
	 return data;
	}
/*-------------------------------------------------------------------------------*/
 
 public static void failureScreencapture(String testmethodName)
	
	{
	// to attach the date and time in screenshot
	 String dateName= new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
	 //Takes Screen shot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("D:\\testScreenshot\\"+testmethodName+"_"+dateName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 

}

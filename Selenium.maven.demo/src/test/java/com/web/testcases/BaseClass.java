package com.web.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.web.utilities.BrowserConfig_01;
import com.web.utilities.ConfigData_Provider;
import com.web.utilities.ExcelData_Provider;
import com.web.utilities.Helper;

public class BaseClass {

WebDriver driver;   // has null value since not initialized
//ExcelData_Provider dp;
ConfigData_Provider cp;
ExtentReports extent;
ExtentTest logger;

	@BeforeSuite
	public void TestSuite()
	{
		//dp=new ExcelData_Provider();
		cp=new ConfigData_Provider();
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/demo6.html"));	
		extent=new ExtentReports();
		extent.attachReporter(reporter);	
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void settings(String browser)
	{		
		driver=BrowserConfig_01.BrowserConfig_detail(driver, browser, cp.getURL());
		//driver=BrowserConfig_01.BrowserConfig_detail(driver,browser,cp.getURL());
		//driver=BrowserConfig_01.BrowserConfig_detail(driver,cp.getBrowser(),cp.getURL());
	// if we don't initialize this statement to driver then quit_Browser will take the global variable which has null value
	// and will throw javanullpointer exception
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.ScreenShot_capture(driver);
			System.out.println("Failure screenshot captured");						
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			Helper.ScreenShot_capture(driver);
			System.out.println("Pass screenshot captured");		
		}		
		
		extent.flush();		
		Thread.sleep(4000);		
		BrowserConfig_01.quit_Browser(driver);
	}
	
	@DataProvider(name = "ExcelData")
	public String[][] data()
	{
		ExcelData_Provider obj=new ExcelData_Provider();
		int rows=obj.rowCount(2);		
		String[][] data=new String[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=obj.cell_row(2,i, 0);
			data[i][1]=obj.cell_row(2,i, 1);
		}		
		return data;				
	}
	
	
}

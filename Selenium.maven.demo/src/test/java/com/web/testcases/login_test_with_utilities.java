package com.web.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.web.pages.home_page01;
import com.web.pages.login_page01;
import com.web.utilities.ExcelData_Provider;

public class login_test_with_utilities extends BaseClass
{	
	/*@Test(description = "Veify page title",priority = 1)
	public void XAP_page_title() throws InterruptedException
	{
		logger=extent.createTest("Page Title");		
		String actual_title=driver.getTitle();
		String Expected_title="XAP";		
		System.out.println("Title of page is : "+actual_title);	
		
		try {
			Assert.assertEquals(actual_title,Expected_title,"Title do not match, log a defect");
			logger.pass("Page Title match");
				} catch (AssertionError e) {
					logger.fail("Page title do not match");
					System.out.println("Assertion error is: "+e.getMessage());
					}
	}
	
	/*@Test(description = "Verify login with blank credentials",priority = 2)
	public void XAP_login_blank_crec() throws InterruptedException
	{
		login_page01 obj1=new login_page01(driver);
		PageFactory.initElements(driver, obj1);
		obj1.login();		
		Thread.sleep(3000);	
		
		String actual_error_txt=driver.findElement(By.xpath("//*[@id=\"lblErrorMessage\"]")).getText();
		String expected_error_txt="Login name can not be blank.1";		
		System.out.println("Error text is: "+actual_error_txt);
		
		ExtentTest logger=extent.createTest("Login with blank credentials");	
		
		if(actual_error_txt.equals(expected_error_txt))
			{
				logger.pass("Error text match");
			}
			else
				{	
					logger.fail("Error text do not match");
					
				}
	}
	
	@Test(description = "Verify login with valid and invalid credentials",priority = 3,dataProvider ="ExcelData")
	public void XAP_login(String uname1,String pwd1) throws InterruptedException
	{
		ExtentTest logger=extent.createTest("Login with valid,invalid credentials");
		
		login_page01 obj1=new login_page01(driver);
		PageFactory.initElements(driver, obj1);
		obj1.login(uname1, pwd1);		

		try {
			Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://intranet.xavient.com/xap/Dashboards/EmployeeDashboard.aspx"),
					"Incorrect credential. ");
			logger.pass("Correct credential");
			
		} catch (AssertionError e) {
			logger.fail("Incorrect credential");
			System.out.println("Assertion error is: "+e.getMessage());
		}	
			
	}*/
	
	@Test(dataProvider ="ExcelData")
	public void XAP_logout(String uname1,String pwd1)
	{
		login_page01 obj=new login_page01(driver);
		PageFactory.initElements(driver, obj);
		obj.login(uname1, pwd1);
			
		ExtentTest logger1=extent.createTest("XAP logout");
					
		home_page01 obj1=new home_page01(driver);
		PageFactory.initElements(driver, obj1);
		obj1.logout(driver);	
		
		String expected_logout_link="https://intranet.xavient.com/XAP/Login.aspx?reason=LogOut";
		
		try {
			Assert.assertEquals(driver.getCurrentUrl(), expected_logout_link,"Logout not successfull, log a defect");
			logger1.pass("XAP logout success");
		} catch (AssertionError e) {
			logger1.fail("XAP logout fail");
			System.out.println("Assertion error is: "+e.getMessage());
		}
		
	}

}

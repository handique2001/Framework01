package com.web.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login_test_without_utility {
	
	WebDriver driver;
	
	@BeforeMethod
	public void driver_config()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\HANDIK\\Selenium Docs\\Jar files\\ChromeDriver\\09 July\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://intranet.xavient.com/xap/");
	}
	
	@AfterMethod
	public void browser_close()
	{
		driver.quit();
	}
	
	/*@Test(description = "Verify Page Title", priority = 1)
	public void XAP_page_title()
	{				
		String actual_login_page_title_name=driver.getTitle();
		System.out.println("Login page title is : "+actual_login_page_title_name);
		
		String expected_page_title="XAP1";

		Assert.assertEquals(actual_login_page_title_name, expected_page_title,"Page title do not match, log a defect.");
		System.out.println("Page title match, pass the test case");		
	}
		
	@Test(description = "Verify XAP Login credential",priority = 2)
	public void XAP_login()
	{				
		driver.findElement(By.xpath("//input[@id=\"txtLoginName\"][@name=\"txtLoginName\"]")).sendKeys("pranjal.handique@telusinternational.com");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\" and @type=\"password\"]")).sendKeys("Password7#");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"][@type=\"submit\"]")).click();
	
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://intranet.xavient.com/xap/Dashboards/EmployeeDashboard.aspx"),
				"Incorrect credntial");	
		System.out.println("Correct credential and Login successfull, pass the test case");
	}
	
	@Test(description = "Verify XAP Invalid Login credential",priority = 3)
	public void XAP_invalid_login()
	{				
		driver.findElement(By.xpath("//input[@id=\"txtLoginName\"][@name=\"txtLoginName\"]")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\" and @type=\"password\"]")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"][@type=\"submit\"]")).click();
		
		try {
			Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://intranet.xavient.com/xap/Dashboards/EmployeeDashboard.aspx"),
					"Incorrect credntial");	
			System.out.println("Correct credential and Login successfull, pass the test case");
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		finally
		{
		
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"][@type=\"submit\"]")).click();	
			
		WebElement elm03=driver.findElement(By.xpath("//*[@id=\"btnLogin\"][@type=\"submit\"]//preceding::span[2][@id=\"lblErrorMessage\"]"));
		String actual_text01=elm03.getText();
		System.out.println("Message displayed is : "+actual_text01);
		
		String expected_text02="Login name can not be blank.1";
		
		try {
			Assert.assertEquals(actual_text01, expected_text02,"Error message do not match, log defect ! ");
			System.out.println("Error message match, pass the test case");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		finally {
		Boolean status01=actual_text01.contains(expected_text02);
		System.out.println(status01);
		
		if(status01)
		{
			System.out.println("Pass the test case");
		}
		else
		{
			System.out.println("Fail the test case");
		}
		
		}
		}
	}
	*/
	
	@Test(description = "Verify XAP Logout",priority = 4)
	public void XAP_Logout()
	{
		driver.findElement(By.xpath("//input[@id=\"txtLoginName\"][@name=\"txtLoginName\"]")).sendKeys("pranjal.handique@telusinternational.com");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\" and @type=\"password\"]")).sendKeys("Password7#");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"][@type=\"submit\"]")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://intranet.xavient.com/xap/Dashboards/EmployeeDashboard.aspx"),
				"Incorrect credntial");	
		System.out.println("Correct credential and Login successfull, pass the test case");
		
		Actions act=new Actions(driver);
		WebElement elm01=driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement elm02=driver.findElement(By.xpath("//*[@href=\"/XAP/logout.aspx\"]"));
		
		String expected_logout_link="https://intranet.xavient.com/XAP/Login.aspx?reason=LogOut";		
		
		act.moveToElement(elm01).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		act.click(elm02).build().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), expected_logout_link,"Logout not successfull, log a defect");
		System.out.println("Logout successfull, pass the test case. ");
	}
	
	/*@Test(description = "Verify XAP Leave Apply",priority = 5)
	public void XAP_Leave_Apply()
	{
		driver.findElement(By.xpath("//input[@id=\"txtLoginName\"][@name=\"txtLoginName\"]")).sendKeys("pranjal.handique@telusinternational.com");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\" and @type=\"password\"]")).sendKeys("Password7#");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"][@type=\"submit\"]")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://intranet.xavient.com/xap/Dashboards/EmployeeDashboard.aspx"),
				"Incorrect credntial");	
		System.out.println("Correct credential and Login successfull");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		WebElement elm04=driver.findElement(By.xpath("//ul[@id=\"sidebar\"]/li[2]/a"));
		WebElement elm05=driver.findElement(By.xpath("//ul[@id=\"sidebar\"]/li[2]//preceding::li[@id=\"menuULeave\"]"));
		WebElement elm06=driver.findElement(By.xpath("//ul[@id=\"sidebar\"]/li[2]//preceding::li[@id=\"menuULeave\"]//li[@id=\"mnuLeftApplyLeave\"]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(elm04).build().perform();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		act.moveToElement(elm05).click().build().perform();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	
		act.moveToElement(elm06).click().build().perform();
	
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		String expected_leave_url="https://intranet.xavient.com/XAP/LMS/Leave/LeaveRequest.aspx";
		
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(expected_leave_url),"Apply Leave url not launched, log a defect");
		System.out.println("Apply Leave url launched successfully");
		
		WebElement elm07=driver.findElement(By.xpath("//label[contains(text(),\"Leave Type\")]/following::select[1]"));
		
		Select leave_type=new Select(elm07);
		List<WebElement> list01=leave_type.getOptions();
		
		for(WebElement ref:list01)
		{
			//String list=ref.getText();
			System.out.println("Dropdown values are : "+ref.getText());
			
			if(ref.getText().contains("COVID"))
			{
				leave_type.selectByVisibleText(ref.getText());
				System.out.println("Leave selected is : "+ref.getText());
				
				try {
					Thread.sleep(4000);
					} catch (InterruptedException e) 
					{
					System.out.println(e.getMessage());
					}	
				break;
			 }
			
		}
		
		driver.findElement(By.xpath("//*[@class=\"btn default date-set\"]")).click();	
		
		try {
			Thread.sleep(4000);
			} catch (InterruptedException e) 
			{
			System.out.println(e.getMessage());
			}
			
		List<WebElement> list02=driver.findElements(By.xpath("//table[@class=\" table-condensed\"]//td[@class=\"day\"]"));	
		
		for(WebElement ref1:list02)
		{
			System.out.println("Available date are "+ref1.getText());
			
			if(ref1.getText().contains("24"))
			{
				ref1.click();			
				//System.out.println("Date selected is : "+ref1.getText());
				
				try {
					Thread.sleep(4000);
					} catch (InterruptedException e) 
					{
					System.out.println(e.getMessage());
					}
				
				break;
			 }
		 }// for loop closure
		
		driver.findElement(By.xpath("//*[@id=\"txtToDate\"]")).click();
		System.out.println("From To Date");		
		
		List<WebElement> list03=driver.findElements(By.xpath("//*[@id=\"txtToDate\"]//following::table[1]//td[@class=\"day\"]"));
		
		for(WebElement ref2:list03)
		{
			System.out.println("Available date are "+ref2.getText());
			
			if(ref2.getText().contains("24"))
			{
				ref2.click();			
				//System.out.println("Date selected is : "+ref2.getText());
				
				try {
					Thread.sleep(4000);
					} catch (InterruptedException e) 
					{
					System.out.println(e.getMessage());
					}
				
				break;
			 }
		 }// for loop closure
		
		driver.findElement(By.xpath("//*[contains(text(),\"Reason\")]//following::textarea[1]")).sendKeys("COVID 19 Leave");
		
		try {
			Thread.sleep(4000);
			} catch (InterruptedException e) 
			{
			System.out.println(e.getMessage());
			}
		
		//WebElement elm08=driver.findElement(By.xpath("//*[@id=\"btnSaveLeave\"]/following::input[1]"));
		WebElement elm09=driver.findElement(By.xpath("//input[@id=\"btnSaveLeave\"]"));
				
		//String Cancel_button=elm08.getText();
		//System.out.println("Click Cancel button ");
		System.out.println("Click Apply button ");
		
		//elm08.click();
		elm09.click();
		
		try {
			Thread.sleep(4000);
			} catch (InterruptedException e) 
			{
			System.out.println(e.getMessage());
			}
		
		String expected_leave_list="https://intranet.xavient.com/XAP/LMS/Leave/MyLeaveList.aspx1";
		//Assert.assertEquals(driver.getCurrentUrl(),expected_leave_list,"Leave List table not displayed, log defect");
		
		boolean status02=driver.getCurrentUrl().equalsIgnoreCase(expected_leave_list);
		
		if(status02)
		{		
		System.out.println("Leave List Page displayed successfully");
		}
		else
		{
			System.out.println("Leave List Page not displayed, log defect");
		}
		
  }*/

}
		
				
		
		
	
	



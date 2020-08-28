package com.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_page01 

{	
	@FindBy
	(xpath = "//input[@id=\"txtLoginName\"][@name=\"txtLoginName\"]") WebElement uname;
	
	@FindBy
	(xpath = "//input[@id=\"txtPassword\" and @type=\"password\"]") WebElement pwd;
	
	@FindBy
	(xpath = "//input[@id=\"btnLogin\"][@type=\"submit\"]") WebElement click;
	
	public login_page01(WebDriver driver)
	{
		
	}
	
	public void login()
	{
		uname.sendKeys("");
		pwd.sendKeys("");
		click.click();
	}
	
	public void login(String usname,String psswd)
	{
		uname.sendKeys(usname);
		pwd.sendKeys(psswd);
		click.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("Capture error message : "+e.getMessage());
		}
	}
}

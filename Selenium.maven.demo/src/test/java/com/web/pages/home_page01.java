package com.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class home_page01 

{	
	@FindBy
	(xpath = "//*[@id=\"username\"]") WebElement logout_link;
	
	@FindBy
	(xpath = "//*[@href=\"/XAP/logout.aspx\"]") WebElement logout;
	
	public home_page01(WebDriver driver)
	{
		
	}
	
	public void logout(WebDriver driver)
	{
		//Actions act=new Actions(driver);
		Actions act=new Actions(driver);
		act.moveToElement(logout_link).build().perform();
		try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			}
		
		//comment added
		act.click(logout).build().perform();
		
		try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			}
	}

}

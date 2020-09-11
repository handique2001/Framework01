package Practice;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class login extends Base
{			
	@Test
	public void valid_login()
	{		
		login_page obj=new login_page(driver);
		logger=extent.createTest("Verify login with valid credentials");
		
		try {
			obj.login();		
			String sign_out=obj.Sign_out.getText();
			logger.info("Action for valid login");
			Assert.assertTrue(driver.getPageSource().contains(sign_out));	
			logger.pass("Correct credential, login success ");
			} catch (Exception e) {
			logger.info("Action for invalid login");
			logger.fail("Incorrect credential. "+e.getMessage());
			}
	}
	
	@Test
	public void Page_Title()
	{	
		logger=extent.createTest("Verify login page title");
		String expected_page_title="My Account – Automation Practice Site";
		String actual_page_Title=driver.getTitle();
		
		try {			
			logger.info("Action when page title match, working as expected");
			Assert.assertEquals(expected_page_title,actual_page_Title);			
			logger.pass("Title match, expected behaviour");			
			} catch (AssertionError e) {
			logger.info("Action when page title do not match");
			logger.fail("Title do not match, log defect. "+e.getMessage());
			}			
	}
	
	@Test
	public void invalid_login_and_error_message()
	{
		login_page obj=new login_page(driver);	
		logger=extent.createTest("Verify invalid login and error message");
		
		try {
			obj.login();		
			String sign_out=obj.Sign_out.getText();
			Assert.assertTrue(driver.getPageSource().contains(sign_out));			
			logger.info("Login success");
			logger.pass("Login success with credential");
				} catch (Exception e) {
			logger.info("Login not success");
			logger.pass("Incorrect credential. "+e.getMessage());
			}

		String expected_error_txt="Error: A user could not be found with this email address.1";
		String actual_error_txt=obj.Actual_Error_txt.getText();
		
		try {
			Assert.assertEquals(actual_error_txt, expected_error_txt);
			logger.info("Verify error message");
			logger.pass("Error message match, working as expected");
			} catch (AssertionError e) {
			logger.info("Verify error message");
			logger.fail("Error message do not match, log defect. "+e.getMessage());
			}	
	}
	
	@Test
	public void checkbox_default()
	{
		login_page obj=new login_page(driver);		
		logger=extent.createTest("Verify the default checbox");
		System.out.println("Checkbox enabled : "+obj.checkbox.isEnabled());
		System.out.println("Checkbox textname is : "+obj.checkbox_text.getText());		
		
		try {
			Assert.assertTrue(obj.checkbox.isEnabled());
			logger.info("Verify checkobx is enabled");
			logger.pass("Checkbox is enabled, expected behaviour");
			} catch (Exception e) {
			logger.info("Verify checkbox is enabled");
			logger.fail("Checkbox is disabled, log defect. "+e.getMessage());
			}	
		
		try {
			obj.checkbox_default();		
			logger.info("Verify checbox is clickable");
			logger.pass("Checbox is clickable, expected behaviour");
			} catch (Exception e) {
			logger.info("Verify checbox is clickable");
			logger.fail("Checbox is not clickable, log defect. "+e.getMessage());
			}
	}
	
	@Test
	public void checkbox_uncheck()
	{
		logger=extent.createTest("Verify the checbox is unchecked");
		login_page obj=new login_page(driver);		
				
		try {
			obj.checkbox_uncheck();
			Assert.assertTrue(!obj.checkbox.isSelected());
			logger.info("Verify checbox is unchecked");
			logger.pass("Checkbox unchecked, expected behaviour");
			} catch (AssertionError e) {
			logger.info("Verify checbox is unchecked");
			logger.fail("Checkbox checked even after unchecking, log a defect. "+e.getMessage());
			}
	}
	
	@Test
	public void lost_password_link()
	{
		logger=extent.createTest("Verify lost password link and navigation");
		login_page obj=new login_page(driver);		
		System.out.println("Link name is : "+obj.lost_password_link.getText());
		
		try {
			Assert.assertTrue(obj.lost_password_link.isEnabled());
			logger.info("Verify link is enabled");
			logger.pass("Link is enabled, expected behaviour");
			} catch (Exception e) {
			logger.info("Verify link is enabled");
			logger.fail("Link is disabled, log a defect. "+e.getMessage());
			}
				
		try {
			obj.forgot_password();
			Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://practice.automationtesting.in/my-account/lost-password/1"));
			logger.info("Verify lost password page display");
			logger.fail("Lost password page displayed, as expected");
			} catch (AssertionError e1) {
			logger.info("Verify lost password page display");
			logger.fail("Lost password page not displayed, log a defect. "+e1.getMessage());
			}
		
		driver.navigate().back();
		try {
			Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://practice.automationtesting.in/my-account/1"));
			logger.info("Verify login page display");
			logger.pass("Login page displayed, expected behaviour");			
			} catch (AssertionError e1) {
			logger.info("Verify login page display");
			logger.fail("Login page not displayed, log a defect. "+e1.getMessage());
			}
		
		try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}		
	}
	
	
	

}

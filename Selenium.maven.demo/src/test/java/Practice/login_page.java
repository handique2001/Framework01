package Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page 
{	
	WebDriver driver;
	
	@FindBy
	(xpath = "//*[@id=\"username\"]") WebElement uname;
	
	@FindBy
	(xpath = "//input[@id=\"password\"]") WebElement password;
	
	@FindBy
	(xpath = "//input[@id=\"password\"]//following::input[3]") WebElement login_click;
	
	@FindBy
	(xpath = "//*[contains(text(),\"Sign out\")]") WebElement Sign_out;
	
	@FindBy
	(xpath = "//*[@id=\"username\"]//preceding::li[1]") WebElement Actual_Error_txt;
	
	@FindBy
	(xpath = "//input[@id=\"rememberme\"]") WebElement checkbox;
	
	@FindBy
	(xpath = "//*[text()=\" Remember me				\"]") WebElement checkbox_text;
	
	@FindBy
	(xpath = "//*[contains(text(),\"Lost your password?\")]") WebElement lost_password_link;
	
	
	public login_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{		
		uname.sendKeys("pranjal.handik620@gmail.com1");	//pranjal.handik620@gmail.com
		Helper.highlight_element(driver, uname);
		
		password.sendKeys("Auto@20052012$");			//Auto@20052012$
		Helper.highlight_element(driver, password);
		
		login_click.click();
		Helper.highlight_element(driver, login_click);		

		try {
			Thread.sleep(4000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
	}
	
	public void checkbox_default()
	{
		
		checkbox.click();
		Helper.highlight_element(driver, checkbox);
				
		try {
			Thread.sleep(3000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
	}
	
	public void checkbox_uncheck()	{
		checkbox.click();
		Helper.highlight_element(driver, checkbox);
		
		try {
			Thread.sleep(3000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
		
		checkbox.click();
		Helper.highlight_element(driver, checkbox);
		
		try {
			Thread.sleep(3000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
	}
	
	public void forgot_password()
	{
		lost_password_link.click();	
		Helper.highlight_element(driver, lost_password_link);
		try {
			Thread.sleep(5000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
		
	}

}

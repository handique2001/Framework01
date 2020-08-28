package com.web.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig_01 {

	public static WebDriver BrowserConfig_detail(WebDriver driver,String Browser_name,String web_url)
	{
			if(Browser_name.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver=new ChromeDriver();
			}
		else if(Browser_name.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
			}
		else
			{
				System.out.println("We dont suppot this browser");
			}
				
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  
		// wait max 30 secs for the page to load, throw TimeoutException if page not loaded within the defined time frame , 
		// default is 30 sec
		
		driver.manage().window().maximize(); 	// maximize the web browser window
		driver.get(web_url);					// launch url		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// wait the driver until the element is searched and found, if we don't provide this wait and the element(s) take time to load,
		// it will throw NoSuchElementException as driver will be unable to locate the elements, default is 0, zero. 
		// Applied globally throughout the script
		
		return driver;		
	}
	
	public static void quit_Browser(WebDriver driver)
	{
		driver.quit();
	}

}

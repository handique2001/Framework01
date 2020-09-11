package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser 
{
	static WebDriver driver;
	
	public static WebDriver BrowserConfig(String b_name,String url)
	{
				if(b_name.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					driver=new ChromeDriver();
				}
				else if(b_name.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("Browser not supported");
				}
				
				/*Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
				String browser_name=cap.getBrowserName().toUpperCase();
				System.out.println("Browser name is : "+browser_name);
				String version_name=cap.getVersion();
				System.out.println("Version name is : "+version_name);*/
								
				driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
				driver.manage().window().maximize();					
				driver.get(url);		
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				try {
					Thread.sleep(4000);
						} catch (InterruptedException e) {
					System.out.println("Error is : "+e.getMessage());
					}
				
				return driver;		
	}
	
	public static void quit_browser()
	{
		driver.quit();
	}

}

package Practice;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {	
	
	WebDriver driver;
	Config_call cc;
	ExtentReports extent;	
	ExtentTest logger;
	
	@BeforeSuite
	public void suitr()
	{	
		
	cc=new Config_call();	
		
	File path=new File(System.getProperty("user.dir")+"./Reports/Reports_Practice/status.html");
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(path);
	extent=new ExtentReports();
	extent.attachReporter(reporter);	
	
	}	
	
	@BeforeMethod
	public void set_up()
	{
		driver=Browser.BrowserConfig(cc.getBrowser(),cc.getURL());		
	}
	
	@AfterMethod
	public void tear_down()	
	{	
		try {
			Thread.sleep(2000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
		
		extent.flush();
		
		Browser.quit_browser();
	}
	

}

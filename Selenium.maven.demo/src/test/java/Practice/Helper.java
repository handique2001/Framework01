package Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public static void highlight_element(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;')", element);
		
		try {
			Thread.sleep(3000);
				} catch (InterruptedException e) {
			System.out.println("Error is : "+e.getMessage());
			}
		
		js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);
		
	}

}

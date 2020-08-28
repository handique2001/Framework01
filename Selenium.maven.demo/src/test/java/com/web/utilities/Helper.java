package com.web.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import java.util.logging.FileHandler;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	//Screenshot,
	
	public static void ScreenShot_capture(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./ScreenShots/"+getStringDate() +".png"));
			System.out.println("Capture screenshot success");
			
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		 }
	}
	
	public static String getStringDate()
	{
		DateFormat date_format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date current_date=new Date();
		return date_format.format(current_date);
		
	}

}

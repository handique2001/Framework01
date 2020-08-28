package com.web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigData_Provider 
{
	Properties prop;
	
	public ConfigData_Provider()   // when object of this constructor is created it will call the constructor and execute the below code to 
									// store,read the properties file> store the properties key,value pair in global variable prop and 
									// can be used by calling the methods
	{
		File src=new File("./Config/config.properties");
		try {
			FileInputStream fiss=new FileInputStream(src);  // read data from a file in the form of sequence of bytes
			prop=new Properties();	// to access the methods of Properties we create object 	 
			prop.load(fiss);  //This method reads a property list (key and element pairs) from the input byte stream
		}  catch (IOException e) {
		System.out.println("Not able to capture config file "+e.getMessage());
		}				
	 }
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("QA_url");
	}

	
}

package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_call 
{
	Properties prop;
	
	public Config_call()
	{
		File src=new File("C:\\Users\\HANDIQUE\\git\\Framework01\\Selenium.maven.demo\\src\\test\\java\\Practice\\browser_url.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			}  catch (IOException e) {
			System.out.println(e.getMessage());
			}
	}
	
	public String getBrowser()
	{
		return prop.getProperty("browser");			
	}
	
	public String getURL()
	{
		return prop.getProperty("qa_url");
	}

}

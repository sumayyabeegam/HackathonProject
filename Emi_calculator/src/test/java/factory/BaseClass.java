package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	static Properties p;
	static WebDriver driver;
	//To initialize browser
	public static WebDriver getWebDriver() throws IOException {	
		Properties obj = new Properties();
		File file= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		FileInputStream f = new FileInputStream(file);
		obj.load(f);		
		String browserName=obj.getProperty("browser");	
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
				 driver=new EdgeDriver();
		}
		else {
			System.out.println("Enter a Valid Browser");
		}	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
   //To load property file
	public static Properties getProperties() throws IOException
	{		 
	   FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	   p=new Properties();
	   p.load(file);
		return p;

	}

}

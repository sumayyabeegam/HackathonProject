package factory;
import java.io.File;
 
import java.io.FileInputStream; 
import java.io.FileReader; 
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Baseclass {
 
	static Properties p;
	static WebDriver driver;
 
	public static WebDriver getWebDriver() throws IOException {		
		if(getProperties().getProperty("browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(getProperties().getProperty("browser").equalsIgnoreCase("edge")) {
				 driver=new EdgeDriver();
		}
		else {
			System.out.println("Enter a Valid Browser");
		}	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static Properties getProperties() throws IOException
	{		
	   FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	   p=new Properties();
	   p.load(file);
       return p;
 
	}
 
}
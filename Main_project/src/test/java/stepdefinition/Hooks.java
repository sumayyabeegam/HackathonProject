package stepdefinition;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import factory.Baseclass;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
public class Hooks {
public static WebDriver driver;
static Properties p;
@BeforeAll
public static  void setup() throws IOException, InterruptedException
{
	driver=Baseclass.getWebDriver();
	p=Baseclass.getProperties();
	//Thread.sleep(2000);
	driver.get(p.getProperty("appURL"));	
	driver.manage().window().maximize();
	Thread.sleep(5000);

}
 
//@After

//public void tearDown(Scenario scenario) {   		

//  driver.quit();  

//}

}

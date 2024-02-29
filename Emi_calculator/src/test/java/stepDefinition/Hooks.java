package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;
	 static Properties p;
	@BeforeAll
	@BeforeTest
	public static  void setup() throws IOException, InterruptedException
	{
		driver=BaseClass.getWebDriver();    	
		p=BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}

	@AfterAll
	public static void tearDown()
	{
		driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {
	  if(!scenario.isFailed()) {
	  	TakesScreenshot ts=(TakesScreenshot) driver;
	  	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	  	scenario.attach(screenshot, "image/png",scenario.getName());
	  }
	}


}

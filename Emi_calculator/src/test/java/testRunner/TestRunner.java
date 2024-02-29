package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//FeatureFile/InterestRate.feature"},
		glue= {"stepDefinition"},
		plugin = {"pretty","html:target/cucumber-reports/report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				tags="regression"
		
		
		)
public class TestRunner {
	

}

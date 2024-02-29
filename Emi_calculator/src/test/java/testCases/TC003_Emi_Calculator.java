package testCases;

import org.testng.annotations.Test;

import pageObjects.EmiCalculator;
import testBase.BaseClass;

public class TC003_Emi_Calculator extends BaseClass{
	
	@Test(priority=1,groups={"sanity"})
	public void emi_calculator_Validation()
	{
		logger.info("****Emi validation initiated****");
		EmiCalculator emi=new EmiCalculator(driver);
		emi.menu_click();
		emi.loanAmountValidation();
		logger.info("****Emi validation ended****");
	}

}

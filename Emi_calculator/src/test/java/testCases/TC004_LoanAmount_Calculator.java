package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanAmountCalculator;
import testBase.BaseClass;

public class TC004_LoanAmount_Calculator extends BaseClass {
	
	@Test(priority=1,groups={"regression"})
	public void Test4_001()
	{
		logger.info("****Loan Amount validation initiated****");
		LoanAmountCalculator loan=new LoanAmountCalculator(driver);
		loan.SwitchtototalAmount();
		loan.LoanAmountvalidation();
		logger.info("****Loan Amount validation initiated****");
	}

}

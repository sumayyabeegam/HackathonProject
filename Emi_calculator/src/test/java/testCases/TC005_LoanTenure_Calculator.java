package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanTenureCalculator;
import testBase.BaseClass;

public class TC005_LoanTenure_Calculator extends BaseClass {
	
	@Test(priority=1,groups={"regression"})
	public void Test5_001()
	{
		logger.info("****Loan Tenure validation initiated****");
		LoanTenureCalculator loan_tenure=new LoanTenureCalculator(driver);
		loan_tenure.switchToLoanTenure();
		loan_tenure.loanTenureValidation();
		logger.info("****Loan Amount validation initiated****");
	}

}

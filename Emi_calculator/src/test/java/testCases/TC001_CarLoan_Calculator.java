package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.CarLoan;
import pageObjects.EmiCalculator;
import pageObjects.HomeLoan;
import pageObjects.LoanAmountCalculator;
import pageObjects.LoanTenureCalculator;
import testBase.BaseClass;
public class TC001_CarLoan_Calculator extends BaseClass{
	
	@Test(priority=1,groups={"regression"})
    public void Test1_001() throws IOException
    {
		CarLoan car=new CarLoan(driver);
		car.click_carloan();
    	 }
	@Test(priority=2,groups={"sanity"})
	public void Test1_002() throws IOException {
		CarLoan car=new CarLoan(driver);
		car.setLoanAmount();
		car.setInterestRate();
	}
	@Test(priority=3,groups={"sanity"})
	public void Test1_003() throws IOException {
		CarLoan car=new CarLoan(driver);
		car.setLoanTerm();
		car.getTotalEmi();
	
		
		car.getEmi();
		car.getPrincipalAmount(); 
	}
}
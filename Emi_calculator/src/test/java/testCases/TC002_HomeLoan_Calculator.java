package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomeLoan;
import testBase.BaseClass;



public class TC002_HomeLoan_Calculator extends BaseClass {
	@Test(priority=1,groups={"regression"})
	public void Test2_001() throws IOException 
	{
		HomeLoan home=new HomeLoan(driver);
		home.click_Menu();
		home.setHomePrice();
		
	}
	@Test(priority=2,groups={"regression"})
	public void Test2_002() throws IOException {
		HomeLoan home=new HomeLoan(driver);
		home.setDownPay();
		home.setTenure();
		home.setInsurance();
		home.scrollToTable();
	}
	@Test(priority=3,groups={"sanity"})
	public void Test2_004() throws IOException {
		HomeLoan home=new HomeLoan(driver);
		home.storingDataToExcel();
	}
		
}

	


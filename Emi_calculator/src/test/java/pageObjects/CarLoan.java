package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ReadExcel;

public class CarLoan extends BasePage{

	public CarLoan(WebDriver driver) {
		super(driver);
		
	}
    @FindBy(xpath="//a[text()='Car Loan']")
    WebElement carloanbutton;
    
	@FindBy(xpath="//input[@id='loanamount']")
	WebElement car_loan_amount;
	
	@FindBy(xpath="//*[@id='loaninterest']")
	WebElement loan_interest;
	
	@FindBy(xpath="//input[@id='loanterm']")
	WebElement loan_term;
	
	@FindBy(xpath="//div[@id='emiamount']")
	WebElement emi_ele;
	
	@FindBy(xpath="(//*[@class='btn btn-secondary'])[1]")
	WebElement month;
	
	@FindBy(xpath="//div[@id='emitotalinterest']")
	WebElement total_interest;
	
	@FindBy(xpath="//div[@id='emitotalamount']")
	WebElement total_amount;
	@FindBy(xpath="//div[@id='emiamount']")
	WebElement total_emi;
	
	String file = (System.getProperty("user.dir")+"/testData/input.xlsx");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	public void click_carloan()
	{
		carloanbutton.click();
	}
	
	public void setLoanAmount() throws IOException
	{
		car_loan_amount.clear();
		car_loan_amount.sendKeys(Keys.BACK_SPACE);
		String str=ReadExcel.getCellData(file,"Sheet1", 1, 0);
		car_loan_amount.sendKeys(str);
	}
	
	public void setInterestRate() throws IOException
	{
		loan_interest.clear();
		loan_interest.sendKeys(Keys.BACK_SPACE);
		String str=ReadExcel.getCellData(file,"Sheet1", 1, 1);
		loan_interest.sendKeys(str);
	}
	
	public void setLoanTerm() throws IOException
	{
		loan_term.clear();
		loan_term.sendKeys(Keys.BACK_SPACE);
		String str=ReadExcel.getCellData(file,"Sheet1", 1, 2);
		loan_term.sendKeys(str);
		
	}
	
	public void getTotalEmi()
	{
		js.executeScript("arguments[0].scrollIntoView();", total_emi);
		String emi=total_emi.getText();
		System.out.println(emi);
		
	}
	public String getEmi()
	{
		return emi_ele.getText();	
	}
	
	public int getInterest()
	{
		month.click();
		loan_term.sendKeys(Keys.BACK_SPACE);
		month.click();
		
		String interest=total_interest.getText();
		String[] s1=interest.split("₹");
		String[] s2=s1[1].split(",");

		String interest_amount=s2[0]+s2[1];
		int emiInt=Integer.parseInt(interest_amount);
		System.out.println("Monthly Interest: "+emiInt);
		return emiInt;
			
	}
	public int getPrincipalAmount()
	{
		int interest=getInterest();
		String total_pay=total_amount.getText();
		String[] s3=total_pay.split("₹");
		String[] s4=s3[1].split(",");
		String pm=s4[0]+s4[1]+s4[2];
		int pmInt=Integer.parseInt(pm);
		System.out.println("Pricipal Amount:"+(pmInt-interest));	
		return pmInt-interest;
		
	}
	
}
	

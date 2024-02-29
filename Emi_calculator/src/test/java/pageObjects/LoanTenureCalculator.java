package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanTenureCalculator extends BasePage {

	public LoanTenureCalculator(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//li[@id='loan-tenure-calc']")
	WebElement loan_tenure_menu;
	@FindBy(xpath="//input[@id='loanamount']")
	WebElement loan_amount;
	@FindBy(xpath="(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]")
	WebElement loan_amount_slider;
	@FindBy(xpath="//input[@id='loanemi']")
	WebElement emi_checkbox;
	@FindBy(xpath="(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]")
	WebElement emi_slider;
	@FindBy(xpath="//input[@id='loaninterest']")
	WebElement interest_checkbox;
	@FindBy(xpath="(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]")
	WebElement interest_slider;
	@FindBy(xpath="//input[@id='loanfees']")
	WebElement fees;
	@FindBy(xpath="(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[5]")
	WebElement fees_slider;
	
	public void switchToLoanTenure()
	{
		loan_tenure_menu.click();
	}
	public void loanTenureValidation()
	{
		if(loan_amount.isEnabled()==true)
		{
			System.out.println("Validation for Loan Tenure Calculator page");
			System.out.println("-----------------------------------");
			System.out.println("AmountcheckBox is validated");
		}
		if(loan_amount_slider.isEnabled()==true)
		{
			System.out.println("Amount Slider is validated");
		}
		if(emi_checkbox.isEnabled()==true)
		{
			System.out.println("Emi checkBox is validated");
		}
		if(emi_slider.isEnabled()==true)
		{
			System.out.println("Emi Slider is validated");
		}
		if(interest_checkbox.isEnabled()==true)
		{
			System.out.println("Interest Rate checkBox is validated");
		}
		if(interest_slider.isEnabled()==true)
		{
			System.out.println("Interest Rate Slider is validated");
		}
		if(fees.isEnabled()==true)
		{
			System.out.println("Fees and charges tenure checkBox is validated");
		}
		if(fees_slider.isEnabled()==true)
		{
			System.out.println("Fees and charges Slider is validated");
		}
	}
}

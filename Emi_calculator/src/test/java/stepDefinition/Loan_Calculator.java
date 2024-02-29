package stepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EmiCalculator;
import pageObjects.LoanAmountCalculator;
import pageObjects.LoanTenureCalculator;

public class Loan_Calculator {
	EmiCalculator emi=new EmiCalculator(BaseClass.getDriver());
	LoanAmountCalculator loan=new LoanAmountCalculator(BaseClass.getDriver());
	LoanTenureCalculator loan_tenure=new LoanTenureCalculator(BaseClass.getDriver());
	
	@Given("User should navigate to Loan Calculator")
	public void User_should_navigate_to_Loan_Calculator() {
		emi.menu_click();
	}
	
	@Then("perform UI check for each text box and scale for emi calculator")
	public void perform_ui_check_for_each_text_box_and_scale_for_emi_calculator() {
		emi.loanAmountValidation();
	}

	@When("click on Amount calculator")
	public void click_on_amount_calculator() {
		loan.SwitchtototalAmount();
	}

	@Then("perform UI check for each text box and scale for loan amount calculator")
	public void perform_ui_check_for_each_text_box_and_scale_for_loan_amount_calculator() {
		loan.LoanAmountvalidation();
	}

	@When("click on Loan Tenure calculator")
	public void click_on_loan_tenure_calculator() {
		loan_tenure.switchToLoanTenure();
	}

	@Then("perform UI check for each text box and scale for loan tenure calculator")
	public void perform_ui_check_for_each_text_box_and_scale_for_loan_tenure_calculator() {
		loan_tenure.loanTenureValidation();
	}

}

package stepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarLoan;
import pageObjects.EmiCalculator;
import pageObjects.HomeLoan;
import pageObjects.LoanAmountCalculator;
import pageObjects.LoanTenureCalculator;


public class CarLoan_Calculator {
	
	CarLoan car =new CarLoan(BaseClass.getDriver());
	
	@Given("User should navigate to Home page")
	public void User_should_navigate_to_Home_page() {
		car.click_carloan();
	}

	@When("enter car loan amount, interest rate and loan tenure")
	public void enter_car_loan_amount_interest_rate_and_loan_tenure() throws IOException {
		car.setLoanAmount();
		car.setInterestRate();
		car.setLoanTerm();
	}

	@Then("find Emi for one year")
	public void find_emi_for_one_year() {
		car.getTotalEmi();
	}

	@Then("display interest amount for one month")
	public void display_interest_amount_for_one_month() {
		car.getEmi();
	}

	@Then("display principal amount for one month")
	public void display_principal_amount_for_one_month() {
		car.getPrincipalAmount(); 
	}

}

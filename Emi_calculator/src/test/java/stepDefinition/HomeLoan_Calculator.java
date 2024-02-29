package stepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomeLoan;

public class HomeLoan_Calculator {
	HomeLoan home=new HomeLoan(BaseClass.getDriver());
	@Given("User should navigate to HomeLoan EMI Calculator")
	public void User_should_navigate_to_HomeLoan_EMI_Calculator() {
		home.click_Menu();
	}

	@When("fill relevant details")
	public void filling_relevant_details() throws IOException {
		home.setHomePrice();
		home.setDownPay();
		home.setTenure();
		home.setInsurance();
	}

	@Then("store year table in excel")
	public void storing_year_table_in_excel() throws IOException {
		home.scrollToTable();
		home.storingDataToExcel();
	}


}

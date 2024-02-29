Feature: Emi Calculator

  @Regression
  Scenario: Calculate Car Loan Emi
    Given User should navigate to Home page
    When enter car loan amount, interest rate and loan tenure
    Then find Emi for one year
    And display interest amount for one month
    And display principal amount for one month

  @Regression @sanity
  Scenario: Home Loan Emi Calculator
    Given User should navigate to HomeLoan EMI Calculator
    When fill relevant details
    Then store year table in excel

  @Regression
  Scenario: Emi,Amount and Loan Tenure Calculator UI check
    Given User should navigate to Loan Calculator
    Then perform UI check for each text box and scale for emi calculator
    When click on Amount calculator
    Then perform UI check for each text box and scale for loan amount calculator
    When click on Loan Tenure calculator
    Then perform UI check for each text box and scale for loan tenure calculator

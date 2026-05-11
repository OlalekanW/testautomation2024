package stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RateCalculatorPage;
import utilities.ConfigUtil;
import utilities.WebDriverHelpers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RateCalculatorSteps {
    private WebDriverHelpers webDriverHelpers;
    private RateCalculatorPage rateCalculatorPage;
    private ConfigUtil configUtil;

    public RateCalculatorSteps(WebDriverHelpers _webDriverHelpers, RateCalculatorPage _rateCalculatorPage, ConfigUtil _configUtil){

        this.webDriverHelpers = _webDriverHelpers;
        this.rateCalculatorPage = _rateCalculatorPage;
        this.configUtil = _configUtil;

    }

    @Given("that a user loads an application under test")
    public void thatAUserLoadsAnApplicationUnderTest() throws IOException {
      webDriverHelpers.driver.get(configUtil.loadEnvProfileData("baseUrl"));
      //webDriverHelpers.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @When("a user inputs {int} into GBP text field")
    public void aUserInputsIntoGBPTextField(int currencyValue) throws InterruptedException {
        rateCalculatorPage.enterCurrencyGBPValue(String.valueOf(currencyValue));
    }

    @Then("a user sees {double} value in NGN text field")
    public void aUserSeesValueInNGNTextField(double currencyValueNGN) throws InterruptedException {
        String expectedCurrencyValue = String.valueOf(currencyValueNGN);
        String actualCurrencyValue = String.valueOf(rateCalculatorPage.getCurrencyNGNValue());

        Assert.assertEquals(expectedCurrencyValue, actualCurrencyValue);
    }

    @When("a user clicks on send Now button")
    public void aUserClicksOnSendNowButton() {
        rateCalculatorPage.clickSendNowButton();
    }

    @And("a user selects {string} as the bank option")
    public void aUserSelectsAsTheBankOption(String bankName) {
      rateCalculatorPage.selectBankDropDown(bankName);
    }

    @And("a user inputs {string} as the account number")
    public void aUserInputsAsTheAccountNumber(String accountNumber) {
        rateCalculatorPage.enterAccountNumber(accountNumber);
    }

    @And("a user clicks on send button")
    public void aUserClicksOnSendButton() {
       rateCalculatorPage.clickOnSendButton();
    }

    @Then("the text {string} message should appear")
    public void theTextMessageShouldAppear(String successText) {
       Assert.assertEquals(rateCalculatorPage.getTransactionSuccessText(), successText);
    }
}

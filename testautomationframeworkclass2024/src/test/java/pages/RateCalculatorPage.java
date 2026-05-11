package pages;
import org.openqa.selenium.By;
import utilities.WebDriverHelpers;

import java.time.Duration;

    public class RateCalculatorPage {

    private WebDriverHelpers webDriverHelpers;

    By currencyTextBox_GbP = By.xpath("//*[@class='from-currency p-1']");
    By currencyTextBox_NGN = By.cssSelector("input.to-currency");
    By sendNowButton = By.xpath("//*[@class='send-now m-top-2']");
    By selectBankOption = By.xpath("//*[@class='select-bank p-1']");
    By accountNumberTextBox = By.xpath("//*[@class='account-number p-1 m-top-2']");
    By sendButton = By.xpath("//*[@class='send m-top-2']");
    By TransactionSuccessTxt = By.xpath("//*[@class='success']");

    public RateCalculatorPage(WebDriverHelpers _webDriverHelpers){
        this.webDriverHelpers = _webDriverHelpers;
    }

    public void enterCurrencyGBPValue(String currencyValueGBP) throws InterruptedException{
        webDriverHelpers.driver.findElement(currencyTextBox_GbP).sendKeys(currencyValueGBP);
        webDriverHelpers.driver.findElement(currencyTextBox_GbP).clear();
        Thread.sleep(Duration.ofSeconds(5));
        webDriverHelpers.driver.findElement(currencyTextBox_GbP).sendKeys(currencyValueGBP);
    }

    public double getCurrencyNGNValue(){
       //String nairaConvertedvalue = webDriverHelpers.driver.findElement(currencyTextBox_NGN).getText();
       //return nairaConvertedvalue;
        String actualValue = webDriverHelpers.driver.findElement(currencyTextBox_NGN).getAttribute("value");
        return Double.parseDouble(actualValue);
    }
    public void clickSendNowButton(){

        webDriverHelpers.driver.findElement(sendNowButton).click();
    }

    public void selectBankDropDown(String bankName ) {
        webDriverHelpers.SelectItemFromDropDown(selectBankOption, bankName);

    }
    public void enterAccountNumber(String accountNumber){
        webDriverHelpers.driver.findElement(accountNumberTextBox).sendKeys(accountNumber);
    }

    public void clickOnSendButton(){
        webDriverHelpers.driver.findElement(sendButton).click();
    }

    public String getTransactionSuccessText(){
        return webDriverHelpers.driver.findElement(TransactionSuccessTxt).getText();
    }


}


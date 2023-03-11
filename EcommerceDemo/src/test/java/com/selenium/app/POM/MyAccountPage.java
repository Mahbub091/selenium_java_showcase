package com.selenium.app.POM;

import com.selenium.app.baseConfiguration.ConfigReader;
import com.selenium.app.utility.CustomUtils;
import com.selenium.app.utility.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    int time_out_max = 60;
    int time_out_min = 30;
    int pause_normal = 1;
    int pause_long = 2;
    int pause_extended = 3;
    WebDriver driver;
    TestUtils testUtils;
    ConfigReader configReader;

    CustomUtils customUtils;
    Logger log = LogManager.getLogger("MyAccountPage");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
        configReader = new ConfigReader();
        customUtils = new CustomUtils(driver);
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "/html//div[@id='content']/div/div[1]/div[@class='card mb-4']/div[@class='card-body p-4']")
    WebElement registrationBox;

    @FindBy(xpath = "/html//div[@id='content']/div[@class='row']//form[@action='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']")
    WebElement loginBox;

    @FindBy(xpath = "/html//div[@id='content']/div[@class='row']//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")
    WebElement registrationContinueButton;

    @FindBy(xpath = "/html//input[@id='input-email']")
    WebElement accountEmailAddress;

    @FindBy(xpath = "/html//input[@id='input-password']")
    WebElement accountPassword;

    @FindBy(xpath = "/html//div[@id='content']//form[@action='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']/input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "/html//div[@id='content']/div[1]/div[@class='card-body text-center']/div[@class='row']/div")
    WebElement myAccountOptions;








    /**
     * We'll define the methods here.
     */

    public void validatingRegisterAndLoginBox() {
        try {
            testUtils.waitForElementVisibility(registrationBox, time_out_max);
            testUtils.waitForElementVisibility(loginBox, time_out_min);
            testUtils.validatingHrefOfElement(registrationContinueButton, configReader.registrationPageURL());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loginToRegisteredAccount() {

        testUtils.waitForElementVisibility(accountEmailAddress, time_out_max);
        testUtils.waitForElementVisibility(accountPassword, time_out_max);
        testUtils.waitForElementVisibility(loginButton, time_out_min);
        testUtils.clearTextBox(accountEmailAddress);
        testUtils.enteringText(accountEmailAddress, configReader.loginEmail());
        testUtils.clearTextBox(accountPassword);
        testUtils.enteringText(accountPassword, configReader.loginPassword());
        testUtils.clickingElement(loginButton);
        testUtils.wait(pause_normal);
        testUtils.assertUrl(configReader.accountPageURL());
        customUtils.validatingMultipleMenus();
    }






















    public void test(){

    }
}

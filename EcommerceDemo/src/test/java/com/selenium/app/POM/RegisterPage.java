package com.selenium.app.POM;

import com.selenium.app.baseConfiguration.ConfigReader;
import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    int time_out_max = 60;
    int time_out_min = 30;
    int pause_normal = 1;
    int pause_long = 2;
    int pause_extended = 3;
    WebDriver driver;
    TestUtils testUtils;
    ConfigReader configReader;
    Logger log = LogManager.getLogger("RegisterPage");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
        configReader = new ConfigReader();
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "/html//div[@id='content']/div/div[1]/div[@class='card mb-4']/div[@class='card-body p-4']")
    WebElement registerAccountBox;
    @FindBy(xpath = "/html//div[@id='content']/div[@class='row']//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")
    WebElement registerContinueButton;
    @FindBy(css = "[class] .list-group-item:nth-of-type(1)")
    WebElement loginMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(2)")
    WebElement registerMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(3)")
    WebElement forgottenPasswordMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(4)")
    WebElement myAccountMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(5)")
    WebElement addressBookMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(6)")
    WebElement wishListMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(7)")
    WebElement orderHistoryMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(8)")
    WebElement downloadsMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(9)")
    WebElement recurringPaymentsMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(10)")
    WebElement rewardPointsMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(11)")
    WebElement returnsMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(12)")
    WebElement transactionsMenu;
    @FindBy(css = "[class] .list-group-item:nth-of-type(13)")
    WebElement newsletterMenu;
    @FindBy(xpath = "/html//input[@id='input-firstname']")
    WebElement firstName;
    @FindBy(xpath = "/html//input[@id='input-lastname']")
    WebElement lastName;
    @FindBy(xpath = "/html//input[@id='input-email']")
    WebElement email;
    @FindBy(xpath = "/html//input[@id='input-telephone']")
    WebElement phoneNumber;
    @FindBy(xpath = "/html//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "/html//input[@id='input-confirm']")
    WebElement confirmPassword;
    @FindBy(css = "[for='input-agree']")
    WebElement agreeToTermsAndPolicy;
    @FindBy(css = "div#content > form[method='post'] input[value='Continue']")
    WebElement continueButton;





    /**
     * We'll define the methods here.
     */

    public void registerBoxActions(){
        try{
            testUtils.waitForElementVisibility(registerAccountBox, time_out_max);
            testUtils.waitForElementVisibility(registerContinueButton, time_out_min);
            testUtils.waitForElementIsClickable(registerContinueButton, time_out_min);
            testUtils.clickingElement(registerContinueButton);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void validatingNewURLandMenuText(){
        testUtils.assertUrl(configReader.registrationPageURL());
        testUtils.validateElementsToHaveExpectedText(loginMenu, "Login");
        testUtils.validateElementsToHaveExpectedText(registerMenu, "Register");
        testUtils.validateElementsToHaveExpectedText(forgottenPasswordMenu, "Forgotten Password");
        testUtils.validateElementsToHaveExpectedText(myAccountMenu, "My Account");
        testUtils.validateElementsToHaveExpectedText(addressBookMenu, "Address Book");
        testUtils.validateElementsToHaveExpectedText(wishListMenu, "Wish List");
        testUtils.validateElementsToHaveExpectedText(orderHistoryMenu, "Order History");
        testUtils.validateElementsToHaveExpectedText(recurringPaymentsMenu, "Recurring payments");
        testUtils.validateElementsToHaveExpectedText(rewardPointsMenu, "Reward Points");
        testUtils.validateElementsToHaveExpectedText(returnsMenu, "Returns");
        testUtils.validateElementsToHaveExpectedText(transactionsMenu, "Transactions");
        testUtils.validateElementsToHaveExpectedText(downloadsMenu, "Downloads");
        testUtils.validateElementsToHaveExpectedText(newsletterMenu, "Newsletter");
    }

    public void enterRegisterMenuDetails(){
        log.info("Entering Details On Register Menu");
        try{
            testUtils.waitForElementVisibility(firstName, time_out_min);
            testUtils.enteringText(firstName, Data.FIRST_NAME);
            testUtils.waitForElementVisibility(lastName, time_out_min);
            testUtils.enteringText(lastName, Data.LAST_NAME);
            testUtils.waitForElementVisibility(email, time_out_min);
            testUtils.enteringText(email, Data.EMAIL);
            testUtils.waitForElementVisibility(phoneNumber, time_out_min);
            testUtils.enteringText(phoneNumber, Data.TELEPHONE);
            testUtils.waitForElementVisibility(password, time_out_min);
            testUtils.enteringText(password, Data.PASSWORD);
            testUtils.waitForElementVisibility(confirmPassword, time_out_min);
            testUtils.enteringText(confirmPassword, Data.PASSWORD);
            testUtils.waitForElementIsClickable(agreeToTermsAndPolicy, time_out_min);
            testUtils.clickingElement(agreeToTermsAndPolicy);
            testUtils.clickingElement(continueButton);
        } catch (Exception e){
            e.printStackTrace();
        }
    }












}

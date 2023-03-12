package com.selenium.app.Tests;

import com.selenium.app.POM.HomePage;
import com.selenium.app.POM.MyAccountPage;
import com.selenium.app.POM.RegisterPage;
import com.selenium.app.baseConfiguration.BaseTest;
import com.selenium.app.baseConfiguration.ConfigReader;
import com.selenium.app.utility.CustomUtils;
import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    MyAccountPage myAccountPage;
    TestUtils testUtils;
    ConfigReader configReader;
    CustomUtils customUtils;
    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        myAccountPage = new MyAccountPage(driver);
        testUtils = new TestUtils(driver);
        configReader = new ConfigReader();
        customUtils = new CustomUtils(driver);
    }

    @Test(testName = "Test_02_01", description = "Creating A New Account ")
    public void Test_02_01() {
        homePage.visit(configReader.getAppURL());
        homePage.validatingUrl(configReader.getAppURL());
        homePage.assertingTitle(Data.PAGE_TITLE);
        homePage.menuCheck();
        homePage.clickOnMyAccountButton();
        registerPage.registerBoxActions();
        registerPage.validatingNewURLandMenuText();
        registerPage.enterRegisterMenuDetails();
        registerPage.verifyAccountCreation();
    }

    @Test(testName = "Test_02_02", description = "Logging In As Registered User")
    public void Test_02_02(){
        homePage.hoverAndClickOnLoginMenu();
        homePage.validatingUrl(configReader.loginPageUrl());
        myAccountPage.validatingRegisterAndLoginBox();
        myAccountPage.loginToRegisteredAccount();
        customUtils.checkingUserMenuItem();
        customUtils.clickingElementBySortingOutFromUserMenu("My Account");
        customUtils.clickingElementBySortingOutFromUserMenu("Edit Account");
        customUtils.clickingElementBySortingOutFromUserMenu("Password");
        customUtils.clickingElementBySortingOutFromUserMenu("Address Book");
        customUtils.clickingElementBySortingOutFromUserMenu("Wish List");
        customUtils.clickingElementBySortingOutFromUserMenu("Notification");
        customUtils.clickingElementBySortingOutFromUserMenu("Order History");
        customUtils.clickingElementBySortingOutFromUserMenu("Downloads");
        customUtils.clickingElementBySortingOutFromUserMenu("Recurring payments");
        customUtils.clickingElementBySortingOutFromUserMenu("Reward Points");
        customUtils.clickingElementBySortingOutFromUserMenu("Returns");
        customUtils.clickingElementBySortingOutFromUserMenu("Transactions");
        customUtils.clickingElementBySortingOutFromUserMenu("Newsletter");
        customUtils.clickingElementBySortingOutFromUserMenu("Logout");
    







        testUtils.wait(2);
    }
}

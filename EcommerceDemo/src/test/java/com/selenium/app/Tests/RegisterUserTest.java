package com.selenium.app.Tests;

import com.selenium.app.POM.HomePage;
import com.selenium.app.POM.RegisterPage;
import com.selenium.app.baseConfiguration.BaseTest;
import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    private WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    TestUtils testUtils;
    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        testUtils = new TestUtils(driver);
    }

    @Test(testName = "Test_02_01", description = "Creating A New Account ")
    public void Test_02_01() {

        // Staring Test Case
        homePage.visit(Data.HOME_PAGE);
        homePage.validatingUrl(Data.HOME_PAGE);
        homePage.assertingTitle(Data.PAGE_TITLE);
        homePage.menuCheck();
        homePage.clickOnMyAccountButton();
        registerPage.registerBoxActions();
        registerPage.validatingNewURLandMenuText();
        registerPage.enterRegisterMenuDetails();
    }

    @Test(testName = "Test_02_02", description = "Navigating And Creating A New User")
    public void Test_02_02(){















        testUtils.wait(3);
    }
}

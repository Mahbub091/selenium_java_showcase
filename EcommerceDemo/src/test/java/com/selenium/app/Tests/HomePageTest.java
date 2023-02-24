package com.selenium.app.Tests;

import com.selenium.app.POM.HomePage;
import com.selenium.app.baseConfiguration.BaseTest;
import com.selenium.app.utility.Data;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private WebDriver driver;

    HomePage homePage;

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @Test(testName = "Test_01_01", description = "Validating Url")
    public void Test_01_01() {

        // Staring Test Case

        homePage.visit(Data.HOME_PAGE);
        homePage.validatingUrl(Data.HOME_PAGE);
        homePage.assertingTitle(Data.PAGE_TITLE);
        homePage.menuCheck();
        homePage.clickOnMyAccountButton();
    }

    @Test(testName = "Test_01_02", description = "Random")
    public void Test_01_02(){
        HomePage homePage = new HomePage(driver);
        homePage.enteringTextOnSearBox();
        homePage.clickingTheSearchButton();
    }
}

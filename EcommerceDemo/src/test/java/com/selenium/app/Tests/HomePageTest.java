package com.selenium.app.Tests;

import com.selenium.app.POM.HomePage;
import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    private WebDriver driver;

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();

    }

    @Test(testName = "Test_01_01", description = "Validating Url")
    public void Test_01_01() {
        HomePage homePage = new HomePage(driver);
        TestUtils testUtils = new TestUtils(driver);

        // Staring Test Case

        homePage.visit(Data.HOME_PAGE);
        testUtils.wait(3);
        homePage.validatingUrl(Data.HOME_PAGE);
        homePage.enteringTextOnSearBox();
        homePage.clickingTheSearchButton();
    }
}

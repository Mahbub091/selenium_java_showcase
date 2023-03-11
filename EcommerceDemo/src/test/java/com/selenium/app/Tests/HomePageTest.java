package com.selenium.app.Tests;

import com.selenium.app.POM.HomePage;
import com.selenium.app.baseConfiguration.BaseTest;
import com.selenium.app.baseConfiguration.ConfigReader;
import com.selenium.app.utility.CustomUtils;
import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private WebDriver driver;

    HomePage homePage;
    TestUtils testUtils;
    CustomUtils customUtils;
    ConfigReader configReader;

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        homePage = new HomePage(driver);
        testUtils = new TestUtils(driver);
        customUtils= new CustomUtils(driver);
        configReader = new ConfigReader();
    }

    @Test(testName = "Test_01_01", description = "Searching For Desired Product")
    public void Test_01_01() {

        homePage.visit(configReader.getAppURL());
//        customUtils.checkingLinks(); This code will check all the links to find any broken links available on the page.
        homePage.validatingUrl(configReader.getAppURL());
        homePage.assertingTitle(Data.PAGE_TITLE);
        homePage.enteringTextOnSearBox(Data.IPHONE);
        homePage.clickingTheSearchButton();
        homePage.selectingCategoryByText();
        homePage.searchNewProduct("apple");
        homePage.selectingDifferentCountOnProductDropdown();
        homePage.checkingAllProducts();
        homePage.selectingSortBy();
        testUtils.wait(3);

    }
}

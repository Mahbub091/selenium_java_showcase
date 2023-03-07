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

    /**
     * Go to ecommerce-playground.lambdatest.io
     * Type "iphone"
     * Click on iPhone…
     * Click on All Categories…
     * Click on SEARCH
     * Drag highlighted button
     * Type "apple"
     * Click on SEARCH
     * Click on Search Criteria
     * Click on All Categories
     * Click on 25 from Show:
     * Click on Best sellers from Sort By:
     * Click on MacBook Pro
     * Click on Apple Cinema 30&quot;
     * Click on Apple Cinema 30"
     *
     */

    @Test(testName = "Test_01_01", description = "Validating Url")
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

    @Test(testName = "Test_01_02", description = "Random")
    public void Test_01_02(){

    }
}

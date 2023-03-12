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
    WebDriver driver;
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
    @Test(testName = "Test_01_01", description = "Validating Header Menu & Navigation")
    public void Test_01_01() {
        homePage.visit(configReader.getAppURL());
        //        customUtils.checkingLinks(); This code will check all the links to find any broken links available on the page.
        homePage.validatingUrl(configReader.getAppURL());
        homePage.assertingTitle(Data.PAGE_TITLE);
        customUtils.clickingElementBySortingOutFromHeaderMenuList("blog");
        homePage.validatingUrl(configReader.blogPageURL());
        customUtils.clickingElementBySortingOutFromHeaderMenuList("special");
        homePage.validatingUrl(configReader.specialPageURL());
        customUtils.clickingElementBySortingOutFromHeaderMenuList("mega menu");
        homePage.validatingUrl(configReader.megaMenuPageURL());
        customUtils.clickingElementBySortingOutFromHeaderMenuList("addons");
        customUtils.clickingElementBySortingOutFromHeaderMenuList("my account");
        homePage.validatingUrl(configReader.loginPageUrl());
        customUtils.clickingElementBySortingOutFromHeaderMenuList("home");
        homePage.validatingUrl(configReader.homePageURL());
        homePage.hoverAndClickOnTopCategoriesSideMenu();
        testUtils.wait(2);
        customUtils.validatingTopCategoriesMenu();
        homePage.closingTopCategoriesSection();


    }

    @Test(testName = "Test_01_02", description = "Searching For Desired Product")
    public void Test_01_02() {
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

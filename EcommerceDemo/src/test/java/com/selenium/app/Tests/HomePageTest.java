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

        homePage.visit(Data.HOME_PAGE);
//        homePage.checkingLinks(); TODO: Uncomment this line to check the broken links on the current page.
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

package com.selenium.app.Tests;

import com.selenium.app.POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    private WebDriver driver;

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @Test(testName = "Test_01_01", description = "Validating Url")
    public void Test_01_01() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.validatingUrl("https://ecommerce-playground.lambdatest.io/");
        homePage.accountButton();
        homePage.registerAccount();
    }

    @Test(testName = "Test_01_02", description = "Clicking Button")
    public void Test_01_02(){
        System.out.println("Closing driver");
        driver.quit();
    }
}

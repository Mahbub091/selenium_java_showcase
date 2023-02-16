package com.selenium.app.Tests;

import com.selenium.app.DriverPoolManager;
import com.selenium.app.POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

    protected DriverPoolManager driverManager;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupTest(String browser) {
        try {
            driverManager = new DriverPoolManager();
            driverManager.startBrowser(browser);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        try
        {
            if(driverManager != null)
                driverManager.stopDriver();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

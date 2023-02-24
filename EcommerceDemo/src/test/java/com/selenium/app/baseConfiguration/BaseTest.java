package com.selenium.app.baseConfiguration;

import com.selenium.app.resources.DriverPoolManager;
import com.selenium.app.utility.Data;
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
        System.out.println(Data.TestStart);
    }

    @AfterClass(alwaysRun = true)
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
        System.out.println(Data.TestComplete);
    }
}

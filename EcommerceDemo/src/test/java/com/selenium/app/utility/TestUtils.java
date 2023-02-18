package com.selenium.app.utility;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

    private WebDriver driver = null;
    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("Test Paused For " + seconds + " seconds");
    }
}

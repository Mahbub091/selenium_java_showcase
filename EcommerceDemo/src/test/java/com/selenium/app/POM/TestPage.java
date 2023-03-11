package com.selenium.app.POM;

import com.selenium.app.baseConfiguration.ConfigReader;
import com.selenium.app.utility.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {

    int time_out_max = 60;
    int time_out_min = 30;
    int pause_normal = 1;
    int pause_long = 2;
    int pause_extended = 3;
    WebDriver driver;
    TestUtils testUtils;
    ConfigReader configReader;
    Logger log = LogManager.getLogger("TestPage");

    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
        configReader = new ConfigReader();
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(xpath = "/html//div[@id='content']/div/div[1]/div[@class='card mb-4']/div[@class='card-body p-4']")
    WebElement registerAccountBox;


    /**
     * We'll define the methods here.
     */

    public void test() {
    log.info("Test");
    }

}

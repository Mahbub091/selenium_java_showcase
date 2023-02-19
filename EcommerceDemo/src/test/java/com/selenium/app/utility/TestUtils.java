package com.selenium.app.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {

    private WebDriver driver = null;

    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will give the object of "By"
     *
     * @param locator e.g : //div[@class='demo']_xpath
     * @return By object
     */
    public By getByObject(String locator) {
        locator = locator.trim();
        By byObj = null;
        if (locator.endsWith("_xpath")) {
            byObj = By.xpath(locator.replaceAll("_xpath", ""));
        } else if (locator.endsWith("_css")) {
            byObj = By.cssSelector(locator.replaceAll("_css", ""));
        } else if (locator.endsWith("_id")) {
            byObj = By.id(locator.replaceAll("_id", ""));
        } else if (locator.endsWith("_linkText")) {
            byObj = By.linkText(locator.replaceAll("__linkText", ""));
        } else if (locator.endsWith("_name")) {
            byObj = By.name(locator.replaceAll("_name", ""));
        }

        return byObj;

    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("Test Paused For " + seconds + " seconds");
    }

    public void clickingElement(WebElement element){
        try {
            System.out.println("Clicking On The " + element);
            element.click();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * It will check that an element is present on the DOM of a page and visible.
     *
     * @param seconds
     */
    public void waitForElementIsClickable(WebElement webElement, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * It will check that an element is present on the DOM of a page and visible.
     *
     * @param locator
     * @param seconds
     */
    public void waitForElementVisibility(String locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(locator)));

    }

    /**
     * It will Log your Texts on Terminal.
     *
     */

    public void terminalLog(String logText) {
        System.out.println(logText);
    }
}

package com.selenium.app.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {

    private WebDriver driver = null;

    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will Log your Texts on Terminal.
     */

    public void terminalLog(String logText) {
        System.out.println(logText);
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
            this.terminalLog("Clicking On: " + element);
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
     * @param seconds
     */
    public void waitForElementVisibility(WebElement webElement, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * It will perform mouse hover operation on the WebElement.
     * @param elementToHover
     */
    public void mouseHover(WebElement elementToHover) {
        this.terminalLog("Hovering to: " + elementToHover);
        Actions hover = new Actions(driver);
        hover.moveToElement(elementToHover);
        hover.build();
        hover.perform();
    }
}

package com.selenium.app.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {

    private WebDriver driver = null;
    Logger log = LogManager.getLogger("HomePage");

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
        log.info("Test Paused For: " + seconds + " Seconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    public void clickingElement(WebElement element){
        log.info("Clicking On Element: " + element);
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
     */
    public void waitForElementIsClickable(WebElement webElement, long seconds) {
        log.info(("Waiting For Element Is Clickable: " + webElement));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * It will check that an element is present on the DOM of a page and visible.
     */
    public void waitForElementVisibility(WebElement webElement, long seconds) {
        log.info("Waiting For Visibility Of: " + webElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * It will perform mouse hover operation on the WebElement.
     */
    public void mouseHover(WebElement elementToHover) {
        log.info("Hovering to: " + elementToHover);
        Actions hover = new Actions(driver);
        hover.moveToElement(elementToHover);
        hover.build();
        hover.perform();
    }

    /**
     * It will enter Text.
     */
    public void enteringText(WebElement element, String text){
        try{
            element.isDisplayed();
            element.sendKeys(text);
        } catch(Exception exception){
            exception.printStackTrace();
        }
        log.info("Entering: " + text + "on" + element);
    }

    /**
     * It will perform mouse hover operation on the WebElement using javascript.
     */
    public void mouseHoverUsingJs(WebElement elementToHover) {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);}else if(document.createEventObject){ arguments[0].fireEvent('onmouseover');}";
        ((JavascriptExecutor) driver).executeScript(mouseOverScript, elementToHover);
    }
}

package com.selenium.app.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestUtils {
    WebDriver driver;
    Logger log = LogManager.getLogger("TestUtils");
    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will Log your Texts on Terminal.
     */
    public void terminalLog(String logText) {
        System.out.println(logText);
    }

    /**
     * It will highlight the web element
     * @param element
     */
    public void highlightWebElement(WebElement element) {
        try{
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].setAttribute('style', 'background:#ffffb3; border:3px solid green;');", element);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * It will highlight the web element
     * @param seconds
     */
    public void wait(int seconds) {
        log.info("Test Paused : [{}] Seconds", seconds);
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    /**
     * It will check that an element is present on the DOM of a page and visible.
     * @param element
     *
     */
    public void clickingElement(WebElement element){
        log.info("Clicking On Element: [{}]", element);
        try {
            element.click();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * It will check that an element is present on the DOM of a page and visible.
     * @param webElement
     * @param seconds
     *
     */
    public void waitForElementIsClickable(WebElement webElement, long seconds) {
        log.info("Waiting For Element [{}] Is Clickable within [{}] Seconds ", webElement, seconds);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * It will check that an element is present on the DOM of a page and visible.
     * @param webElement
     * @param seconds
     */
    public void waitForElementVisibility(WebElement webElement, long seconds) {
        log.info("Waiting for [{}] seconds on Visibility of [{}]", seconds, webElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * It will perform mouse hover operation on the WebElement.
     * @param elementToHover
     */
    public void mouseHover(WebElement elementToHover) {
        log.info("Hovering to: [{}]", elementToHover);
        try
        {
            Actions hover = new Actions(driver);
            hover.moveToElement(elementToHover);
            hover.build();
            hover.perform();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }

    }

    /**
     * It will enter Text.
     * @param element
     * @param text
     */
    public void enteringText(WebElement element, String text){
        log.info("Entering text for element: [{}] Text is :[{}]", element, text);
        try{
            element.isDisplayed();
            element.sendKeys(text);
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * It will perform mouse hover operation on the WebElement using javascript.
     * @param elementToHover
     */
    public void mouseHoverUsingJs(WebElement elementToHover) {
        log.info("Hovering Using JS: [{}]", elementToHover);
        try
        {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);}else if(document.createEventObject){ arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver).executeScript(mouseOverScript, elementToHover);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * It will validate URL
     * @param expectedUrl
     */
    public void assertUrl(String expectedUrl){
        log.info("Validating URL: " + expectedUrl);
        try{
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, expectedUrl);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * It will validate Element to Have Expected Text
     * @param element
     * @param text
     */
    public void validateElementsToHaveExpectedText(WebElement element, String text){
        log.info("Expecting Text [{}] from element: [{}]", text, element);
        try{
            String eleText = element.getText().trim();
            Assert.assertEquals(eleText, text);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * It will select the value using current text visible on dropdown.
     * @param element
     * @param visibleText
     */
    public void selectDropDownByVisibleText(WebElement element, String visibleText) {
        log.info("Selecting visibleText [{}] from dropdown, element : [{}]", visibleText, element);
        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * It will Clear any text present in the text box
     * @param element
     */
    public void clearTextBox(WebElement element) {
        log.info("Cleared text for : [{}]", element);
        try {
            highlightWebElement(element);
            element.clear();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * It will give the text present in element.
     *
     * @return element's text value
     */
    public String getText(WebElement element) {
        highlightWebElement(element);
        String elementText = element.getText();
        log.info("Text found for : [{}] is : [{}]", element, elementText);

        return elementText;
    }

    /**
     * It will get the HREF attribute from the element and cross Validate it
     * @param element
     * @param value
     */
    public void validatingHrefOfElement(WebElement element, String value) {
        log.info("Cleared text for : [{}]", element);
        try{
            String href = element.getAttribute("href");
            if (href.equals(value)){
                log.info(element + Data.Log_Design + "href Value Matches The Expected Value Of: " + value);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

package com.selenium.app.POM;

import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class HomePage {
    private WebDriver driver;
    private TestUtils testUtils;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
    }

    /**
     * Our Elements Will Be Stored Here.
     */

    @FindBy(css = "#entry_217820 [type='text']")
    WebElement searchBox;

    @FindBy(css = "div#search  .type-text")
    WebElement searchButton;

    @FindBy(css = ".horizontal .nav-item:nth-of-type(1) .title")
    WebElement homeMenu;

    @FindBy(css = ".horizontal .nav-item:nth-of-type(2) .title")
    WebElement specialMenu;

    @FindBy(css = "[class='badge mx-1 mz-menu-label-27']")
    WebElement hotLabelMenu;

    @FindBy(css = ".horizontal .nav-item:nth-of-type(3) .title")
    WebElement blogMenu;

    @FindBy(css = ".horizontal .nav-item:nth-of-type(4) .title")
    WebElement megaMenu;

    @FindBy(css = ".horizontal .nav-item:nth-of-type(5) .title")
    WebElement addOnsMenu;

    @FindBy(css = "[class='badge mx-1 mz-menu-label-25']")
    WebElement featuredMenu;

    @FindBy(css = "div#widget-navbar-217834 > ul > li:nth-of-type(6) > a[role='button']")
    WebElement myAccountMenu;

    /**
     * We'll define the methods here.
     */

    public void visit(String navigate){
        testUtils.terminalLog("Navigating to HomePage: " + Data.HOME_PAGE);
        driver.navigate().to(navigate);
        testUtils.wait(1);
    }

    public void assertingTitle(String expectedTitle){
        String title = driver.getTitle();
        testUtils.terminalLog("Validating the Title: " + title);
        Assert.assertEquals(title, expectedTitle);
    }

    public void enteringTextOnSearBox(){
        try {
            testUtils.terminalLog("Entering Text: " + Data.RandomTech);
            searchBox.isDisplayed();
            searchBox.sendKeys(Data.RandomTech);
            testUtils.wait(1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void clickingTheSearchButton(){
        try {
            testUtils.terminalLog("Clicking On Search Button");
            testUtils.waitForElementIsClickable(searchBox, 90);
            searchButton.isDisplayed();
            searchButton.click();
            testUtils.wait(1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void validatingUrl(String ExpectedUrl) {
        String url = driver.getCurrentUrl();
        testUtils.terminalLog("Validating URL: " + url);
        Assert.assertEquals(url, ExpectedUrl);
    }

    public void menuTextAssertion(WebElement element, String expectedText){
        try{
            String text = element.getText().trim();
            System.out.println("Checking Menus: " + text);
            Assert.assertEquals(text, expectedText);
        }catch (Exception e)
        {e.printStackTrace();}
    }

    public void menuCheck(){
        this.menuTextAssertion(homeMenu, "Home");
        this.menuTextAssertion(specialMenu, "Special");
        this.menuTextAssertion(hotLabelMenu, "Hot");
        this.menuTextAssertion(blogMenu, "Blog");
        this.menuTextAssertion(megaMenu, "Mega Menu");
        this.menuTextAssertion(addOnsMenu, "AddOns");
        this.menuTextAssertion(featuredMenu, "Featured");
        this.menuTextAssertion(myAccountMenu, "My account");
    }
}

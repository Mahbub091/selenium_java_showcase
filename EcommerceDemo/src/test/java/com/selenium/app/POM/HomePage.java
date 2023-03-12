package com.selenium.app.POM;

import com.selenium.app.utility.CustomUtils;
import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    int time_out_max = 60;
    int time_out_min = 30;
    int pause_normal = 1;
    int pause_long = 2;
    int pause_extended = 3;

    WebDriver driver;
    TestUtils testUtils;
    CustomUtils customUtils;
    Logger log = LogManager.getLogger("HomePage");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
        customUtils = new CustomUtils(driver);
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

    @FindBy(xpath = "//ul[@class=\"navbar-nav horizontal\"]//li//a[contains(@href,'https://ecommerce-playground.lambdatest.io/index.php?route=account/account')]")
    WebElement myAccountMenu;

    @FindBy(xpath = "//div[@id='widget-navbar-217834']/ul/li[6]/ul//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']//span[@class='title']")
    WebElement loginMenu;

    @FindBy(xpath = "//div[@class=\"dropdown\"]//ul[@class=\"dropdown-menu autocomplete w-100\"]")
    WebElement homepageSearchBarSuggestions;
    @FindBy(xpath = "//select[@name=\"category_id\"]")
    WebElement categorySection;

    @FindBy(xpath = "//div[@class=\"col-sm-5 mb-3\"]//input[@name=\"search\"]")
    WebElement searchBoxInCategorySection;

    @FindBy(xpath = "//div[@class=\"col-sm-3 mb-3\"]//input[@type=\"button\"]")
    WebElement newSearchButton;

    @FindBy(xpath = "//select[@id=\"input-limit-212463\"]")
    WebElement productShowCount;

    @FindBy(xpath = "//select[@id=\"input-sort-212464\"]")
    WebElement sortBy;

    @FindBy(xpath = "//div[@id='entry_217832']/a[@role='button']")
    WebElement topCategoriesSideMenu;

    @FindBy(xpath = "//div[@id='mz-component-1626147655']//a[@href='#mz-component-1626147655']")
    WebElement topCategoriesCloseButton;



    /**
     * We'll define the methods here.
     */

    /**
     * @param navigate
     */
    public void visit(String navigate) {
        log.info("Navigating to: [{}]", navigate );
        try {
            driver.navigate().to(navigate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param expectedTitle
     */
    public void assertingTitle(String expectedTitle) {
        try {
            String title = driver.getTitle();
            Assert.assertEquals(title, expectedTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Validating Title to Have: [{}]", expectedTitle);
    }

    public void enteringTextOnSearBox(String text) {
        try {
            testUtils.waitForElementVisibility(searchBox, time_out_min);
            testUtils.enteringText(searchBox, text);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void clickingTheSearchButton() {
        try {
            searchButton.isDisplayed();
            testUtils.waitForElementIsClickable(searchBox, time_out_max);
            searchButton.click();
            testUtils.wait(pause_normal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validatingUrl(String ExpectedUrl) {
        try {
            String url = driver.getCurrentUrl();
            log.info(("Validating URL: " + url));
            Assert.assertEquals(url, ExpectedUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuTextAssertion(WebElement element, String expectedText) {
        try {
            String text = element.getText().trim();
            log.info("Validating: " + text + " Is Equal " + expectedText);
            Assert.assertEquals(text, expectedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuCheck() {
        try {
            this.menuTextAssertion(homeMenu, "Home");
            this.menuTextAssertion(specialMenu, "Special");
            this.menuTextAssertion(hotLabelMenu, "Hot");
            this.menuTextAssertion(blogMenu, "Blog");
            this.menuTextAssertion(megaMenu, "Mega Menu");
            this.menuTextAssertion(addOnsMenu, "AddOns");
            this.menuTextAssertion(featuredMenu, "Featured");
            this.menuTextAssertion(myAccountMenu, "My account");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnMyAccountButton() {
        try {
            testUtils.waitForElementVisibility(myAccountMenu, time_out_max);
            testUtils.mouseHoverUsingJs(myAccountMenu);
            testUtils.waitForElementVisibility(loginMenu, time_out_min);
            testUtils.clickingElement(loginMenu);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectingCategoryByText(){
        testUtils.waitForElementVisibility(categorySection, time_out_max);
        testUtils.selectDropDownByVisibleText(categorySection, Data.DESKTOP);
        testUtils.wait(pause_normal);
        testUtils.selectDropDownByVisibleText(categorySection, Data.LAPTOPS);
        testUtils.selectDropDownByVisibleText(categorySection, Data.COMPONENTS);
        testUtils.selectDropDownByVisibleText(categorySection, Data.Tablets);
        testUtils.selectDropDownByVisibleText(categorySection, Data.Software);
        testUtils.selectDropDownByVisibleText(categorySection, Data.PhonesPdas);
        testUtils.selectDropDownByVisibleText(categorySection, Data.Cameras);
        testUtils.selectDropDownByVisibleText(categorySection, Data.MP3Players);
    }

    public void searchNewProduct(String text){
        testUtils.waitForElementVisibility(searchBoxInCategorySection, time_out_min);
        testUtils.clearTextBox(searchBoxInCategorySection);
        testUtils.enteringText(searchBoxInCategorySection, text);
        testUtils.waitForElementVisibility(newSearchButton, time_out_min);
        testUtils.clickingElement(newSearchButton);
        testUtils.wait(pause_extended);
    }

    public void selectingDifferentCountOnProductDropdown(){
        testUtils.waitForElementVisibility(productShowCount, time_out_max);
        testUtils.selectDropDownByVisibleText(productShowCount, "25");
        testUtils.selectDropDownByVisibleText(productShowCount, "50");
        testUtils.selectDropDownByVisibleText(productShowCount, "75");
        testUtils.selectDropDownByVisibleText(productShowCount, "100");
    }

    public void checkingAllProducts(){
        testUtils.clearTextBox(searchBox);
        testUtils.clickingElement(searchButton);
    }

    public void selectingSortBy(){
        testUtils.selectDropDownByVisibleText(sortBy, "Best sellers");
        testUtils.selectDropDownByVisibleText(sortBy, "Popular");
        testUtils.selectDropDownByVisibleText(sortBy, "Newest");
        testUtils.selectDropDownByVisibleText(sortBy, "Name (A - Z)");
        testUtils.selectDropDownByVisibleText(sortBy, "Name (Z - A)");
        testUtils.selectDropDownByVisibleText(sortBy, "Price (Low > High)");
        testUtils.selectDropDownByVisibleText(sortBy, "Price (High > Low)");
        testUtils.selectDropDownByVisibleText(sortBy, "Rating (Highest)");
        testUtils.selectDropDownByVisibleText(sortBy, "Rating (Lowest)");
        testUtils.selectDropDownByVisibleText(sortBy, "Model (A - Z)");
        testUtils.selectDropDownByVisibleText(sortBy, "Model (Z - A)");
        testUtils.selectDropDownByVisibleText(sortBy, "Default");
    }

    public void hoverAndClickOnLoginMenu() {
        testUtils.waitForElementVisibility(myAccountMenu, time_out_max);
        testUtils.waitForElementIsClickable(myAccountMenu, time_out_min);
        testUtils.mouseHoverUsingJs(myAccountMenu);
        testUtils.waitForElementVisibility(loginMenu, time_out_max);
        testUtils.clickingElement(loginMenu);
    }

    public void hoverAndClickOnTopCategoriesSideMenu() {
        testUtils.waitForElementVisibility(topCategoriesSideMenu, time_out_max);
        testUtils.mouseHoverUsingJs(topCategoriesSideMenu);
        testUtils.waitForElementIsClickable(topCategoriesSideMenu, time_out_min);
        testUtils.clickingElement(topCategoriesSideMenu);
    }

    public void closingTopCategoriesSection() {
        testUtils.waitForElementVisibility(topCategoriesCloseButton, time_out_max);
        testUtils.waitForElementIsClickable(topCategoriesCloseButton, time_out_max);
        testUtils.clickingElement(topCategoriesCloseButton);
    }




}

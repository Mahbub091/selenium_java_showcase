package com.selenium.app.POM;

import com.selenium.app.utility.Data;
import com.selenium.app.utility.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.apache.logging.log4j.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HomePage {
    private WebDriver driver;
    private TestUtils testUtils;
    Logger log = LogManager.getLogger("HomePage");

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

    @FindBy(xpath = "//ul[@class=\"navbar-nav horizontal\"]//li//a[contains(@href,'https://ecommerce-playground.lambdatest.io/index.php?route=account/account')]")
    WebElement myAccountMenu;

    @FindBy(xpath = "//div[@id='widget-navbar-217834']/ul/li[6]/ul//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']//span[@class='title']")
    WebElement loginMenu;

    /**
     * We'll define the methods here.
     */

    public void visit(String navigate) {
        try {
            driver.navigate().to(navigate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Navigating to " + navigate);
    }

    public void assertingTitle(String expectedTitle) {
        try {
            String title = driver.getTitle();
            Assert.assertEquals(title, expectedTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Validating Title to Have: " + expectedTitle);
    }

    public void enteringTextOnSearBox() {
        log.info("Enter Text On SearchBox: " + Data.RandomTech);
        try {
            testUtils.waitForElementVisibility(searchBox, 30);
            testUtils.enteringText(searchBox, Data.RandomTech);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void clickingTheSearchButton() {
        try {
            searchButton.isDisplayed();
            testUtils.waitForElementIsClickable(searchBox, 90);
            searchButton.click();
            testUtils.wait(1);
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
            testUtils.waitForElementVisibility(myAccountMenu, 90);
            testUtils.mouseHoverUsingJs(myAccountMenu);
            testUtils.waitForElementVisibility(loginMenu, 30);
            testUtils.clickingElement(loginMenu);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This Function Will Validate All The Links On Your Current Page
     */

    public void checkingLinks() {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
              log.info(url);
            if (url == null || url.isEmpty()) {
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    log.info(url + " is a broken link & Response code is: " + respCode);
                } else {
                    log.info(url+" is a valid link & Responded: " + respCode);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

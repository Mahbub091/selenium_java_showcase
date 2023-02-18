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

public class HomePage {
    private WebDriver driver;
    private TestUtils testUtils;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
    }

    public void visit(String navigate){
        driver.navigate().to(navigate);
    }

    @FindBy(css = "#entry_217820 [type='text']")
    WebElement searchBox;

    @FindBy(css = "div#search  .type-text")
    WebElement searchButton;

    public void enteringTextOnSearBox(){
        try {
            searchBox.isDisplayed();
            searchBox.click();
            searchBox.sendKeys(Data.RandomTech);
            testUtils.wait(1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void clickingTheSearchButton(){
        try {
            searchButton.isDisplayed();
            searchButton.click();
            testUtils.wait(1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private WebElement registerLink() {
        return driver.findElement(By.cssSelector(".mz-sub-menu-96 > li:nth-child(2) > a"));
    }

    public void validatingUrl(String ExpectedUrl) {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, ExpectedUrl);
    }

    public void accountButton() {
        WebElement accountButton = driver.findElement(By.xpath("//ul[@class='navbar-nav horizontal']//span[@class='title'][normalize-space()='Special']"));
        Actions actions = new Actions(driver);
        actions.click(accountButton).build().perform();
        testUtils.wait(3);
    }
}

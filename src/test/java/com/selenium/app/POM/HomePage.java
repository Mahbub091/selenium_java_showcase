package com.selenium.app.POM;

import com.selenium.app.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String navigate){
        driver.navigate().to(navigate);
    }

    private WebElement myAccountLink() {
        return driver.findElement(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
    }

    private WebElement registerLink() {
        return driver.findElement(By.cssSelector(".mz-sub-menu-96 > li:nth-child(2) > a"));
    }

    public void registerAccount() {
        Actions actions = new Actions(driver);

        actions.moveToElement(myAccountLink()).pause(Duration.ofSeconds(2))
                .moveToElement(registerLink()).build().perform();
    }

    public void validatingUrl(String ExpectedUrl) {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, ExpectedUrl);
    }

    public void accountButton() {
        WebElement accountButton = driver.findElement(By.xpath("//ul[@class='navbar-nav horizontal']//span[@class='title'][normalize-space()='Special']"));
        Actions actions = new Actions(driver);
        actions.click(accountButton).build().perform();
    }
}

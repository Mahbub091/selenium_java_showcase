package com.automationpractice.ecommerce.pages;
import org.openqa.selenium.WebDriver;

public class SkillTestPage extends BasePage {

    public SkillTestPage(WebDriver driver) {
        super(driver);
    }

    public void visit(String navigate){
        driver.navigate().to(navigate);
    }
}

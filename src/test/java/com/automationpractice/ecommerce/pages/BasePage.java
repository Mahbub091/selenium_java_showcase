package com.automationpractice.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//common part of the all pages are gave in the base page
public class BasePage {

    public WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver =driver;
        this.inItPage();
    }

    public void inItPage(){
        PageFactory.initElements(driver,this);
    }
}
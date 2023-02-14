package com.automationpractice.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase1RegisterUserPage extends BasePage {
    public TestCase1RegisterUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='\\/login']")
    public WebElement signInButton;
    public WebElement getSignInButton(){
        return signInButton;
    }

    @FindBy(css="div.container div.row div.col-sm-4:nth-child(3) div.signup-form > h2:nth-child(1)")
    public WebElement newUserSignupText;
    public WebElement getNewUserSignupText(){
        return newUserSignupText;
    }

    @FindBy(css="form[method='post'] > input[name='name']")
    public WebElement nameInputFieldInSignUpForm;
    public WebElement getNameInputFieldInSignUpForm() {
        return nameInputFieldInSignUpForm;
    }

    @FindBy(css = ".signup-form > form[method='post'] > input[name='email']")
    public WebElement emailInputFieldInSignUpForm;
    public WebElement getEmailInputFieldInSignUpForm() {
        return emailInputFieldInSignUpForm;
    }

    @FindBy(css = ".signup-form > form[method='post'] > .btn.btn-default")
    public WebElement signupButton;
    public WebElement getSignupButton() {
        return signupButton;
    }

    @FindBy(css = ".login-form > .text-center.title > b")
    public WebElement enterAccountInformation;
    public WebElement getEnterAccountInformation() {
        return enterAccountInformation;
    }

    @FindBy(css = "input#password")
    public WebElement passwordInputField;
    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    @FindBy(css = "select#days")
    public WebElement dayDropdown;
    public WebElement getDayDropdown() {
        return dayDropdown;
    }

    public WebElement getElement(By locator){
        return  driver.findElement(locator);
    }
    public void  dropDownSelect(By locator,String dropDownText ){
        Select select =new Select(getElement(locator));
        select.selectByVisibleText(dropDownText);
        Assert.assertEquals(dropDownText,dropDownText);
    }

    @FindBy(css = "input#newsletter")
    public WebElement newsletterCheckbox;
    public WebElement getNewsletterCheckbox() {
        return newsletterCheckbox;
    }

    @FindBy(css = "input#optin")
    public WebElement receiveSpecialOfferCheckbox;
    public WebElement getReceiveSpecialOfferCheckbox() {
        return receiveSpecialOfferCheckbox;
    }

    @FindBy(css = "#first_name")
    public WebElement firstNameInputField;
    public WebElement getFirstNameInputField() {
        return firstNameInputField;
    }

    @FindBy(css = "input#last_name")
    public WebElement lastNameInputField;
    public WebElement getLastNameInputField() {
        return lastNameInputField;
    }

    @FindBy(css = "input#company")
    public WebElement companyNameInputField;
    public WebElement getCompanyNameInputField() {
        return companyNameInputField;
    }

    @FindBy(css = "input[name='address1']")
    public WebElement adress1InputField;
    public WebElement getAdress1InputField() {
        return adress1InputField;
    }

    @FindBy(css = "input[name='address2']")
    public WebElement adress2InputField;
    public WebElement getAdress2InputField() {
        return adress2InputField;
    }

    @FindBy(css = "input#state")
    public WebElement stateInputField;
    public WebElement getStateInputField() {
        return stateInputField;
    }

    @FindBy(css = "input#city")
    public WebElement cityInputField;
    public WebElement getCityInputField() {
        return cityInputField;
    }

    @FindBy(css = "input#zipcode")
    public WebElement zipCodeInputField;
    public WebElement getZipCodeInputField() {
        return zipCodeInputField;
    }

    @FindBy(css = "input#mobile_number")
    public WebElement mobileNumberInputField;
    public WebElement getMobileNumberInputField() {
        return mobileNumberInputField;
    }

    @FindBy(xpath = "/html//section[@id='form']//form[@action='/signup']/button[@type='submit']")
    public WebElement createAccountButton;
    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    @FindBy(css = ".text-center.title > b")
    public WebElement accountCreatedText;
    public WebElement getAccountCreatedText() {
        return accountCreatedText;
    }

    @FindBy(css = ".btn.btn-primary")
    public WebElement continueButton;
    public WebElement getContinueButton() {
        return continueButton;
    }

    @FindBy(css = "li:nth-of-type(10) > a")
    public WebElement loggedInAsUsernameText;
    public WebElement getLoggedInAsUsernameText() {
        return loggedInAsUsernameText;
    }

    @FindBy(css = ".nav.navbar-nav > li:nth-of-type(5) > a")
    public WebElement deleteAccountButton;
    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    @FindBy(css = ".button-form > .btn.btn-danger")
    public WebElement deleteButton;
    public WebElement getDeleteButton() {
        return deleteButton;
    }


}

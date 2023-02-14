package com.automationpractice.ecommerce.testCases;


import com.automationpractice.ecommerce.pages.TestCase1RegisterUserPage;
import com.automationpractice.ecommerce.utilities.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1RegisterUser extends BaseClass {

    @Test
    public void testCase1RegisterUser(){

        TestCase1RegisterUserPage  tc1rup =new TestCase1RegisterUserPage(driver);

        //TC-4 Click on 'Signup / Login' button
        tc1rup.getSignInButton().click();
        System.out.println("Sign in Button Clicked");

        //TC-5  Login URL Validation / Verify that home page is visible successfully
        String loginURL = driver.getCurrentUrl();
        System.out.println("Given "+loginURL);
        Assert.assertEquals(loginURL , Data.BASE_URL + Data.LOGIN_PAGE_URL);
        System.out.println("login URL is validate");


        //TC-6 Verify 'New User Signup!' is visible
        if (tc1rup.getNewUserSignupText().isDisplayed())
        {
            String newUserSignupText= tc1rup.getNewUserSignupText().getText();
            System.out.println(newUserSignupText + Data.POSITIVE_MASSAGE);
            Assert.assertEquals(Data.NEW_USER_SIGNUP_TEXT,newUserSignupText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //TC -7 Enter name and email address
        if (tc1rup.getNameInputFieldInSignUpForm().isDisplayed())
        {
          tc1rup.getNameInputFieldInSignUpForm().sendKeys(Data.DEMO_USER_NAME);
        }
        else {
            System.out.println(tc1rup.getNameInputFieldInSignUpForm() + Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        if (tc1rup.getEmailInputFieldInSignUpForm().isDisplayed())
        {
            tc1rup.getEmailInputFieldInSignUpForm().sendKeys(Data.DEMO_EMAIL);
        }
        else {
            System.out.println(tc1rup.getEmailInputFieldInSignUpForm() + Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //7. Click 'Signup' button

        if(tc1rup.getSignupButton().isDisplayed()){
            String signupButtonText= tc1rup.getSignupButton().getText();
            Assert.assertEquals(Data.SIGNUP_BUTTON_TEXT,signupButtonText);
            System.out.println( "✔" + signupButtonText + "✔" + Data.IS_VISIBLE);
            tc1rup.getSignupButton().click();
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //TC - 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        if (tc1rup.getEnterAccountInformation().isDisplayed())
        {
            String enterAccountInformationText= tc1rup.getEnterAccountInformation().getText();
            System.out.println(enterAccountInformationText + Data.POSITIVE_MASSAGE);
            Assert.assertEquals(Data.ENTER_ACCOUNT_INFORMATION,enterAccountInformationText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //Title Mr Mrs radio button validation
        WebElement mr= driver.findElement(By.cssSelector("div:nth-of-type(1) > .top > .radio  input[name='title']"));
        WebElement mrs= driver.findElement(By.cssSelector("div:nth-of-type(2) > .top > .radio  input[name='title']"));
        if(mr.isDisplayed()){
            mr.click();
            mr.isSelected();
            System.out.println("Mr is selected");
        }else {
            System.out.println("Mr not Selected ");
        }
        sleepTest(2000);

        if(mrs.isDisplayed()){
            mrs.click();
            mrs.isSelected();
            System.out.println("Mrs is selected");
        }else {
            System.out.println("Mrs not Selected ");
        }
        sleepTest(2000);

        //TC - 8. Verify that 'Password Input Field' is visible
        if (tc1rup.getPasswordInputField().isDisplayed())
        {
            tc1rup.getPasswordInputField().sendKeys(Data.DEMO_PASSWORD);
            System.out.println("Password Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        //TC - 9. Fill details: Title, Name, Email, Password, Date of birth

        By day = By.cssSelector("select#days");
        By month =By.cssSelector("select#months");
        By year = By.cssSelector("select#years");


        tc1rup.dropDownSelect(day , "10");
        tc1rup.dropDownSelect(day,"28");

        tc1rup.dropDownSelect(month,"March");
        tc1rup.dropDownSelect(month,"April");
        tc1rup.dropDownSelect(month,"May");
        tc1rup.dropDownSelect(month,"August");
        tc1rup.dropDownSelect(month,"November");

        tc1rup.dropDownSelect(year,"2021");
        tc1rup.dropDownSelect(year,"2020");
        tc1rup.dropDownSelect(year,"2019");
        tc1rup.dropDownSelect(year,"2018");
        tc1rup.dropDownSelect(year,"2017");
        tc1rup.dropDownSelect(year,"2016");
        tc1rup.dropDownSelect(year,"2015");
        tc1rup.dropDownSelect(year,"2014");
        tc1rup.dropDownSelect(year,"2013");
        tc1rup.dropDownSelect(year,"2012");
        tc1rup.dropDownSelect(year,"2011");
        tc1rup.dropDownSelect(year,"2014");
        tc1rup.dropDownSelect(year,"2013");
        tc1rup.dropDownSelect(year,"2012");
        tc1rup.dropDownSelect(year,"2010");

        sleepTest(2000);


        // TC - 10 Select checkbox 'Sign up for our newsletter!'

        tc1rup.getNewsletterCheckbox().click();
        if(tc1rup.getNewsletterCheckbox().isSelected())
        {
            System.out.println(Data.POSITIVE_MASSAGE+ "Sign-Up Checkbox Selected");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest( 1000);

        // TC - 11 Select checkbox 'Receive special offers from our partners!'

        tc1rup.getReceiveSpecialOfferCheckbox().click();
        if(tc1rup.getReceiveSpecialOfferCheckbox().isSelected())
        {
            System.out.println(Data.POSITIVE_MASSAGE+ "Receive Checkbox Selected");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest( 1000);

        //TC - 12 Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        //First Name
        if (tc1rup.getFirstNameInputField().isDisplayed())
        {
            tc1rup.getFirstNameInputField().sendKeys(Data.FIRST_NAME);
            System.out.println("First Name Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

       //Last Name
        if (tc1rup.getLastNameInputField().isDisplayed())
        {
            tc1rup.getLastNameInputField().sendKeys(Data.LAST_NAME);
            System.out.println("last Name Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);


        //Company Name
        if (tc1rup.getCompanyNameInputField().isDisplayed())
        {
            tc1rup.getCompanyNameInputField().sendKeys(Data.COMPANY);
            System.out.println("Company Name Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);



        //Address
        if (tc1rup.getAdress1InputField().isDisplayed())
        {
            tc1rup.getAdress1InputField().sendKeys(Data.ADDRESS);
            System.out.println("Adress Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);


        //Address 2
        if (tc1rup.getAdress2InputField().isDisplayed())
        {
            tc1rup.getAdress2InputField().sendKeys(Data.ADDRESS2);
            System.out.println("Adress 2 Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //Country DropDown

        By country = By.cssSelector("select#country");

        tc1rup.dropDownSelect(country , "India");
        tc1rup.dropDownSelect(country,"Canada");
        tc1rup.dropDownSelect(country,"Australia");
        tc1rup.dropDownSelect(country,"New Zealand");
        tc1rup.dropDownSelect(country,"Singapore");
        tc1rup.dropDownSelect(country,"United States");

        // State
        if (tc1rup.getStateInputField().isDisplayed())
        {
            tc1rup.getStateInputField().sendKeys(Data.STATE);
            System.out.println("State Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        // City
        if (tc1rup.getCityInputField().isDisplayed())
        {
            tc1rup.getCityInputField().sendKeys(Data.CITY);
            System.out.println("City Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);
        js.executeScript("window.scrollBy(0,300)");

        // Zipcode
        if (tc1rup.getZipCodeInputField().isDisplayed())
        {
            tc1rup.getZipCodeInputField().sendKeys(Data.ZIPCODE);
            System.out.println("Zipcode Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        // Mobile Number
        if (tc1rup.getMobileNumberInputField().isDisplayed())
        {
            tc1rup.getMobileNumberInputField().sendKeys(Data.MOBILE_NUMBER);
            System.out.println("Mobile Number Inputted Successfully");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //Scroll
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        long initialLength = (long) js1.executeScript("return document.body.scrollHeight");

        while (true) {
            js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            sleepTest(3000);

            long currentLength = (long) js1.executeScript("return document.body.scrollHeight");
            if (initialLength == currentLength) {
                break;
            }

            initialLength = currentLength;
            sleepTest(2000);
        }


        //TC - 13  Click 'Create Account button'

        if(tc1rup.getCreateAccountButton().isDisplayed()){
            String createAccountButtonText= tc1rup.getCreateAccountButton().getText();
            Assert.assertEquals(Data.CREATE_BUTTON_TEXT,createAccountButtonText);
            System.out.println( "✔" + createAccountButtonText + "✔" + Data.IS_VISIBLE);
            tc1rup.getCreateAccountButton().click();
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);


        //TC - 14 Verify that 'ACCOUNT CREATED!' is visible
        if (tc1rup.getAccountCreatedText().isDisplayed())
        {
            String accountCreatedText= tc1rup.getAccountCreatedText().getText();
            System.out.println(accountCreatedText + Data.POSITIVE_MASSAGE);
            Assert.assertEquals(Data.ACCOUNT_CREATED_TEXT,accountCreatedText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);

        //TC - 15 Click on Continue Button
        tc1rup.getContinueButton().click();


        //TC - 16 Verify that 'Logged in as username' is visible
        if (tc1rup.getLoggedInAsUsernameText().isDisplayed())
        {
            String loggedInAsUserText= tc1rup.getLoggedInAsUsernameText().getText();
            System.out.println(loggedInAsUserText + Data.POSITIVE_MASSAGE);
            Assert.assertEquals(Data.LOGGED_IN_AS_USER_TEXT,loggedInAsUserText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(2000);



    }

}

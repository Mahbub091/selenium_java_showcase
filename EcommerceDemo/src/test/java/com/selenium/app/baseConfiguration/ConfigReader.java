package com.selenium.app.baseConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    Properties properties;
    String baseDir = System.getProperty("user.dir");
    String path = baseDir + "/src/test/java/com/selenium/app/baseConfiguration/config.properties";
    public ConfigReader(){
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(path);
            try{
                properties.load(fis);
            }catch (Exception e) {
                e.printStackTrace();}
        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String testBrowser(){
        String executionBrowser = properties.getProperty("Browser");
        if (executionBrowser != null)
            return executionBrowser;
        else
            throw new RuntimeException("Test Execution Browser Not Specified In Config File");
    }

    public String getAppURL(){
        String AppUrl = properties.getProperty("appURL");
        if (AppUrl != null)
            return AppUrl;
            else
                throw new RuntimeException("App URL Not Specified In Config File");
    }
    public String registrationPageURL(){
        String registrationURL = properties.getProperty("ACCOUNT_REGISTER_PAGE");
        if (registrationURL != null)
            return registrationURL;
        else
            throw new RuntimeException("Registration URL Not Specified In Config File");
    }

    public String loginPageUrl(){
        String loginPageURL = properties.getProperty("LOGIN_PAGE");
        if (loginPageURL != null)
            return loginPageURL;
        else
            throw new RuntimeException("Login Page URL Not Specified In Config File");
    }

    public String accountPageURL(){
        String account_page_url = properties.getProperty("ACCOUNT_PAGE");
        if (account_page_url != null)
            return account_page_url;
        else
            throw new RuntimeException("Account Page URL Not Specified In Config File");
    }

    public String loginUser(){
        String loginUser = properties.getProperty("User_Name");
        if (loginUser != null)
            return loginUser;
        else
            throw new RuntimeException("Login User Not Specified In Config File");
    }

    public String loginEmail(){
        String loginEmail = properties.getProperty("User_Email");
        if (loginEmail != null)
            return loginEmail;
        else
            throw new RuntimeException("Login Email Not Specified In Config File");
    }

    public String loginPassword(){
        String loginPass = properties.getProperty("User_Password");
        if (loginPass != null)
            return loginPass;
        else
            throw new RuntimeException("Login Password Not Specified In Config File");
    }

}

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

}

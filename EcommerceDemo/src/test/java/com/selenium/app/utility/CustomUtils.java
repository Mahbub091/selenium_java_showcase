package com.selenium.app.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CustomUtils {
    WebDriver driver;
    Logger log = LogManager.getLogger("CustomUtils");

    public CustomUtils(WebDriver driver) {
        this.driver = driver;
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

    public void deleteTargetFolder()
    {
        try {
            Files.deleteIfExists(
                    Paths.get(System.getProperty("user.dir") + "\\target"));
        }
        catch (NoSuchFileException e) {
            System.out.println(
                    "No such file/directory exists");
        }
        catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        }
        catch (IOException e) {
            System.out.println("Invalid permissions.");
        }

        System.out.println("Deletion successful.");
    }

    public void validatingMultipleMenus(){
        List<String> expectedElementText = new ArrayList<String>();
        expectedElementText.add("Edit your account information");
        expectedElementText.add("Change your password");
        expectedElementText.add("Modify your address book entries");
        expectedElementText.add("Modify your wish list");
        expectedElementText.add("Subscribe / unsubscribe to newsletter");
        try {
        List<WebElement> elementList = driver.findElements(By.xpath("/html//div[@id='content']/div[1]/div[@class='card-body text-center']/div[@class='row']/div"));
        List<String> strlist  = WebelementToString(elementList);
        Assert.assertEquals(strlist, expectedElementText);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static List<String> WebelementToString(List<WebElement> elementList){
        List<String> stringList = new ArrayList<String>();
        for (WebElement element : elementList ) {
            stringList.add(element.getText().toString().trim());
        }
        return stringList;
    }




}




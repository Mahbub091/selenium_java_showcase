package com.selenium.app.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class CustomUtils {
    private WebDriver driver;
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




}
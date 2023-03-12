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

    /**
     * This Function Will convert our webelements to strings
     */
    private static List<String> WebelementToString(List<WebElement> elementList){
        List<String> stringList = new ArrayList<String>();
        for (WebElement element : elementList ) {
            stringList.add(element.getText().toString().trim());
        }
        return stringList;
    }

    /**
     * This Function Will store our Webelements and then click our desired MenuItem
     * @param element2List
     * @param menuItem
     */
    private void clickElementMatchingTextMethod(List <WebElement> element2List, String menuItem) {
        try {
            element2List.stream().parallel()
                    .filter(e->e.getText().equalsIgnoreCase(menuItem))
                    .findFirst() // if element finds several element then it'll fetch the first element
                    .ifPresent(WebElement::click);
        } catch (Exception e) {
            e.printStackTrace();
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

    /**
     * This Function Will Multiple Menus at Once By Using Array List & WebElements
     */
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

    public void validatingTopCategoriesMenu(){
        List<String> topCategoriesElementText = new ArrayList<String>();
        topCategoriesElementText.add("Components");
        topCategoriesElementText.add("Cameras");
        topCategoriesElementText.add("Phone, Tablets & Ipod");
        topCategoriesElementText.add("Software");
        topCategoriesElementText.add("MP3 Players");
        topCategoriesElementText.add("Laptops & Notebooks");
        topCategoriesElementText.add("Desktops and Monitors");
        topCategoriesElementText.add("Printers & Scanners");
        topCategoriesElementText.add("Mice and Trackballs");
        topCategoriesElementText.add("Fashion and Accessories");
        topCategoriesElementText.add("Beauty and Saloon");
        topCategoriesElementText.add("Autoparts and Accessories");
        topCategoriesElementText.add("Washing machine");
        topCategoriesElementText.add("Gaming consoles");
        topCategoriesElementText.add("Air conditioner");
        topCategoriesElementText.add("Web Cameras");
        try {
            List<WebElement> elementList = driver.findElements(By.cssSelector("[id='widget-navbar-217841'] .nav-item .title"));
            List<String> strlist  = WebelementToString(elementList);
            System.out.println(strlist);
            Assert.assertEquals(strlist, topCategoriesElementText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This Function Will store our Webelements and then click our desired MenuItem
     * @param menuText
     */
    public void clickingElementBySortingOutFromHeaderMenuList(String menuText) {
        log.info("Click on [{}] from Header-Menu", menuText);
        List<WebElement> elementList = driver.findElements(By.cssSelector("div#widget-navbar-217834 > .horizontal.navbar-nav > li > .both.icon-left.nav-link > .info > .title"));
        clickElementMatchingTextMethod(elementList, menuText);
    }
    /**
     * This Function will Validate the User Menu after the user has logged in
     */
    public void checkingUserMenuItem() {
        List<String> userMenuList = new ArrayList<String>();
        userMenuList.add("My Account");
        userMenuList.add("Edit Account");
        userMenuList.add("Password");
        userMenuList.add("Address Book");
        userMenuList.add("Wish List");
        userMenuList.add("Notification");
        userMenuList.add("Order History");
        userMenuList.add("Downloads");
        userMenuList.add("Recurring payments");
        userMenuList.add("Reward Points");
        userMenuList.add("Returns");
        userMenuList.add("Transactions");
        userMenuList.add("Newsletter");
        userMenuList.add("Logout");
        try {
            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class=\"list-group mb-3\"]/a"));
            List<String> strlist  = WebelementToString(elementList);
            System.out.println(strlist);
            Assert.assertEquals(strlist, userMenuList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickingElementBySortingOutFromUserMenu(String menuText) {
        log.info("Click on [{}] from User Menu", menuText);
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class=\"list-group mb-3\"]/a"));
        clickElementMatchingTextMethod(elementList, menuText);
    }

}




package com.selenium.app.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverPoolManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            createChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            createFirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            createEdgeDriver();
        } else {
            System.out.println("Browser Should Be As Defined");
        }
        setUpFullScreen();
    }

    private void createEdgeDriver() {
        driver = new EdgeDriver();
    }

    private void createFirefoxDriver() {
        driver = new FirefoxDriver();
    }

    private void createChromeDriver() {
                        // TODO: Created this Patch for the issue of *403* with Chrome 111 Version. Needs To be deleted Once It's been resolved.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public void stopDriver() {
        driver.quit();
    }

    private void setUpFullScreen() {
        driver.manage().window().maximize();
    }
}

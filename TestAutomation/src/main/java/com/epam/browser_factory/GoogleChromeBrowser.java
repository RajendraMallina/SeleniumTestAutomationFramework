package com.epam.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * GoogleChromeBrowser class implements the BrowserFactory to load ChromeDriver.
 * @author Rajendra_Mallina
 *
 */
public class GoogleChromeBrowser implements BrowserFactory {

    /**
     * loadBrowserDriver() returns the ChromeDriver.
     * @return WebDriver
     */
    public WebDriver loadBrowserDriver() {

        System.setProperty("webdriver.chrome.driver", "resources\\\\chromedriver.exe");
        return new ChromeDriver();
    }

}

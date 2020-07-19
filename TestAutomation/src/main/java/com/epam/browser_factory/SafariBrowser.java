package com.epam.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
/**
 * SafariBrowser class implements the BrowserFactory to load SafariDriver.
 * @author Rajendra_Mallina
 *
 */
public class SafariBrowser implements BrowserFactory {

    /**
     * loadBrowserDriver() returns the ChromeDriver.
     * @return WebDriver
     */
    public WebDriver loadBrowserDriver() {

        System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
        return new SafariDriver();

    }

}

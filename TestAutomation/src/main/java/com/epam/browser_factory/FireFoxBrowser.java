package com.epam.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * FireFoxBrowser class implements the BrowserFactory to load FirefoxDriver.
 * @author Rajendra_Mallina
 *
 */
public class FireFoxBrowser implements BrowserFactory {

    /**
     * loadBrowserDriver() returns the ChromeDriver.
     * @return WebDriver
     */
    public WebDriver loadBrowserDriver() {

        System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
        return new FirefoxDriver();
    }

}

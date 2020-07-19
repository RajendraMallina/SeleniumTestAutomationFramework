package com.epam.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * InternetExplorerBrowser class implements the BrowserFactory to load InternetExplorerDriver.
 * @author Rajendra_Mallina
 *
 */
public class InternetExplorerBrowser implements BrowserFactory {

    /**
     * rloadBrowserDriver() returns the ChromeDriver.
     * @return WebDriver
     */
    public WebDriver loadBrowserDriver() {

        System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

}

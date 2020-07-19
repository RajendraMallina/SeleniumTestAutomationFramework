package com.epam.browser_factory;

import org.openqa.selenium.WebDriver;
/**
 * The BrowserFactory is an Interface to load the all browser drivers.
 * Each individual Browser class implements the loadBrowserDriver() method.
 * @author Rajendra_Mallina
 *
 */
public interface BrowserFactory {

    /**
     * method used to return the web browser driver.
     * @return WebDriver
     */
    public WebDriver loadBrowserDriver();
}

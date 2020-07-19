package com.epam.browser_factory;

import org.openqa.selenium.WebDriver;


/**
 *
 * @author Rajendra_Mallina
 *
 */
public class MainBrowserFactory {

    private WebDriver driver;
    /**
     * The sectBrowser method select the web browser and initialize the driver with selected browser.
     * Then returns the web driver.
     *
     * @param browserName - The name of the required browser.
     * @return driver  - returns the browser initiated web driver.
     */
    public WebDriver selectBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("google chrome")) {

            BrowserFactory browser = new GoogleChromeBrowser();
            driver = browser.loadBrowserDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox")) {

            BrowserFactory browser = new FireFoxBrowser();
            driver = browser.loadBrowserDriver();

        }
        else if (browserName.equalsIgnoreCase("InternetExplorer") || browserName.equalsIgnoreCase("IE")) {

            BrowserFactory browser = new InternetExplorerBrowser();
            driver = browser.loadBrowserDriver();

        }
        else if (browserName.equalsIgnoreCase("safari")) {

            BrowserFactory browser = new SafariBrowser();
            driver = browser.loadBrowserDriver();

        }
        driver.manage().window().maximize();
        return driver;
    }
}

package com.epam.pageObjectModelWithPageFactoryPattren;
import org.testng.annotations.BeforeSuite;
/**
 *
 * @author Rajendra_Mallina
 * 
 *
 */
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.browser_factory.MainBrowserFactory;
import com.epam.configFileReader.ConfigFileReader;
import com.epam.pageObjectModelWithPageFactoryPattren.AmezonCartPage;
import com.epam.pageObjectModelWithPageFactoryPattren.AmezonHomePage;
import com.epam.pageObjectModelWithPageFactoryPattren.AmezonLogInPage;

public class TestNGAmazonTester {

	String userName;
	String password;
	String url;
	String browser;
	
    private WebDriver driver;
    AmezonLogInPage logIn;
    AmezonHomePage home;
    AmezonCartPage cart;

    @BeforeSuite
    public void setUP() {
    	
    	ConfigFileReader reader = new ConfigFileReader();
    	userName = reader.getUserName();
    	password = reader.getPassword();
    	url = reader.getUrl();
    	browser = reader.getBrowser();
    	
    	driver = new MainBrowserFactory().selectBrowser(browser);
        logIn = PageFactory.initElements(driver, AmezonLogInPage.class);
        home = PageFactory.initElements(driver, AmezonHomePage.class);
        cart = PageFactory.initElements(driver, AmezonCartPage.class);
    }
   
    @Test ( priority = 1 )
    public void amazonLogInTest(){
        driver.get(url);
        logIn.logInToAmezon(userName, password);
        
    }

    @Test ( priority = 2 )
    public void searchItemInHomePageTest() {

        home.searchItems("samsung mobiles");
    }

    @Test ( priority = 3 )
    public void selectRandomItemsFromSearchList() {

        int i=0;
        while(i < 3) {
            home.pickRandomItems();
            if (!home.addToCart()) {
                i--;
            }
            i++;
        }
    }
    
    @Test ( dependsOnMethods = {"selectRandomItemsFromSearchList"} )
    public void navigateToTheCartPage() {

        home.navigateToCartPage();
    }

    @Test ( dependsOnMethods = {"navigateToTheCartPage"} )
    public void proccedToPayment() {

        cart.placeOrder();
    }
}

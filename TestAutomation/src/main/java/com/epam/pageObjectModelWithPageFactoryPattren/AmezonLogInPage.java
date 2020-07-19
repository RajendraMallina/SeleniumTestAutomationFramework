package com.epam.pageObjectModelWithPageFactoryPattren;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * The AmezonLOgInPage class is used to log in the user into site by the
 * user's user name and password.
 *
 * @author Rajendra_Mallina
 *
 */
public class AmezonLogInPage {

    WebDriver driver;
    /**
     * Constructor to initialize the driver.
     * @param driver
     */
    public AmezonLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="nav-link-accountList")
    WebElement navigateToLogIn;

    @FindBy(id="ap_email")
    WebElement userID;

    @FindBy(id="ap_password")
    WebElement passWord;

    @FindBy(id="continue")
    WebElement userIDContinue;

    @FindBy(id="signInSubmit")
    WebElement signInButton;


    /**
     * loginToAmezon() method used to login the user by the userName and password.
     * @param userName uyser's user name to login to site.
     * @param userPassword user's password.
     */
    public void logInToAmezon(String userName, String userPassword)
    {
        navigateToLogIn.click();
        userID.sendKeys(userName);
        userIDContinue.click();
        passWord.sendKeys(userPassword);
        signInButton.click();
    }
}
package com.epam.pageObjectModelWithPageFactoryPattren;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * The AmezonCartPage class responsible for all cart page actions in the amezon web site.
 * Cart page processed the user to the payment page.
 * @author Rajendra_Mallina
 *
 */
public class AmezonCartPage {

    @FindBy(xpath="//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
    WebElement placeOrder;

    @FindBy(linkText="Deliver to this pickup store")
    WebElement selectDeliveryAddress;

    @FindBy(className="a-button-text")
    WebElement proccedForPayment;

    
    /**
     * Constructor to initialize the driver.
     * @param driver
     */
    public AmezonCartPage(WebDriver driver) {
    }
    /**
     * The placeOrder() method place the order for the CartPage ( cart added ) items.
     */
    public void placeOrder()
    {

        placeOrder.click();
        selectDeliveryAddress.click();
        proccedForPayment.click();
    }
}

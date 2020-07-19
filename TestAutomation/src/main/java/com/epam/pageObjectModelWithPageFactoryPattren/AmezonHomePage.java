package com.epam.pageObjectModelWithPageFactoryPattren;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * The AmezonHomePage class handles the all function like searching the product,
 * load the selected product details, allow user to add to cart.
 *
 * @author Rajendra_Mallina
 *
 */
public class AmezonHomePage {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement searchIcon;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"nav-cart\"]")
    private WebElement navigateToCart;
    

    /**
     * Constructor used to initialize the driver.
     *
     * @param driver
     */
    public AmezonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The searchItems() method fills the search text in search box and clicks the
     * search button.
     *
     * @param searchKey
     *            the input to search items in web site.
     */
    public void searchItems(String searchKey) {

    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        searchBox.sendKeys(searchKey);
        searchIcon.click();
    }

    /**
     * The pickRandomItems() method selects the random items from the search result.
     *
     */
    public void pickRandomItems() {

        int randomResult = genarateRandomNumber(2, 10);
        By randomItem = By
                .xpath("//div[@data-index=" + randomResult + "]//h2//a");
        driver.findElement(randomItem).click();
    }

    /**
     *
     * @param low
     *            The minimum value for random number generation.
     * @param high
     *            The maximum number for random number generation.
     * @return random number between low and high.
     */
    private int genarateRandomNumber(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    /**
     * This method is responsible to add the items into the cart by clicking the add
     * to cart button.
     *
     * @return item added to cart or not.
     */
    public boolean addToCart() {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

        try {

            driver.switchTo().window(tabs2.get(tabs2.size() - 1));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            addToCart.click();
            driver.close();
            driver.switchTo().window(tabs2.get(0));
            return true;

        } catch (Exception e) {
            driver.close();
            
            driver.switchTo().window(tabs2.get(0));
            return false;
        }

    }

    /**
     * after adding selected items to cart navigates to the cart page to place
     * order.
     */
    public void navigateToCartPage() {
        driver.get(driver.getCurrentUrl());
        navigateToCart.click();
    }

}

package Aleksa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Aleksa.pages.BaseConstants.*;

public class CartPage {
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    WebDriver driver;
    public By checkoutButton = By.cssSelector("#checkout");

    public By allItemsInCart = By.cssSelector("div[class=cart_item]");

    public By cartBadge = By.cssSelector("span[class=shopping_cart_badge]");

    public Integer getCartBadgeInteger(){
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
    public Integer countItemsInCart(){
        List<WebElement> items = driver.findElements(this.allItemsInCart);
        return items.size();
    }

    public void click(By selector){
        WebElement element = new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }
}
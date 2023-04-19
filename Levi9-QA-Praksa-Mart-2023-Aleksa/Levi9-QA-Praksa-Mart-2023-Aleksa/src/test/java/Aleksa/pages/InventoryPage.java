package Aleksa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }


    WebDriver driver;
    public By hamburgerButton = By.id("react-burger-menu-btn");
    public By linkAbout = By.id("about_sidebar_link");
    public By linkInventory = By.cssSelector("#inventory_sidebar_link");
    public By linkLogout = By.cssSelector("#logout_sidebar_link");

    public By backpack = By.id("add-to-cart-sauce-labs-backpack");

    public By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");

    public By boltShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public By fleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");

    public By onesie = By.id("add-to-cart-sauce-labs-onesie");

    public By redShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public By inventoryItems = By.cssSelector("button[class=\"btn btn_primary btn_small btn_inventory\"]");

    public By filterOptionAZ = By.cssSelector("option[value=\"az\"]");

    public By filterOptionZA = By.cssSelector("option[value=\"za\"]");

    public By filterOptionLOHI = By.cssSelector("option[value=\"lohi\"]");

    public By filterOptionHILO = By.cssSelector("option[value=\"hilo\"]");

    public By cartButtonIcon = By.cssSelector("#shopping_cart_container > a");
    public By cartButtonNotification = By.cssSelector("#shopping_cart_container > a > span");

    public By allitemPricesInPageOrder =  By.cssSelector(".inventory_item_price");


    public void openSlider() {
        WebElement hamburgerButtonWait = new WebDriverWait(this.driver, 1).until(ExpectedConditions.elementToBeClickable(hamburgerButton));
        hamburgerButtonWait.click();
    }

    public void click(By selector){
        WebElement element = new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    public List<String> getAllProductAttrName() {
        List<WebElement> products = driver.findElements(this.inventoryItems);
        List<String> productPoints = new ArrayList<String>();
        for (WebElement product : products) {
            productPoints.add(product.getAttribute("name"));
        }
        return productPoints;
    }


    public void filterBy(By by){
        driver.findElement(by).click();
    }

    public void add(By by){
        driver.findElement(by).click();
    }

    public void remove(By by){
        By b = By.id(by.toString().replaceFirst("By.id: add-to-cart","remove"));
        driver.findElement(b).click();
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }

//    public void getListOfPricesFloat(By by){
//    List<WebElement> elements = driver.findElements(this.allitemPricesInPageOrder);
//        for(int i = 0; i < elements.size(); i++) {
//        Float.parseFloat(elements.get(i).getText().replace("$",""));
//
//        }
//    }


}


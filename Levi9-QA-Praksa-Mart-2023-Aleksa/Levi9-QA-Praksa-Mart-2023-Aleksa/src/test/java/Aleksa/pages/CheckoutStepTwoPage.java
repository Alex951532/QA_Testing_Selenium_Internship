package Aleksa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutStepTwoPage {
    public CheckoutStepTwoPage(WebDriver driver){
        this.driver = driver;
    }
    WebDriver driver;

    public By finishButton = By.cssSelector("#finish");

    public void click(By selector){
        WebElement element = new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }
}
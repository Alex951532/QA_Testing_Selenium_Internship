package Aleksa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Aleksa.pages.BaseConstants.*;

public class CheckoutStepOnePage {
    public CheckoutStepOnePage(WebDriver driver){
        this.driver = driver;
    }
    WebDriver driver;

    public By firstNameField = By.cssSelector("#first-name");
    public By lastNameField = By.cssSelector("#last-name");
    public By zipField = By.cssSelector("#postal-code");
    public By continueButton = By.cssSelector("#continue");

    public void click(By selector){
        WebElement element = new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    public void fillOutOrderDetailsPositive(){
        driver.findElement(this.firstNameField).sendKeys(NAME_EXAMPLE);
        driver.findElement(this.lastNameField).sendKeys(LAST_NAME_EXAMPLE);
        driver.findElement(this.zipField).sendKeys(ZIP_CODE_EXAMPLE);
    }

}

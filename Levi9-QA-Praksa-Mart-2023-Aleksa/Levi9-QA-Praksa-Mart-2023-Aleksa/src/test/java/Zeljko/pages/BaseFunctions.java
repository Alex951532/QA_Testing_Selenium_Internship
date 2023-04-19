package Zeljko.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunctions {
    public WebDriver setupChromeDriver(){
        return WebDriverManager.chromedriver().create();
    }

    public WebDriver setupDriver(String browser){
        switch (browser){
            case "chrome": {
                return WebDriverManager.chromedriver().create();
            }
            case "safari": {
                return WebDriverManager.safaridriver().create();
            }
            default: {
                return WebDriverManager.chromedriver().create();
            }
        }
    }

    public void click(By element, WebDriver driver){
        WebElement webElement = new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
    }

    public void fillInputField(WebElement element, String text){
        element.sendKeys(text);
    }

}

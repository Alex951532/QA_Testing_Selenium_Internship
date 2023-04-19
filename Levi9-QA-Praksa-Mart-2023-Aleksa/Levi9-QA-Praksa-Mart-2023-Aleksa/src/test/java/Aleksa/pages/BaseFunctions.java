package Aleksa.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunctions {

    public BaseFunctions(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;

    public WebDriver setupChromeDriver(){
        return WebDriverManager.chromedriver().create();
    }

    public WebDriver setupDriver(String browser){
        switch (browser){
            case "chrome": {
                return WebDriverManager.chromedriver().create();
            }
            case "firefox": {
                return WebDriverManager.firefoxdriver().create();
            }
            default: {
                return WebDriverManager.edgedriver().create();
            }
        }
    }

    public void click(By element){
        WebElement webElement = new WebDriverWait(this.driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
    }
}

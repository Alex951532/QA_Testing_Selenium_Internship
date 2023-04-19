package Zeljko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;
    public By usernameField = By.id("user-name");
    public By passwordField = By.cssSelector("input#password");
    public By loginButton = By.cssSelector("input[name=login-button]");

    public void logInWithCredentials(String username, String password){
        driver.findElement(this.usernameField).sendKeys(username);
        driver.findElement(this.passwordField).sendKeys(password);
        driver.findElement(this.loginButton).click();
    }

    public WebElement getUsernameField(){
        return driver.findElement(this.usernameField);
    }
}

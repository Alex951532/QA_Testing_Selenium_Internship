package Aleksa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;
    public By usernameField = By.id("user-name");
    public By passwordField = By.id("password");
    public By loginInput = By.id("login-button");

    public void logInClickWithCredentials(String username, String password){
        driver.findElement(this.usernameField).sendKeys(username);
        driver.findElement(this.passwordField).sendKeys(password);
        driver.findElement(this.loginInput).click();
    }
    public void logInEnterWithCredentials(String username, String password){
        driver.findElement(this.usernameField).sendKeys(username);
        driver.findElement(this.passwordField).sendKeys(password);
        driver.findElement(this.loginInput).sendKeys(Keys.ENTER);
    }
    public String getErrorMessage(){
        WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String message = errorMessage.getText();
        return message;

    }
}

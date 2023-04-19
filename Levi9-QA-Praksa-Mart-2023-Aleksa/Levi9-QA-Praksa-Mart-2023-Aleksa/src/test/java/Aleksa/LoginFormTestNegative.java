package Aleksa;

import Aleksa.pages.BaseFunctions;
import Aleksa.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Aleksa.pages.BaseConstants.*;


public class LoginFormTestNegative {

    WebDriver driver;
    LoginPage loginPage;
    BaseFunctions base;
    @BeforeClass(alwaysRun = true)
    public void driverSetup(){
        base = new BaseFunctions(driver);
        driver = base.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        System.out.println("Driver setup complete");
    }
    @BeforeMethod(alwaysRun = true)
    public void testStartup(){
        driver.get(WEBSITE_URL);
        driver.manage().window().maximize();
        System.out.println("Test case started");
    }
    @AfterClass(alwaysRun = true)
    public void driverTeardown(){
        driver.quit();
        System.out.println("Driver teardown complete");
    }

    @Test(groups = {"all", "smoke"})
    public void loginNegativePasswordTest() {
        loginPage.logInClickWithCredentials("standard_user", "secret_sauce2");
        Assert.assertEquals(ERROR_MESSAGE_MATCH,loginPage.getErrorMessage());
    }
    @Test(groups = {"all", "smoke"})
    public void loginNullCredentialsTest()  {
        loginPage.logInClickWithCredentials("", "");
        Assert.assertEquals(ERROR_MESSAGE_REQUIRED_USERNAME,loginPage.getErrorMessage());

    }
    @Test(groups = {"all", "smoke"})
    public void loginNullPasswordTest()  {
        loginPage.logInClickWithCredentials("standard_user", "");
        Assert.assertEquals(ERROR_MESSAGE_REQUIRED_PASSWORD,loginPage.getErrorMessage());
    }
    @Test(groups = {"all", "smoke"})
    public void loginNonExistentUserTest()  {
        loginPage.logInClickWithCredentials("standard_user2", "");
        Assert.assertEquals(ERROR_MESSAGE_REQUIRED_PASSWORD,loginPage.getErrorMessage());
    }
    @Test(groups = {"all", "smoke"})
    public void loginNullUserTest()  {
        loginPage.logInClickWithCredentials("", "secret_sauce");
        Assert.assertEquals(ERROR_MESSAGE_REQUIRED_USERNAME,loginPage.getErrorMessage());
    }
}

package Aleksa;

import Aleksa.pages.BaseFunctions;
import Aleksa.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import static Aleksa.pages.BaseConstants.*;


public class LoginFormTestPositive {

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
    public void loginStandardUserTest(){
        loginPage.logInClickWithCredentials("standard_user", "secret_sauce");
        Assert.assertEquals(LOGGED_IN_URL,driver.getCurrentUrl());
    }

    @Test(groups = {"all", "regression"})
    public void loginStandardUserEnterTest(){
        loginPage.logInEnterWithCredentials("standard_user", "secret_sauce");
        Assert.assertEquals(LOGGED_IN_URL,driver.getCurrentUrl());
    }

    @Test(groups = {"all", "regression"})
    public void loginLockedUserTest(){
        loginPage.logInClickWithCredentials("locked_out_user", "secret_sauce");
        Assert.assertEquals(ERROR_MESSAGE_LOCKED,loginPage.getErrorMessage());
    }
    @Test(groups = {"all", "regression"})
    public void loginProblemUserTest(){
        loginPage.logInClickWithCredentials("problem_user", "secret_sauce");
        Assert.assertEquals(LOGGED_IN_URL,driver.getCurrentUrl());
    }

    @Test(groups = {"all", "regression"})
    public void loginBadPerformanceUserTest(){
        loginPage.logInClickWithCredentials("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(LOGGED_IN_URL,driver.getCurrentUrl());
    }
}
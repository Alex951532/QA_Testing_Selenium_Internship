package Zeljko.tests;

import Zeljko.pages.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import Zeljko.pages.LoginPage;
import static Zeljko.pages.BaseConstants.*;

public class initialTest {

    WebDriver driver;
    LoginPage loginPage;
    BaseFunctions base;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        //driver = base.setupChromeDriver();
        base = new BaseFunctions();
        driver = base.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        System.out.println("Driver setup complete");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        driver.get(BASE_URL);
        System.out.println("Test case started");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("Test case done");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
        System.out.println("Driver teardown complete");
    }

    @Test(groups = {"all", "smoke"})
    public void test1() throws InterruptedException{
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(groups = {"all", "regression"})
    public void elementTest() throws InterruptedException{
        WebElement usernameField = driver.findElement(loginPage.usernameField);
        WebElement passwordField = driver.findElement(loginPage.passwordField);
        WebElement loginButton = driver.findElement(loginPage.loginButton);

        //WebElement addToCartBackPackButton = new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[name=add-to-cart-sauce-labs-backpack]")));

        usernameField.sendKeys("performance_glitch_user");
        passwordField.sendKeys("secret_sauce");
        base.click(loginPage.loginButton, driver);

        //WebElement addToCartBackPackButton = new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[name=add-to-cart-sauce-labs-backpack]")));

        WebElement addToCartBackPackButton = driver.findElement(By.cssSelector("button[name=add-to-cart-sauce-labs-backpack]"));

        addToCartBackPackButton.click();

        Thread.sleep(2000);
    }

    @Test(groups = {"all", "regression"})
    public void assertTest(){
        String urlAfterLogin = HOMEPAGE_URL;
        String headerText = "Swag Labs";

        loginPage.logInWithCredentials(STANDARD_USERNAME, "secret_sauce");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, urlAfterLogin);

        WebElement headerTitle = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header_container div.app_logo")));

        Assert.assertEquals(headerTitle.getText(), headerText);
    }

    @Test(groups = {"all", "test1"})
    public void dropDownTest() throws InterruptedException{
        String urlAfterLogin = HOMEPAGE_URL;
        String headerText = "Swag Labs";

        WebElement usernameField = driver.findElement(loginPage.usernameField);
        WebElement passwordField = driver.findElement(loginPage.passwordField);
        WebElement loginButton = driver.findElement(loginPage.loginButton);

        usernameField.sendKeys(STANDARD_USERNAME);
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        WebElement sortDropdown = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=product_sort_container]")));
        WebElement optionPriceHighToLow = sortDropdown.findElement(By.cssSelector("option[value=hilo]"));
        optionPriceHighToLow.click();

        Thread.sleep(2000);
    }
}

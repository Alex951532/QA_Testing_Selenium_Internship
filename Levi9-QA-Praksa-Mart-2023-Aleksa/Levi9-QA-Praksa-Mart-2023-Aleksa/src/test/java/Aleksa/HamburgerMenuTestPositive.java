package Aleksa;

import Aleksa.pages.BaseFunctions;
import Aleksa.pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Aleksa.pages.LoginPage;

import static Aleksa.pages.BaseConstants.*;

public class HamburgerMenuTestPositive {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage burger;
    BaseFunctions base;
    @BeforeClass(alwaysRun = true)
    public void driverSetup(){
        base = new BaseFunctions(driver);
        driver = base.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        burger = new InventoryPage(driver);
        System.out.println("Driver setup complete");
    }
    @BeforeMethod(alwaysRun = true)
    public void testStartup(){
        driver.get(WEBSITE_URL);
        driver.manage().window().maximize();
        loginPage.logInClickWithCredentials("standard_user", "secret_sauce");
        burger.openSlider();
        System.out.println("Test case started");
    }
    @AfterClass(alwaysRun = true)
    public void driverTeardown(){
        driver.quit();
        System.out.println("Driver teardown complete");
    }

    @Test(groups = {"all", "regression"})
    public void clickAboutPage(){
        burger.click(burger.linkAbout);
        Assert.assertEquals(WEBSITE_SAUCE_URL,driver.getCurrentUrl());
    }
    @Test(groups = {"all", "regression"})
    public void clickInventoryPage(){
        burger.click(burger.linkInventory);
        Assert.assertEquals(LOGGED_IN_URL,driver.getCurrentUrl());
    }
    @Test(groups = {"all", "regression"})
    public void clickLogoutPage(){
        burger.click(burger.linkLogout);
        Assert.assertEquals(WEBSITE_URL,driver.getCurrentUrl());
    }
}

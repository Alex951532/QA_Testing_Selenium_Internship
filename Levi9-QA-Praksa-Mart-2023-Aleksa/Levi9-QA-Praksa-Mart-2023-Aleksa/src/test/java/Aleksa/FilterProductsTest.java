package Aleksa;

import Aleksa.pages.BaseFunctions;
import Aleksa.pages.InventoryPage;
import Aleksa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static Aleksa.pages.BaseConstants.WEBSITE_URL;

public class FilterProductsTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage filter;
    BaseFunctions base;
    @BeforeClass(alwaysRun = true)
    public void driverSetup(){
        base = new BaseFunctions(driver);
        driver = base.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        filter = new InventoryPage(driver);
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

    @Test(groups = {"all", "regression"})
    public void optionStandardUser() {
        loginPage.logInClickWithCredentials("standard_user", "secret_sauce");
        List expected = filter.getAllProductAttrName();
        filter.filterBy(filter.filterOptionHILO);
        Assert.assertNotEquals(expected,filter.getAllProductAttrName());
    }

    @Test(groups = {"all", "regression"})
    public void optionProblemUser() {
        loginPage.logInClickWithCredentials("problem_user", "secret_sauce");
        List expected = filter.getAllProductAttrName();
        filter.filterBy(filter.filterOptionHILO);
        Assert.assertNotEquals(expected,filter.getAllProductAttrName());
    }

    @Test(groups = {"all", "regression"})
    public void optionPerformanceUser() {
        loginPage.logInClickWithCredentials("performance_glitch_user", "secret_sauce");
        List expected = filter.getAllProductAttrName();
        filter.filterBy(filter.filterOptionHILO);
        Assert.assertNotEquals(expected,filter.getAllProductAttrName());
    }
//          Nepotreban test

//    @Test(groups = {"all", "regression"})
//    public void optionLockedUser() {
//        loginPage.logInClickWithCredentials("locked_out_user", "secret_sauce");
//        List expected = filter.getAllProductAttrName();
//        filter.FilterBy(filter.filterOptionHILO);
//        Assert.assertNotEquals(expected,filter.getAllProductAttrName());
//    }

//    @Test(groups = {"all", "smoke"})
//    public void optionFilterHiloTest() {
//        loginPage.logInClickWithCredentials("standard_user", "secret_sauce");
//
//    }





}

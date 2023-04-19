package Aleksa;

import Aleksa.pages.BaseFunctions;
import Aleksa.pages.InventoryPage;
import Aleksa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static Aleksa.pages.BaseConstants.WEBSITE_URL;

public class AddToCartTest {

    WebDriver driver;
    LoginPage loginPage;
    BaseFunctions base;
    InventoryPage cart;
    @BeforeClass(alwaysRun = true)
    public void driverSetup(){
        base = new BaseFunctions(driver);
        driver = base.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        cart = new InventoryPage(driver);
        System.out.println("Driver setup complete");
    }
    @BeforeMethod(alwaysRun = true)
    public void testStartup(){
        driver.get(WEBSITE_URL);
        driver.manage().window().maximize();
        loginPage.logInClickWithCredentials("standard_user", "secret_sauce");
        System.out.println("Test case started");
    }
    @AfterClass(alwaysRun = true)
    public void driverTeardown(){
        driver.quit();
        System.out.println("Driver teardown complete");
    }

    @Test(groups = {"all", "smoke"})
    public void addOrRemoveItemToCartButtonTest() {
        cart.add(cart.backpack);
        Assert.assertEquals(Integer.parseInt(cart.getText(cart.cartButtonNotification)), 1);
        cart.remove(cart.backpack);
        Assert.assertTrue(cart.backpack != null ? true : false);
    }

}


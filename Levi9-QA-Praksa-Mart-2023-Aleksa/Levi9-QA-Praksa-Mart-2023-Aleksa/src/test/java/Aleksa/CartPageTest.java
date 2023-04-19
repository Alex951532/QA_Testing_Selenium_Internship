package Aleksa;

import Aleksa.pages.BaseFunctions;
import Aleksa.pages.CartPage;
import Aleksa.pages.InventoryPage;
import Aleksa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Aleksa.pages.BaseConstants.*;
import static Aleksa.pages.BaseConstants.LOGGED_IN_URL;

public class CartPageTest {
        WebDriver driver;

        LoginPage loginPage;

        BaseFunctions base;

        CartPage cart;

        InventoryPage products;

        @BeforeClass(alwaysRun = true)
        public void driverSetup(){
            base = new BaseFunctions(driver);
            driver = base.setupDriver("chrome");
            loginPage = new LoginPage(driver);
            cart = new CartPage(driver);
            products = new InventoryPage(driver);
            System.out.println("Driver setup complete");
        }
        @BeforeMethod(alwaysRun = true)
        public void testStartup(){
            driver.get(WEBSITE_URL);
            driver.manage().window().maximize();
            System.out.println("Test case started");
            loginPage.logInClickWithCredentials("standard_user", "secret_sauce");
            products.add(products.backpack);
            products.add(products.bikeLight);
            products.add(products.boltShirt);
            products.click(products.cartButtonIcon);

        }
        @AfterClass(alwaysRun = true)
        public void driverTeardown(){
            driver.quit();
            System.out.println("Driver teardown complete");
        }

        @Test(groups = {"all", "regression"})
        public void verifyAmountOfItemsInCart(){
            Assert.assertEquals(cart.countItemsInCart(),cart.getCartBadgeInteger());
        }

}

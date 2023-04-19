package Aleksa;

import Aleksa.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static Aleksa.pages.BaseConstants.LOGGED_IN_URL;
import static Aleksa.pages.BaseConstants.WEBSITE_URL;

public class OrderFlowTest{
    WebDriver driver;
    LoginPage loginPage;
    BaseFunctions base;
    InventoryPage inventoryPage;
    CartPage cart;
    CheckoutStepOnePage checkoutStepOne;
    CheckoutStepTwoPage checkoutStepTwo;
    CheckoutCompletePage checkoutComplete;



    @BeforeClass(alwaysRun = true)
    public void driverSetup(){
        base = new BaseFunctions(driver);
        driver = base.setupDriver("chrome");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cart = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOnePage(driver);
        checkoutStepTwo = new CheckoutStepTwoPage(driver);
        checkoutComplete = new CheckoutCompletePage(driver);

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







    @Test(groups = {"all", "happy"})
    public void orderFlowTest() {
        inventoryPage.add(inventoryPage.backpack);
        inventoryPage.click(inventoryPage.cartButtonIcon);

        cart.click(cart.checkoutButton);

        checkoutStepOne.fillOutOrderDetailsPositive();
        checkoutStepOne.click(checkoutStepOne.continueButton);

        checkoutStepTwo.click(checkoutStepTwo.finishButton);

        checkoutComplete.click(checkoutComplete.backToHomeButton);

        String urlEnd = driver.getCurrentUrl();
        Assert.assertEquals(LOGGED_IN_URL,urlEnd);
    }


}


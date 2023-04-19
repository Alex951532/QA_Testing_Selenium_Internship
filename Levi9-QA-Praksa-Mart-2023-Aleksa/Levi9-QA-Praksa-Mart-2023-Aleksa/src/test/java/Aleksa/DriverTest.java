package Aleksa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class DriverTest {
    @Test
    public void driverChromeManagerTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

//
        chromeDriver.get("https://www.google.com");
        chromeDriver.manage().window().maximize();
//        System.out.println(chromeDriver.getCurrentUrl());
        Thread.sleep(2000);
        chromeDriver.quit();
    }

    @Test
    public void driverFirefoxShortTest() throws InterruptedException {
        WebDriver firefoxDriver = WebDriverManager.firefoxdriver().create();
        firefoxDriver.get("https://www.google.com");
        firefoxDriver.manage().window().maximize();
        Thread.sleep(2000);
        firefoxDriver.quit();
    }

    @Test
    public void driverEdgeShortTest() throws InterruptedException {
        WebDriver edgeDriver = WebDriverManager.edgedriver().create();
        edgeDriver.get("https://www.google.com");
        edgeDriver.manage().window().maximize();
        Thread.sleep(2000);
        edgeDriver.quit();
    }

    @Test
    public void driverIeTraditionalTest() throws InterruptedException {
        System.setProperty("webdriver.ie.driver","src/test/java/Aleksa/Drivers/IEDriverServer_x64_4.8.1/IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("ignoreProtectedModeSettings", true);

        InternetExplorerDriver IEDriver = new InternetExplorerDriver(options);
        Thread.sleep(2000);
//        IEDriver.get("https://www.google.com");  IE zakoci cim udje na bilo koji url
        IEDriver.manage().window().maximize();
        Thread.sleep(2000);
        IEDriver.quit();
;
    }

}
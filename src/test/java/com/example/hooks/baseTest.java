package com.example.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.Pf.HomePf;
import com.example.Pf.RegisterPf;
import com.example.pages.CartPage;
import com.example.pages.CheckoutPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class baseTest {
    public static WebDriver driver;
    public static HomePf hpf;
    public static RegisterPf rpf;
    public static LoginPage lp;
    public static ProductPage pp;
    public static CartPage cp;
    public static CheckoutPage chp;


    @BeforeEach
    public void setUp(){
        String nav = System.getProperty("browser", "chrome");

        try {

            URL gridUrl = new URL("http://selenium-hub-2:4444");

            switch (nav.toLowerCase()) {

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(gridUrl, chromeOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new RemoteWebDriver(gridUrl, edgeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new RemoteWebDriver(gridUrl, firefoxOptions);
                    break;

                default:
                    ChromeOptions defaultOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(gridUrl, defaultOptions);
                    break;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        hpf = new HomePf(driver);
        rpf = new RegisterPf(driver);
        lp = new LoginPage(driver);
        pp = new ProductPage(driver);
        cp = new CartPage(driver);
        chp = new CheckoutPage(driver);

        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
        driver = null;
    }

    
}

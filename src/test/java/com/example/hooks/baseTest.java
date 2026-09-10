package com.example.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.Pf.HomePf;
import com.example.Pf.RegisterPf;
import com.example.pages.CartPage;
import com.example.pages.CheckoutPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

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
        driver = new ChromeDriver();
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

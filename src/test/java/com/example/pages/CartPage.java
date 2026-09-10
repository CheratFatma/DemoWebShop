package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By agree = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkAgree(){
        driver.findElement(agree).click();
    }

    public void clickCheckout(){
        driver.findElement(checkoutBtn).click();
    }

   
    
}

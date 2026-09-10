package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    By addToCart = By.className("product-box-add-to-cart-button");
    By productName = By.className("product-name");
    By email = By.id("giftcard_2_RecipientEmail");

    By name = By.id("giftcard_2_RecipientName");
    By addToCart2 = By.id("add-to-cart-button-2");    
    By msg_content = By.cssSelector("#bar-notification p.content");
    By shopping_cart = By.cssSelector("a[href='/cart']");  

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void fillName(String n){
        driver.findElement(name).sendKeys(n);
    }

    public void fillEmail(String e){
        driver.findElement(email).sendKeys(e);
    }

    public void clickAddToCart2(){
        driver.findElement(addToCart2).click();
    }

    public String getContent(){
        return driver.findElement(msg_content).getText();
    }

    public void clickShoppingCart(){
        driver.findElement(shopping_cart).click();
    }


}

package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By email = By.id("Email");
    By password = By.id("Password");
    By rememberMe = By.id("Password");
    By loginBtn = By.className("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillEmail(String e){
        driver.findElement(email).sendKeys(e);
    }

    public void fillPassword(String p){
        driver.findElement(password).sendKeys(p);
    }

    public void checkRememberMe(){
        driver.findElement(rememberMe).click();
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    
}

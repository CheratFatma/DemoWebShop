package com.example.Pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePf {
    @FindBy(className="ico-register") private WebElement registerBtn;
    @FindBy(className="account") private WebElement accountMail;
    @FindBy(className="ico-logout") private WebElement logoutBtn;
    @FindBy(className="ico-login") private WebElement loginBtn;



    public HomePf(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickRegsiter(){
        registerBtn.click();
    }

    public String getAccountMail(){
        return accountMail.getText();
    }

    public void clickLogout(){
        logoutBtn.click();
    }

    
    public void clickLogin(){
        loginBtn.click();
    }
}

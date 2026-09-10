package com.example.Pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPf {
    @FindBy(id="gender-female") private WebElement gender;
    @FindBy(id="FirstName") private WebElement firstname;
    @FindBy(id="LastName") private WebElement lastname;
    @FindBy(id="Email") private WebElement email;
    @FindBy(id="Password") private WebElement password;
    @FindBy(id="ConfirmPassword") private WebElement confirm_password;
    @FindBy(id="register-button") private WebElement register_btn;
    @FindBy(className ="result") private WebElement success_msg;
    @FindBy(className = "register-continue-button") private WebElement continue_btn;
    

    public RegisterPf(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void checkGender(){
        gender.click();
    }

    public void fillFirstname(String f){
        firstname.sendKeys(f);
    }

    public void fillLastname(String l){
        lastname.sendKeys(l);
    }

    public void fillEmail(String e){
        email.sendKeys(e);
    }

    public void fillPassword(String p){
        password.sendKeys(p);
    }

    public void fillConfirmPassword(String p){
        confirm_password.sendKeys(p);
    }

    public void clickRegister(){
        register_btn.click();
    }

    public String getSuccessMsg(){
        return success_msg.getText();
    }

    public void clickContinue(){
        continue_btn.click();
    }



    

    
    
}

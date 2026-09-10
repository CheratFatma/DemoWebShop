package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.Pf.RegisterPf;
import com.example.hooks.baseTest;
import com.example.pages.LoginPage;
import com.example.pages.ProductPage;
import com.example.Pf.HomePf;
import com.github.javafaker.Faker;





public class DemoWebShopTest extends baseTest {
    Faker faker = new Faker();

    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    String company = faker.company().name();
    String city = faker.address().city();
    String adresse1 = faker.address().streetAddress();
    String adresse2 = faker.address().secondaryAddress();
    String codePostal = faker.address().zipCode();
    String phone = faker.phoneNumber().phoneNumber();
    String fax = faker.phoneNumber().phoneNumber();

    String country = "France";
    String state = "Other (Non US)";

    String cardholderName = faker.name().fullName();
    String cardNumber = "4111111111111111";
    String cardCode = "123";


    @Test 
    public void testRegister() {
        //cliquer sur register
        hpf.clickRegsiter();

        //verifier URL
        assertEquals("https://demowebshop.tricentis.com/register",driver.getCurrentUrl());

        //remplir Formulaire register et valider
        rpf.checkGender();
        rpf.fillFirstname(firstname);
        rpf.fillLastname(lastname);
        rpf.fillEmail(email);
        rpf.fillPassword(password);
        rpf.fillConfirmPassword(password);
        rpf.clickRegister();

        //verifier URL et message de succes
        assertEquals("https://demowebshop.tricentis.com/registerresult/1",driver.getCurrentUrl());
        assertEquals("Your registration completed",rpf.getSuccessMsg());

        //cliquer sur continuer
        rpf.clickContinue();

        //verifier URL et email
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());
        assertEquals(email, hpf.getAccountMail());

        //cliquer sur logout puis login 
        hpf.clickLogout();
        hpf.clickLogin();

        //verifier URL
        assertEquals("https://demowebshop.tricentis.com/login", driver.getCurrentUrl());

        //remplir Formulaire login et valider
        lp.fillEmail(email);
        lp.fillPassword(password);
        lp.checkRememberMe();
        lp.clickLoginBtn();

        //verifier URL
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        //ajouter un produit
        pp.clickAddToCart();

        //verifier nom du produit
        assertEquals("$25 Virtual Gift Card", pp.getProductName());

        //remplir Formulaire product et valider 
        pp.fillName(firstname);
        pp.fillEmail(email);
        pp.clickAddToCart2();

        //verifier message de succes
        assertEquals("The product has been added to your shopping cart",pp.getContent());

        //cliquer sur shopping cart
        pp.clickShoppingCart();

        //verifier URL
        assertEquals("https://demowebshop.tricentis.com/cart", driver.getCurrentUrl());

        //check agree et click checkout
        cp.checkAgree();
        cp.clickCheckout();
        assertEquals("https://demowebshop.tricentis.com/onepagecheckout", driver.getCurrentUrl());

        //Remplir Formulaire et cliquer continue
        chp.fillCompany(company);
        chp.selectCountry(country);
        chp.selectState(state);
        chp.fillCity(city);
        chp.fillAddresse1(adresse1);
        chp.fillAddresse2(adresse2);
        chp.fillCodePostal(codePostal);
        chp.fillPhone(phone);
        chp.fillfax(fax);
        chp.clickContinue();

        //choisir methode paiement et cliquer continuer
        chp.clickPaiementMethodVisa();
        chp.clickContinue2();

        //Remplir Formulaire et cliquer continue
        chp.fillCardholderName(cardholderName);
        chp.fillCardNumber(cardNumber);
        chp.fillCardCode(cardCode);
        chp.clickContinue3();

        //cliquer confirmer
        chp.clickConfirmbtn();

        //verifier URL et message succes
        assertEquals("https://demowebshop.tricentis.com/checkout/completed/", driver.getCurrentUrl());
        assertEquals("Your order has been successfully processed!",chp.getConfirmMsg());





    





        



        
    }
    
}

package com.gmail.mozhgru.annotationbased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  AbstractPage{

    @FindBy(id= "login-username")
    private WebElement txtUsername;

    @FindBy(id= "login-password")
    private WebElement txtPassword;

    @FindBy(id= "login-button")
    private WebElement bttnSubmit;

//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        driver.get("http://at.pflb.ru/matrixboard2/");
//    }

    {
        driver.get("http://at.pflb.ru/matrixboard2/");
    }

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void fillUsername(String login) {
        txtUsername.sendKeys(login);
    }

    public void fillPassword(String pass) {
        txtPassword.sendKeys(pass);
    }

    public void submit() {
        bttnSubmit.click();
    }


    public void clearLogin() {
        txtUsername.clear();
        txtPassword.clear();
    }

}

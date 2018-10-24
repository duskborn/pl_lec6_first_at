package com.gmail.mozhgru.annotationbased;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  AbstractPage{

    @FindBy(id = "login-username")
    private WebElement txtUsername;

    @FindBy(id = "login-password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement bttnSubmit;

    {
        driver.get("http://at.pflb.ru/matrixboard2/");
        wait.until(drv -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
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

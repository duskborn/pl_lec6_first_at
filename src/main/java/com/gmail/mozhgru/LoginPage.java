package com.gmail.mozhgru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameLocator = By.id("login-username");
    private By passwordLocator = By.cssSelector("#login-password");
    private By loginButtonLocator = By.xpath("//*[@id=\"login-button\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://at.pflb.ru/matrixboard2/");
    }

    public void fillUsername(String login) {
        driver.findElement(usernameLocator).sendKeys(login);
        ;
    }

    public void fillPassword(String pass) {
        driver.findElement(passwordLocator).sendKeys(pass);
    }

    public void submit() {
        driver.findElement(loginButtonLocator).click();
    }


    public void clearLogin() {
        driver.findElement(usernameLocator).clear();
        driver.findElement(passwordLocator).clear();
    }

}

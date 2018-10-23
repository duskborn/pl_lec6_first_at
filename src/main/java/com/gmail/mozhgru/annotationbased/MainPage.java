package com.gmail.mozhgru.annotationbased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage  extends  AbstractPage{

    @FindBy(id= "login-failed")
    private WebElement loginFailed;

    @FindBy(css= "#profile span")
    private WebElement profileContainer;

    public MainPage (WebDriver driver){
        super(driver);
    }

    public String getCurrentUser(){
        wait.until(drv -> {return profileContainer.isDisplayed();});
        return profileContainer.getText();
    }

    public String getTextOfElement(){
        wait.until(drv -> {return loginFailed.isDisplayed();});
        return loginFailed.getText();}
}
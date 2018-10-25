package com.gmail.mozhgru.annotationbased;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MainPage  extends  AbstractPage{

    @FindBy(id = "login-failed")
    private WebElement loginFailed;

    @FindBy(css = "#profile span")
    private WebElement profileContainer;

    @FindBy(css = "#logout > span")
    private WebElement logOut;

    @FindBy(css = "#add-person > span.ui-button-text")
    private WebElement addPersonButton;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/button/span[2]")
    private WebElement doneButton;

    public MainPage (WebDriver driver){
        super(driver);
        wait.until(drv -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

    public String getCurrentUser(){
        wait.until(drv -> profileContainer.isDisplayed());
        return profileContainer.getText();
    }

    public String getTextOfElement(){
        wait.until(drv -> loginFailed.isDisplayed());
        return loginFailed.getText();
    }

    public void tryPressButton(WebElement button){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", button);
    }

    public void tryLogOut(){
        tryPressButton(logOut);
    }

    public void pressAddPersonButton(){
        tryPressButton(addPersonButton);
    }

    public void tryDone(){
        tryPressButton(doneButton);
        wait.until(drv -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }
}
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

    public void tryLogOut(){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(logOut).click().build().perform();
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView()", logOut);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", logOut);
//        logOut.click();
    }
}
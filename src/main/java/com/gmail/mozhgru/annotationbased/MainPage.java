package com.gmail.mozhgru.annotationbased;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
        wait.until(drv -> logOut.isEnabled());
        Actions actions = new Actions(driver);
        actions.moveToElement(logOut).click(logOut).build().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
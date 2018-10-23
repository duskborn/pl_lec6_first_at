package com.gmail.mozhgru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameLocator = By.id("login-username");
    private By passwordLocator = By.cssSelector("#login-password");
    private By loginButtonLocator = By.xpath("//*[@id=\"login-button\"]");
    private By loginFailedLocator = By.cssSelector("#login-failed");

    private void tryLogin(String login, String pass) {
        driver.findElement(usernameLocator).sendKeys(login);
        driver.findElement(passwordLocator).sendKeys(pass);
        driver.findElement(loginButtonLocator).click();
    }

    private void clearLogin() {
        driver.findElement(usernameLocator).clear();
        driver.findElement(passwordLocator).clear();
    }

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mozhg\\jars\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://at.pflb.ru/matrixboard2/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test (priority=1)
    public void notValidLoginTest(){
        tryLogin("wrong_login", "wrong_password");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFailedLocator));
        WebElement loginFailed = driver.findElement(loginFailedLocator);
        Assert.assertEquals(loginFailed.getText(), "Неправильный логин или пароль.");

        clearLogin();
    }

    @Test (priority=2)
    public void validLoginTest(){
        tryLogin("user", "user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#profile span")));
        WebElement userNameContainer = driver.findElement(By.cssSelector("#profile span"));
        Assert.assertEquals(userNameContainer.getText(), "user");
    }

}
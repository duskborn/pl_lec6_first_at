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

    public void loginTry(String login, String pass) {
        driver.findElement(By.id("login-username")).sendKeys(login);
        driver.findElement(By.cssSelector("#login-password")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    public void clearLogin() {
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.cssSelector("#login-password")).clear();
    }

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mozhg\\jars\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test (priority=1)
    public void launchMatrixBoard() {
        driver.get("http://at.pflb.ru/matrixboard2/");
    }

    @Test (priority=2)
    public void notValidLoginTest(){
        loginTry("wrong_login", "wrong_password");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-failed")));
        WebElement loginFailed = driver.findElement(By.cssSelector("#login-failed"));
        Assert.assertEquals(loginFailed.getText(), "Неправильный логин или пароль.");

        clearLogin();
    }

    @Test (priority=3)
    public void validLoginTest(){
        loginTry("user", "user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#profile span")));
        WebElement userNameContainer = driver.findElement(By.cssSelector("#profile span"));
        Assert.assertEquals(userNameContainer.getText(), "user");
    }

}
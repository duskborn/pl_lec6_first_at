package com.gmail.mozhgru.day7;

import com.gmail.mozhgru.annotationbased.LoginPage;
import com.gmail.mozhgru.annotationbased.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MatrixBoardTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mozhg\\jars\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority=1)
    public void notValidLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername("wrong_login");
        loginPage.fillPassword("wrong_pass");
        loginPage.submit();
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getTextOfElement(), "Неправильный логин или пароль.");
        loginPage.clearLogin();
    }

    @Test (priority=2)
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername("user");
        loginPage.fillPassword("user");
        loginPage.submit();
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getCurrentUser(), "user");
    }
}

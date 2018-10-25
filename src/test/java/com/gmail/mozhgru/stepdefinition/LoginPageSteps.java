package com.gmail.mozhgru.stepdefinition;

import com.gmail.mozhgru.annotationbased.AbstractPage;
import com.gmail.mozhgru.annotationbased.LoginPage;
import com.gmail.mozhgru.annotationbased.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Также;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageSteps {
    private WebDriver driver = null;

    private LoginPage loginPage = null;
    private MainPage mainPage = null;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mozhg\\jars\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Пусть("^открыта страница входа в приложение '(.+)'$")
    public void openLoginPage(String url) {
        loginPage = new LoginPage(driver);
        loginPage.open(url);
    }

    @И("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void setTextToInput(String fieldName, String value) {
        switch (fieldName) {
            case "имя пользователя":
                loginPage.fillUsername(value);
                break;

            case "пароль":
                loginPage.fillPassword(value);
                break;

            default:
                throw new IllegalArgumentException("Invalid field name:" + fieldName);
        }

    }

    @И("^нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String btnName) {
        if (!btnName.equals("отправить")) {
            throw new IllegalArgumentException("Invalid button name:" + btnName);
        }
        loginPage.submit();
    }

    @Тогда("^открылась главная страница$")
    public void mainPageOpened() {
        mainPage = new MainPage(driver);
    }

    @Также("^на главной странице в правом верхнем углу видно имя пользователя \"([^\"]*)\"$")
    public void checkUserName(String text) {
        Assert.assertEquals(text, mainPage.getCurrentUser());
    }

    @Тогда("^появилось сообщение о неуспешном входе \"(.+)\"$")
    public void getErrorMessage(String error) {
        mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getTextOfElement(), error);
    }
}

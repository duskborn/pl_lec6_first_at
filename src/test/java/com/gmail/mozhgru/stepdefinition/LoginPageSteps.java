package com.gmail.mozhgru.stepdefinition;

import com.gmail.mozhgru.annotationbased.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageSteps {
    WebDriver driver = null;
    LoginPage loginPage = null;

    @Before
    public void setUp(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mozhg\\jars\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(WebDriver driver) {
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
}

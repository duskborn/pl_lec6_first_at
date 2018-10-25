package com.gmail.mozhgru.annotationbased;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AddPersonWidget extends  AbstractPage{

    @FindBy(id = "person-last-name")
    private WebElement personLastName;

    @FindBy(id = "person-first-name")
    private WebElement personFirstName;

    @FindBy(id = "person-patronymic-name")
    private WebElement personPatronymicName;

    @FindBy(id = "person-project")
    private WebElement personProject;

    @FindBy(id = "person-expire")
    private WebElement personExpire;

    @FindBy(id = "person-future")
    private WebElement personFuture;

    @FindBy(id = "person-nickname")
    private WebElement personNickname;

    @FindBy(xpath = "//a[contains(@href, \"profile.jsp?person=\")]")
    private List<WebElement> personUrl;

    public AddPersonWidget (WebDriver driver){
        super(driver);
    }

    public void fillPersonLastName(String lastName) {
        personLastName.sendKeys(lastName);
    }

    public void fillPersonFirstName(String firstName) {
        personFirstName.sendKeys(firstName);
    }

    public void fillPersonPatronymicName(String patronymicName) {
        personPatronymicName.sendKeys(patronymicName);
    }

    public void fillPersonProject(String project) {
        personProject.sendKeys(project);
    }

    public void fillPersonExpire(String expire) {
        personExpire.sendKeys(expire);
    }

    public void fillPersonFuture(String future) {
        personFuture.sendKeys(future);
    }

    public void fillPersonNickname(String nick) {
        personNickname.sendKeys(nick);
    }

    public Boolean checkUrlOfElement(String containedUrl) {

        Boolean returnedBool = new Boolean(false);
        String checkedString = new String("");
        for(WebElement e : personUrl){
            checkedString = e.getAttribute("href");
            if (checkedString.contains(containedUrl)) returnedBool = true;
        };
        return returnedBool;
    }
}

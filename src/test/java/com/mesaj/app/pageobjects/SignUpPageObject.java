package com.mesaj.app.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SignUpPageObject {

    @Autowired
    public SignUpPageObject(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath =" //input[@ng-model='FirstName']" )
    private WebElement firstNameTextBox;

    @FindBy(xpath ="//input[@ng-model='LastName']")
    private WebElement lastNameTextBox;
    @FindBy(tagName ="textarea")
    private WebElement addressTextBox;
    @FindBy(xpath ="//input[@type='email']")
    private WebElement emailTextBox;
    @FindBy(xpath ="//input[@type='tel']")
    private WebElement phoneTextBox;
    @FindBy(xpath ="//input[@value='Male']")
    private WebElement GenderMaleRadioButton;
    @FindBy(id ="countries")
    private WebElement countries;
    @FindBy(id ="yearbox")
    private WebElement year;
    @FindBy(xpath ="//select[@placeholder='Month']")
    private WebElement month;
    @FindBy(id ="daybox")
    private WebElement day;
    @FindBy(id ="firstpassword")
    private WebElement password;
    @FindBy(id ="secondpassword")
    private WebElement confirmPassword;
    @FindBy(id ="submitbtn")
    private WebElement submitbutton;

}

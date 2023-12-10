package com.sample.pageLayer;

import com.sample.baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class RegistrationForm extends BaseClass {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='givenName']")
    private WebElement firstN;

    @FindBy(xpath = "//input[@id='familyName']")
    private WebElement lastN;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='confirmationEmail']")
    private WebElement confirmEmail;

    @FindBy(xpath = "//input[@id='mobilePhoneNumber']")
    private WebElement mobNo;

    public RegistrationForm(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void firstName(String firstName) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(firstN));
        firstN.sendKeys(firstName);
    }

    public void lastName(String lastName) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(lastN));
        lastN.sendKeys(lastName);
    }

    public void setEmail(String emailID) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys(emailID);
    }

    public void confirmEmail(String confirmEmailID) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(confirmEmail));
        confirmEmail.sendKeys(confirmEmailID);
    }

    public void mobileNumber(String mobileNo) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(mobNo));
        mobNo.sendKeys(mobileNo);
    }
}

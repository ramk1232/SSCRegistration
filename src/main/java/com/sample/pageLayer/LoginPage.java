package com.sample.pageLayer;

import com.sample.baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='col-xs-12 loginhead hidden-xs']//img")
    private WebElement logo75Yr;

    public  LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean imgLogo75() {
        if(logo75Yr.isDisplayed()) {
            return logo75Yr.isDisplayed();
        }
        return true;
    }
}

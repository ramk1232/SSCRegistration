package com.sample.testLayer;

import com.sample.baseClass.BaseClass;
import com.sample.pageLayer.RegistrationForm;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utils.Utility;

import java.io.IOException;

public class TestScript extends BaseClass {
    RegistrationForm reg;
    int testID;


    public static void scrollDown() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js; js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");   //scroll down pixels
    }
    @Test(priority = 1)
    public void RegisterForm() throws IOException, InterruptedException {
        testID = 1090;
        reg = new RegistrationForm(driver);
        Thread.sleep(2000);
        scrollDown();
        reg.firstName(Utility.getTD(1,0));
        reg.lastName(Utility.getTD(1,1));
        scrollDown();
        reg.setEmail(Utility.getTD(1,2));
        Thread.sleep(5000);
    //    reg.confirmEmail(Utility.getTD(1,3));
        Thread.sleep(5000);
    try {
        reg.mobileNumber(Utility.getTDNumeric(1, 4));
        Thread.sleep(5000);
    }
    catch(NullPointerException e){
        System.out.println(e.getMessage());
    }

    }
}

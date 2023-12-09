package com.sample.testLayer;

import com.sample.baseClass.BaseClass;
import com.sample.pageLayer.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript extends BaseClass {
    LoginPage logIn;
    int testID;

    @Test(priority = 1)
    public void img75YrLogo() {
        testID = 1090;
        logIn = new LoginPage(driver);
        boolean flag = logIn.imgLogo75();
        Assert.assertTrue(flag);
    }
   // New
}

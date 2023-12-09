package com.sample.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Utility;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    int testID;

    @BeforeClass
    public void initializeBrowser() throws IOException {

        System.setProperty(Utility.getDataFromPropertyFile("chrome_key"),
                Utility.getDataFromPropertyFile("chrome_value"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Utility.getDataFromPropertyFile("url"));

    }

    @BeforeMethod
    public void beforeMethod()  {

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {

            Utility.captureScreenshot(driver, testID);

        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

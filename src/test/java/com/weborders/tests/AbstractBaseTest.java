package com.weborders.tests;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AbstractBaseTest {

    protected WebDriver driver = Driver.getDriver();

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest(){

    }

    @BeforeMethod
    public void setup(){
       driver.get(ConfigurationReader.getProperty("url"));
       driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult testResult){
        if (testResult.getStatus() == ITestResult.FAILURE){
           String screenshotLocation = BrowserUtilities.getScreenshot(testResult.getName());
        }

        Driver.closeDriver();
    }
}

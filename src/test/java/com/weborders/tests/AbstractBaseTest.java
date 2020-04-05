package com.weborders.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    public void beforeTest(){
        //generate reports
        extentReports = new ExtentReports();
        String reportPath = "";

        //choose based on Mac/Windows operating systems
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }

        //create HTML report
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("WebOrders Automation");

    }

    @AfterTest
    public void afterTest(){
        //release reports
        extentReports.flush();

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

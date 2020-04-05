package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*; //ensure this one as Static

public class SmokeTest extends AbstractBaseTest {

    @Test(dataProvider = "smokeTestData")
    public void verifyAllProductsPage(String component, String expectedPageSubTitle){
        extentTest = extentReports.createTest("Verify" + component);

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        loginPage.navigateTo(component);
        assertEquals(loginPage.getPageSubtitleText(),expectedPageSubTitle);

        extentTest.pass(component + " verified!");
    }


    @DataProvider
    public Object[][] smokeTestData(){
        return new Object[][]{
                {"View all orders",   "List of All Orders"},
                {"View all products", "List of Products"},
                {"Order","Order"}
        };
    }
}

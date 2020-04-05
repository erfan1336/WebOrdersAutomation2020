package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;    //make sure make this as Static

public class LoginTests extends AbstractBaseTest {

    @Test
    public void login(){

        extentTest = extentReports.createTest("Verify page logo");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        assertEquals(loginPage.getPageLogoText(),"Web Orders");

        extentTest.pass("Logo verified");

    }
}

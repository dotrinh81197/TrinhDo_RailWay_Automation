package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.ForgotPasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
         homePage.gotoRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
    }

    @Test(description = "Errors display when password reset token is blank")
    public void TC12() {
        String registerEmail = Utilities.generateRandomEmail();
        registerPage.registerAccount(registerEmail, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);
        homePage.gotoLoginPage();
        loginPage.gotoForgotPasswordPage();
        forgotPasswordPage.submitEmail(registerEmail);
        Assert.fail("[known-bug] Error page trigger when send instructions");
    }

    @Test(description = "Errors display if password and confirm password don't match when resetting password")
    public void TC13() {
        String registerEmail = Utilities.generateRandomEmail();
        registerPage.registerAccount(registerEmail, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);
        homePage.gotoLoginPage();
        loginPage.gotoForgotPasswordPage();
        forgotPasswordPage.submitEmail(registerEmail);
        Assert.fail("[known-bug] Error page trigger when send instructions");
    }
}

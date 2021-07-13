package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {
    LoginPage loginPage = new LoginPage();
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

    @Test(description = "User can create new account")
    public void TC07() {
        String registerEmail = Utilities.generateRandomEmail();
        registerPage.registerAccount(registerEmail, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);
        String registerSuccessMessage = registerPage.getRegisterSuccessMsg();
        String expectMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(registerSuccessMessage, expectMsg, "Register success message display not correct");

        registerPage.gotoLoginPage();
        loginPage.login(registerEmail, Constant.DATA_REGISTER_PASSWORD);
        loginPage.isTabLogOutDisplay();
        Assert.assertTrue(loginPage.isTabLogOutDisplay(), "User can login with this account");
    }

    @Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        String email = Utilities.generateRandomEmail();
        registerPage.registerAccount(email, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_INVALID_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);
        String registerErrorMessage = registerPage.getRegisterErrorMsg();
        String expectMsg = Constant.MSG_REGISTER_ERROR;
        Assert.assertEquals(registerErrorMessage, expectMsg, "Register error message display not correct");
    }

    @Test(description = "User can't create account while password and PID fields are empty")

    public void TC11() {
        String email = Utilities.generateRandomEmail();
        registerPage.registerAccount(email, Constant.DATA_EMPTY_PASSWORD, Constant.DATA_EMPTY_PASSWORD, Constant.DATA_EMPTY_PID);
        String registerErrorMessage = registerPage.getRegisterErrorMsg();
        String expectMsg = Constant.MSG_REGISTER_ERROR;
        Assert.assertEquals(registerErrorMessage, expectMsg, "Register error message display not correct");

        String errorPasswordMessage = registerPage.getRegisterErrorPassword();
        String expectMsgPassword = "Invalid password length";
        Assert.assertEquals(errorPasswordMessage, expectMsgPassword, "Password error message display not correct");

        String errorPidMessage = registerPage.getRegisterErrorPid();
        String expectMsgPid = "Invalid ID length";
        Assert.assertEquals(errorPidMessage, expectMsgPid, "Pid error message display not correct");
    }
}
package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
    }

    @Test(description = "TC01-User can log into Railway with valid username and password")
    public void TC01() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        String actualMsg = loginpage.getWelcomeMessage();
        String expectMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);
        Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected ");

    }

    @Test(description = "TC02-User can't login with blank \"Username\" textbox")
    public void TC02() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.DATA_BLANK_USERNAME, Constant.VALID_PASSWORD);
        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_BLANK_USER_PASSWORD;
        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);
        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_INVALID_USER_PASSWORD;
        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.multipleLogin(4);
        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        boolean checkTabMyTicketDisplay = loginpage.isTabMyTicketDisplay();
        Assert.assertTrue(checkTabMyTicketDisplay, "Tab My Ticket not display");
        boolean checkTabLogOutDisplay = loginpage.isTabLogOutDisplay();
        Assert.assertTrue(checkTabLogOutDisplay, "Tab Logout not display");

        homePage.gotoMyTicketPage();
        boolean isAtMyTicketPage = Utilities.isAtPage("My Ticket");
        Assert.assertTrue(isAtMyTicketPage, "Not directed to My ticket page");

        homePage.gotoChangePasswordPage();
        boolean isAtChangePasswordPage = Utilities.isAtPage("Change Password");
        Assert.assertTrue(isAtChangePasswordPage, "Not directed to Change Password page");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        //pre-condition
        RegisterPage registerPage = homePage.gotoRegisterPage();
        String registerEmail = Constant.DATA_REGISTER_EMAIL;
        registerPage.registerAccount(registerEmail, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);

        LoginPage loginpage = registerPage.gotoLoginPage();
        loginpage.login(registerEmail, Constant.DATA_REGISTER_PASSWORD);
        boolean isAtLoginPage = Utilities.isAtPage("Login");
        Assert.assertTrue(isAtLoginPage, "User can login with account has not been activated");

        boolean checkLoginErrorMessageExist = loginpage.isLoginErrorMessageExist();
        String expectedMsg = Constant.MSG_INVALID_USER_PASSWORD;
        Assert.assertEquals(loginpage.getLoginErrorMessage(), expectedMsg, "LoginErrorMessage display not correct");

    }


}

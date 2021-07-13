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
    LoginPage loginPage = new LoginPage();

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
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isWelcomeMsgDisplayed(), "Welcome message not display");
        String actualMsg = loginPage.getWelcomeMessage();
        String expectMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);
        Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected ");
    }

    @Test(description = "TC02-User can't login with blank \"Username\" text box")
    public void TC02() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.DATA_BLANK_USERNAME, Constant.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isLoginErrorMessageDisplay(), "Login error message not display");
        String loginErrorMessage = loginPage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_BLANK_USER_PASSWORD;
        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);
        String loginErrorMessage = loginPage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_INVALID_USER_PASSWORD;
        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.gotoBookTicketPage();
        boolean isAtLoginPage = Utilities.isAtPage("Login");
        Assert.assertTrue(isAtLoginPage, "Login Page is not displayed");
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        homePage.gotoLoginPage();
        loginPage.multipleLogin(Constant.TIMES_LOGIN);
        String loginErrorMessage = loginPage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isTabMyTicketDisplay(), "Tab My Ticket not display");
        Assert.assertTrue(loginPage.isTabLogOutDisplay(), "Tab Logout not display");
        Assert.assertTrue(loginPage.isTabChangePasswordDisplay(), "Tab ChangePassword not display");
        homePage.gotoMyTicketPage();
        Assert.assertTrue(Utilities.isAtPage("My Ticket"), "Not directed to My ticket page");
        homePage.gotoChangePasswordPage();
        Assert.assertTrue(Utilities.isAtPage("Change Password"), "Not directed to Change Password page");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        String registerEmail = Utilities.generateRandomEmail();
        registerPage.registerAccount(registerEmail, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);

        registerPage.gotoLoginPage();
        loginPage.login(registerEmail, Constant.DATA_REGISTER_PASSWORD);
        Assert.assertTrue(Utilities.isAtPage("Login"), "User can login with account has not been activated");
        String expectedMsg = Constant.MSG_INVALID_USER_PASSWORD;
        Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedMsg, "LoginErrorMessage display not correct");
    }

}
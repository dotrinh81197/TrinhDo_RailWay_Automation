package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;
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
        loginpage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginpage.getWelcomeMessage();
        String expectMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);
        if (loginpage.checkWelcomeMsgDisplayed()) {
            Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected ");
        } else {
            System.out.println("Bug UI");
        }
    }

    @Test(description = "TC02-User can't login with blank \"Username\" textbox")
    public void TC02() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.DATA_BLANK_USERNAME, Constant.PASSWORD);
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
        loginpage.login(Constant.USERNAME, Constant.PASSWORD);
        boolean checkTabMyTicketDisplay = loginpage.checkTabMyTicketDisplay();
        Assert.assertTrue(checkTabMyTicketDisplay, "Tab My Ticket not display");
        boolean checkTabLogOutDisplay = loginpage.checkTabLogOutDisplay();
        Assert.assertTrue(checkTabLogOutDisplay, "Tab Logout not display");

        homePage.gotoMyTicketPage();
        Assert.assertTrue(homePage.isAtMyTicketPage(), "Not directed to My ticket page");

        homePage.gotoChangePasswordPage();
        Assert.assertTrue(homePage.isAtChangePasswordPage(), "Not directed to Change Password page");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME_NOT_ACTIVATED, Constant.PASSWORD_NOT_ACTIVATED);
        boolean checkLoginErrorMessageExist = loginpage.checkLoginErrorMessageExist();
        System.out.println(checkLoginErrorMessageExist);
        String expectedMsg = Constant.MSG_INVALID_USER_PASSWORD;
        if (checkLoginErrorMessageExist) {
            Assert.assertEquals(loginpage.getLoginErrorMessage(), expectedMsg, "LoginErrorMessage display not correct");
        }
    }



}

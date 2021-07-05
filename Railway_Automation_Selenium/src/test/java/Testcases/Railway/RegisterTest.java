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


    @Test(description = "User can create new account")
    public void TC07() {

        RegisterPage registerPage = homePage.gotoRegisterPage();
        String registerEmail = Constant.DATA_REGISTER_EMAIL;
        registerPage.registerAccount(registerEmail, Constant.DATA_REGISTER_PASSWORD, Constant.DATA_REGISTER_CONFIRM_PASSWORD, Constant.DATA_REGISTER_PID);
        String registerSuccessMessage = registerPage.getRegisterSuccessMsg();
        String expectMsg=Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(registerSuccessMessage,expectMsg,"Register success message display not correct");

        LoginPage loginPage = registerPage.gotoLoginPage();
        loginPage.login(registerEmail,Constant.DATA_REGISTER_PASSWORD);
        loginPage.isTabLogOutDisplay();
        Assert.assertTrue(loginPage.isTabLogOutDisplay(),"User can login with this account");
    }

}

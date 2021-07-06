package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();

    }
    @Test(description = "User can create new account")
    public void TC07() {
        homePage.open();
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

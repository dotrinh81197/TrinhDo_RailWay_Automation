package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {


    @Test(description = "User can create new account")
    public void TC07() {
        homePage.open();
        String REGISTER_EMAIL = Utilities.generateRandomEmail();
        String REGISTER_PASSWORD = Constant.PASSWORD;
        String REGISTER_CONFIRM_PASSWORD = REGISTER_PASSWORD;
        String REGISTER_PID = Constant.PID;
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.registerAccount(REGISTER_EMAIL, REGISTER_PASSWORD, REGISTER_CONFIRM_PASSWORD, REGISTER_PID);
        String registerSuccessMessage = registerPage.getRegisterSuccessMsg();
        String expectMsg=Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(registerSuccessMessage,expectMsg,"Message display not correct");

        LoginPage loginPage = registerPage.gotoLoginPage();
        loginPage.login(REGISTER_EMAIL,REGISTER_PASSWORD);

        loginPage.checkTabLogOutDisplay();
        Assert.assertTrue(loginPage.checkTabLogOutDisplay(),"Login successfully");
    }

}

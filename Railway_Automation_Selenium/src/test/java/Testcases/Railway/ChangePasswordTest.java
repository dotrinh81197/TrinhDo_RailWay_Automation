package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {
    protected String currentPassword = Constant.PASSWORD;
    protected String newPassword = Constant.NEW_PASSWORD;
    protected String confirmPassword = newPassword;

    @Test(description = "User can change password")
    public void TC09() {
        homePage.open();
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.checkTabChangePasswordDisplay();
        //if-else o day
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.changePassword(currentPassword, newPassword, confirmPassword);

        String checkChangePasswordSuccessMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESSFULLY;
        Assert.assertEquals(checkChangePasswordSuccessMsg, expectMsg, "Change password success message display not correct");

    }
}

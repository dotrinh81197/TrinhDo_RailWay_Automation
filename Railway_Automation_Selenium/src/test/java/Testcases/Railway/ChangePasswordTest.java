package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {
    protected String currentPassword = Constant.VALID_PASSWORD;
    protected String newPassword = Constant.NEW_PASSWORD;
    protected String confirmPassword = newPassword;

    @Test(description = "User can change password")
    public void TC09() {
        homePage.open();
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        homePage.isTabChangePasswordDisplay();
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.changePassword(currentPassword, newPassword, confirmPassword);

        String checkChangePasswordSuccessMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESSFULLY;
        Assert.assertEquals(checkChangePasswordSuccessMsg, expectMsg, "Change password success message display not correct");
        homePage.logout();
    }
}

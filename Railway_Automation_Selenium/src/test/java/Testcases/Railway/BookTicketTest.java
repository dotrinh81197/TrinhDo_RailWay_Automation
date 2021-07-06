package Testcases.Railway;

import Common.Common.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest  extends TestBase{

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.open();
        homePage.gotoBookTicketPage();
        boolean isAtLoginPage =Utilities.isAtPage("Login");
        Assert.assertTrue(isAtLoginPage, "Login Page is not displayed");
        homePage.logout();
    }

}

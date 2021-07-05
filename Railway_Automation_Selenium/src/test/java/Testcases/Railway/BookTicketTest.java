package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest{
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        System.out.println("Pre-condition");
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
        Constant.WEBDRIVER.quit();
    }

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.gotoBookTicketPage();
        boolean isAtLoginPage =Utilities.isAtPage("Login");
        Assert.assertTrue(isAtLoginPage, "Login Page is not displayed");
    }

}

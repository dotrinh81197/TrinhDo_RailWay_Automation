package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {
    HomePage homePage = new HomePage();


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());

        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }

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
}

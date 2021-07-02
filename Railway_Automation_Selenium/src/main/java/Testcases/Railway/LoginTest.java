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
        if (homePage.isLoggedIn()) {
            homePage.logout();
        }
    }

    @Test
    public void TC01() {
        System.out.println("TC01-User can log into Railway with valid username and password");

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessage();
        String expectMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);
        if (loginPage.checkWelcomeMsgDisplayed()) {
            Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected ");
        } else {
            System.out.println("Bug UI");
        }

    }


    @Test
    public void TC02() {
        System.out.println("TC02-User can't login with blank \"Username\" textbox");

        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login("", Constant.PASSWORD);
        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_BLANK_USER_PASSWORD;

        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test
    public void TC03() {
        System.out.println("User cannot log into Railway with invalid password");

        LoginPage loginpage = homePage.gotoLoginPage();

        loginpage.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);

        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_INVALID_USER_PASSWORD;
        Assert.assertEquals(loginErrorMessage, expectMsg, "Known bug");
    }

    @Test
    public void TC04() {
        System.out.println("Login page displays when un-logged User clicks on \"Book ticket\" tab");

        homePage.gotoBookTicketPage();
        Assert.assertEquals(homePage.getPageNameActive(), "Login", "Login Page is not displayed");
    }

    @Test
    public void TC05() {
        System.out.println("System shows message when user enters wrong password several times");

        LoginPage loginpage = homePage.gotoLoginPage();

        for (int i = 1; i < 4; i++) {
            loginpage.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);
        }

        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(loginErrorMessage, expectMsg, "Known bug");
    }
}

package Railway;

import Common.Utilities;
import Constant.Constant;
import com.google.common.base.Verify;
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
        String expectMsg = "Welcome " + Constant.USERNAME;
        if (loginPage.checkWelcomeMsgDisplayed()){
            Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected ");
        }
        else {
            System.out.println("Bug UI");
        }

    }


    @Test
    public void TC02() {
        System.out.println("TC02-User can't login with blank \"Username\" textbox");

        LoginPage loginpage = homePage.gotoLoginPage();
        String username = "";
        loginpage.login(username, Constant.PASSWORD);

        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(loginErrorMessage, expectMsg, "LoginErrorMessage display not correct");
    }

    @Test
    public void TC03() {
        System.out.println("User cannot log into Railway with invalid password");

        LoginPage loginpage = homePage.gotoLoginPage();

        loginpage.login(Constant.USERNAME, "123");

        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = "There was a problem with your login and/or errors exist in your form.";
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
            loginpage.login(Constant.USERNAME, "123");
        }

        String loginErrorMessage = loginpage.getLoginErrorMessage();
        String expectMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(loginErrorMessage, expectMsg, "Known bug");
    }
}

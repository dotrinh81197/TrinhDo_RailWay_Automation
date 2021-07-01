package Railway;

import Common.Utilities;
import Constant.Constant;
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
        Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected");
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
}

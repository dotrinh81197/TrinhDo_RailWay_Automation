package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {

    @BeforeMethod
    public void beforeMethod(){
     System.out.println("Pre-condition");

     System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());


     Constant.WEBDRIVER= new ChromeDriver();
     Constant.WEBDRIVER.manage().window().maximize();

    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        System.out.println("TC01-User can log Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginpage = homePage.gotoLoginPage();

        String actualMsg = loginpage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectMsg = "Welcome "+ Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectMsg, "Welcome message is not displayed as expected");

        homePage.logout();

    }
    @Test
    public void TC02(){
        System.out.println("TC02-User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginpage = homePage.gotoLoginPage();
        String username ="";
        loginpage.login(username,Constant.PASSWORD);

        String loginErrorMessage= loginpage.getLoginErrorMessage();
        String expectMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(loginErrorMessage,expectMsg,"LoginErrorMessage display not correct" );


    }

}

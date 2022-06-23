package Testcases.PreTestSelenium2;

import Common.Common.Log;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObject.Google.HomePage;
import PageObject.Google.ResultPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.Constant.Constant.*;

public class Youtube_Page_Validation extends TestBase {
    @Test(description = "Google search page validation")
    public void TC1() {
        Log.info("Step1: Navigate to google website");
        Constant.WEBDRIVER.navigate().to(GOOGLE_URL);
        HomePage homePage = new HomePage();
        homePage.switchToEnglish();

        Log.info("Step2: Search for value");
        homePage.searchFor(SEARCH_STRING);

        Log.info("Step3: Click on first video");
        ResultPage resultPage = new ResultPage();
        Utilities.scrollIntoView(resultPage.getPeopleFirstQuestion());
        //wait for page loaded
        resultPage.getFirstVideo().click();
        Utilities.waitTime(2);

    }

}

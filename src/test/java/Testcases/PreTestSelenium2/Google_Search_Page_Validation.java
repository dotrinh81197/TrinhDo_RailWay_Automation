package Testcases.PreTestSelenium2;

import Common.Common.Log;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObject.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Google_Search_Page_Validation extends TestBase {
    @Test(description = "Google search page validation")
    public void TC1() {
        Log.info("Step1: Navigate to google website");
        Constant.WEBDRIVER.navigate().to(Constant.GOOGLE_URL);
        HomePage homePage = new HomePage();

        Log.info("Step2: Verify google search box display");
        Assert.assertTrue(Utilities.checkControlExit(homePage.getSearchBox()), "Search box display");

        //switch to English
        homePage.switchToEnglish();

        Log.info("Step3: Search for value");
        homePage.searchFor(Constant.SEARCH_STRING);

        Log.info("Step4: verify search string remained on the search box");
        Assert.assertEquals(homePage.getSearchBoxValue(), "the Beatles");

        // - verify main result

//verify search page video

//div[@data-async-context='query:the%20Beatles']
        //verify search page
        // - mail result
        // - people aslo ask
        // - videos
        // top stories

    }
}

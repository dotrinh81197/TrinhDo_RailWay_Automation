package Testcases.PreTestSelenium2;

import Common.Common.Log;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObject.Google.HomePage;
import PageObject.Google.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.Constant.Constant.GOOGLE_URL;
import static Common.Constant.Constant.SEARCH_STRING;


public class Google_Search_Page_Validation extends TestBase {
    @Test(description = "Google search page validation")
    public void TC1() {
        Log.info("Step1: Navigate to google website");
        Constant.WEBDRIVER.navigate().to(GOOGLE_URL);
        HomePage homePage = new HomePage();

        Log.info("Step2: Verify google search box display");
        Assert.assertTrue(Utilities.checkControlExit(homePage.getGoogleBigLogo()), "Google's logo display");
        Assert.assertTrue(Utilities.checkControlExit(homePage.getSearchBox()), "Search box display");

        //switch to English
        homePage.switchToEnglish();

        Log.info("Step3: Search for value");
        homePage.searchFor(SEARCH_STRING);

        ResultPage resultPage = new ResultPage();

        Log.info("Step4: verify search string remained on the search box");
        Assert.assertEquals(homePage.getSearchBoxValue(), SEARCH_STRING);

        Log.info("Step6: verify first result display");
        Utilities.isElementExist(resultPage.firstResult);

        Log.info("Step7: verify people also ask section");
        resultPage.checkPeopleAlsoAskSection(SEARCH_STRING);

        Log.info("Step8: verify video section contains search value");
        resultPage.checkVideoSection(SEARCH_STRING);

        Log.info("Step9: verify top stories section");
        resultPage.checkTopStoriesSection(SEARCH_STRING);

    }
}

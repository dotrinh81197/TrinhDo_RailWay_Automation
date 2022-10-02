package Testcases.PreTestSelenium2;

import com.relevantcodes.extentreports.LogStatus;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObject.Google.HomePage;
import PageObject.Google.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.Constant.Constant.GOOGLE_URL;
import static Common.Constant.Constant.SEARCH_STRING;


public class TC01_Google_Search_Page_Validation extends TestBase {
    @Test(description = "Google search page validation")
    public void TC1() {
        logger = extent.startTest("Verify that Google search page is displayed correctly");

        logger.log(LogStatus.PASS, "Step1: Navigate to google website");
        Constant.WEBDRIVER.navigate().to(GOOGLE_URL);
        HomePage homePage = new HomePage();

        logger.log(LogStatus.PASS, "Step2: Verify google search box display");
        Assert.assertTrue(Utilities.checkControlExit(homePage.getGoogleBigLogo()), "Google's logo display");
        Assert.assertTrue(Utilities.checkControlExit(homePage.getSearchBox()), "Search box display");

        //switch to English
        homePage.switchToEnglish();

        logger.log(LogStatus.PASS, "Step3: Search for value");
        homePage.searchFor(SEARCH_STRING);

        ResultPage resultPage = new ResultPage();

        logger.log(LogStatus.PASS, "Step4: verify search string remained on the search box");
        Assert.assertEquals(homePage.getSearchBoxValue(), SEARCH_STRING);

        logger.log(LogStatus.PASS, "Step5: verify first result display");
        Assert.assertTrue(resultPage.doesFirstResultDisplay(), "First Result is Display");

        logger.log(LogStatus.PASS, "Step6: verify people also ask section");
        resultPage.checkPeopleAlsoAskSection(SEARCH_STRING);

        logger.log(LogStatus.PASS, "Step7: verify video section contains search value");
        resultPage.checkVideoSection(SEARCH_STRING);

        logger.log(LogStatus.PASS, "Step8: verify top stories section");
        resultPage.checkTopStoriesSection(SEARCH_STRING);

    }
}

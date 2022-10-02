package Testcases.PreTestSelenium2;

import PageObject.Youtube.YoutubePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObject.Google.HomePage;
import PageObject.Google.ResultPage;

import org.testng.annotations.Test;

import static Common.Constant.Constant.*;

public class TC02_Youtube_Page_Validation extends TestBase {
    @Test(description = "Google search page validation")
    public void TC1() throws InterruptedException {
        logger = extent.startTest("Validate YouTube result from Google search");

        logger.log(LogStatus.PASS, "Step #1: Navigate to Google page");
        Constant.WEBDRIVER.navigate().to(GOOGLE_URL);

        logger.log(LogStatus.PASS, "Step #2: Switch to English Language");
        HomePage homePage = new HomePage();
        homePage.switchToEnglish();

        logger.log(LogStatus.PASS, "Step #3: Switch to English Language");
        homePage.searchFor(SEARCH_STRING);

        logger.log(LogStatus.PASS, "Step #4: Open 1st video result");
        ResultPage resultPage = new ResultPage();
        Utilities.scrollIntoView(resultPage.getFirstResult());
        String videoSearchResult = resultPage.getTitleVideo();
        resultPage.open1stVideo();
        Utilities.waitTime(2);

        logger.log(LogStatus.PASS, "Step #5: Play video for 10 seconds");
        YoutubePage youtubePage = new YoutubePage();
        youtubePage.playVideoFor(Constant.WAIT_TIME_10_SEC);

        logger.log(LogStatus.PASS, "Step #6: Verify the video is played for 10 seconds");
        Assert.assertTrue(youtubePage.doesVideoPlayFor(Constant.WAIT_TIME_10_SEC));

        logger.log(LogStatus.PASS, "Step #7: Verify the video title the same to Google result");
        Assert.assertEquals(youtubePage.getYoutubeVideoTitle(), videoSearchResult);


    }

}

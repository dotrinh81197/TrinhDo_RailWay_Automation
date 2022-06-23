package utils.listener;

import Common.Constant.Constant;
import Testcases.PreTestSelenium2.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.logs.Log;

import java.util.Objects;

public class ReportListener extends TestBase implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        logger.log(LogStatus.PASS, "<b>TESTCASE IS PASSED</b>");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is failed.");
        WebDriver driver = Constant.WEBDRIVER;
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        logger.log(LogStatus.INFO, "Screenshot bellow: " + logger.addBase64ScreenShot(base64Screenshot));
    }
}

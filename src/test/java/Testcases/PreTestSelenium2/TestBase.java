package Testcases.PreTestSelenium2;

import Common.Common.Utilities;
import Common.Constant.Constant;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class TestBase {
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void startReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/output/ExtentReport.html", true);
        extent
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Trinh Do");
        extent.loadConfig(new File(Common.Common.Utilities.getProjectPath() + "/extent-config.xml"));
    }

    @AfterTest
    public void endReport() {
        extent.flush();
        extent.close();
    }


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getWebDriverPath());
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
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "<b>" + result.getName() + " IS FAILED</b>");
            logger.log(LogStatus.FAIL, "<b>THE ERROR:</br>" + result.getThrowable() + "</b>");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "<b>" + result.getName() + "IS SKIPPED</b>");
        }
        extent.endTest(logger);
    }
}

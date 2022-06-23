package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utilities {

    public static String getWebDriverPath() {
        return "src/test/resources/WebDriver/chromedriver_v101.exe";
    }

    public static void scrollAndClickIntoView(WebElement element) {
        JavascriptExecutor je = Constant.WEBDRIVER;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public static WebElement findElement(By Locator) {
        WebElement element = null;
        try {
            element = Constant.WEBDRIVER.findElement(Locator);

        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    public static boolean isElementExist(By Locator) {
        try {
            Constant.WEBDRIVER.findElement(Locator);
            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    public static void clickElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            Log.error("Can't click element");
        }
    }

    public static boolean checkControlExit(WebElement element) {
        try {
            if (element.isDisplayed())
                return true;
            else return false;
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    public static void waitForControl(WebElement controlName, int waitTime) {
        try {
            new WebDriverWait(Constant.WEBDRIVER, waitTime).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception e) {

        }
    }

}

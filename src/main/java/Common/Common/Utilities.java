package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Common.Constant.Constant.WAIT_TIME_60_SEC;

public class Utilities {

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor je = Constant.WEBDRIVER;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
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
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkControlExit(WebElement element) {
        try {
            if (element.isDisplayed())
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitTime(int time) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void waitForControl(WebElement controlName){
        new WebDriverWait(Constant.WEBDRIVER,WAIT_TIME_60_SEC).until(ExpectedConditions.visibilityOf(controlName));
    }
}





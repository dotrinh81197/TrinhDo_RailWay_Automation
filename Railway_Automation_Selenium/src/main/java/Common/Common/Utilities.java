package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class Utilities {

    protected static final String alpha = "abcdefghijklmnopqrstvwxyzabcedfABCDEFGHJKLMNOPQRSTVWXYZ";
    protected static final String digits = "0123456789";

    public static String getProjectPath() {
        return "src/main/java/WebDriver/chromedriver.exe";
    }

    public static boolean isAtPage(String pageName) {
        if (pageName.equals("Home")) {
            String titleHomePage = "Selenium Automation";
            return Constant.WEBDRIVER.getTitle().contains(titleHomePage);
        }
        return Constant.WEBDRIVER.getTitle().contains(pageName);
    }

    public static String generateRandomEmail() {
        String emailRandom = "";

        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            int indexText = rnd.nextInt(alpha.length() - 1);
            emailRandom += Character.toString(alpha.charAt(indexText));
            int indexNumber = rnd.nextInt(digits.length() - 1);
            emailRandom += Character.toString(digits.charAt(indexNumber));
        }
        emailRandom = emailRandom + "@gmail.com";
        return emailRandom;
    }

    public static void scrollAndClickIntoView(WebElement element) {
        JavascriptExecutor je = Constant.WEBDRIVER;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public static String getTodayPlusDays(int daysNumber) {

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, daysNumber);
        date = c.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy");
        String strReturnDate = formatter.format(date);
        return strReturnDate;
    }

}

package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Random;

public class Utilities {

    protected static final String alpha ="abcdefghijklmnopqrstvwxyz";
    protected static final String digits ="0123456789";

    public static String getProjectPath() {
        return "src/main/java/WebDriver/chromedriver.exe";
    }

    public static String generateRandomEmail() {
        String emailRandom ="";

        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            int indexText = rnd.nextInt(alpha.length()-1);
            emailRandom += Character.toString(alpha.charAt(indexText));
            int indexNumber = rnd.nextInt(digits.length()-1);
            emailRandom += Character.toString(digits.charAt(indexNumber));
        }
        emailRandom = emailRandom +"@test.com";
        return emailRandom;
    }

    public static void pageDownEnd() {
        Constant.WEBDRIVER.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }
}

package Common.Constant;

import org.openqa.selenium.chrome.ChromeDriver;

public class Constant {

    public static ChromeDriver WEBDRIVER;
    public static final String RAIlWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "trinhdo@gmail.com";
    public static final String PASSWORD = "12345678";
    public static final String PID = "12345678";
    public static final String USERNAME_NOT_ACTIVATED = "trinhdo@gmail.com";
    public static final String PASSWORD_NOT_ACTIVATED = "12345678";
    public static final String NEW_PASSWORD = "12345678";

    public static String MSG_WELCOME_USER = "Welcome %s";
    public static final String MSG_BLANK_USER_PASSWORD = "There was a problem with your login and/or errors exist in your form.";
    public static final String MSG_INVALID_USER_PASSWORD = "Invalid username or password. Please try again.";
    public static final String MSG_RUN_OUT_OF_TRY_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String MSG_REGISTER_SUCCESSFULLY = "Thank you for registering your account";
    public static final String MSG_CHANGE_PASSWORD_SUCCESSFULLY = "Your password has been updated!";
    public static final String DATA_INVALID_PASSWORD = "123";
    public static final String DATA_BLANK_USERNAME = "";

}

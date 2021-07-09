package Common.Constant;

import Common.Common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;

public class Constant {

    public static ChromeDriver WEBDRIVER;
    public static final String RAIlWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "trinhdo@gmail.com";
    public static final String VALID_PASSWORD = "12345678";
    public static final String NEW_PASSWORD = "12345678";
    public static final Integer TIMES_LOGIN = 4;
    public static final Integer DAYS_NUMBER = 5;
    public static final String MAIN_EMAIL = "example+";


    public static String MSG_WELCOME_USER = "Welcome %s";
    public static final String MSG_BLANK_USER_PASSWORD = "There was a problem with your login and/or errors exist in your form.";
    public static final String MSG_INVALID_USER_PASSWORD = "Invalid username or password. Please try again.";
    public static final String MSG_RUN_OUT_OF_TRY_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String MSG_REGISTER_SUCCESSFULLY = "Thank you for registering your account";
    public static final String MSG_CHANGE_PASSWORD_SUCCESSFULLY = "Your password has been updated!";
    public static final String MSG_REGISTER_ERROR = "There're errors in the form. Please correct the errors and try again.";
    public static final String MSG_BOOK_TICKET_SUCCESSFULLY = "Ticket Booked Successfully!";

    public static final String DATA_INVALID_PASSWORD = "123";
    public static final String DATA_BLANK_USERNAME = "";
    public static final String DATA_REGISTER_PASSWORD = "12345678";
    public static final String DATA_EMPTY_PASSWORD = "";
    public static final String DATA_REGISTER_CONFIRM_PASSWORD = "12345678";
    public static final String DATA_REGISTER_INVALID_CONFIRM_PASSWORD = "12348";
    public static final String DATA_REGISTER_PID = "12345678";
    public static final String DATA_EMPTY_PID = "";
    public static final String DATA_BOOK_DEPART_FROM = "Sài Gòn";
    public static final String DATA_BOOK_ARRIVE_AT = "Nha Trang";
    public static final String DATA_CHECK_DEPART_FROM = "Huế";
    public static final String DATA_CHECK_ARRIVE_AT = "Sài Gòn";
    public static final String DATA_SEAT_TYPE = "Soft bed with air conditioner";
    public static final String DATA_TICKET_AMOUNT = "1";


}

package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
    }

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.gotoBookTicketPage();
        boolean isAtLoginPage = Utilities.isAtPage("Login");
        Assert.assertTrue(isAtLoginPage, "Login Page is not displayed");

    }

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        LoginPage loginpage = homePage.gotoLoginPage();
        loginpage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertTrue(Utilities.isAtPage("Home"), "Login not successfully");
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        String departDate = Utilities.getTodayPlusDays(5);
        String departFrom = Constant.DATA_BOOK_DEPART_FROM;
        String arriveAt = Constant.DATA_BOOK_ARRIVE_AT;
        String seatType = Constant.DATA_SEAT_TYPE;
        String ticketAmount = Constant.DATA_TICKET_AMOUNT;

        bookTicketPage.submitBookTicketInfo(departDate, departFrom, arriveAt, seatType, ticketAmount);
        Assert.assertEquals(bookTicketPage.getMessageBookTicketSuccess(), Constant.MSG_BOOK_TICKET_SUCCESSFULLY, "Message Book ticket successfully not display correct");

        Assert.assertEquals(bookTicketPage.getDepartDate(), departDate, "Depart date information display not correct");
        Assert.assertEquals(bookTicketPage.getDepartStation(), departFrom, "Depart from information display not correct");
        Assert.assertEquals(bookTicketPage.getArriveStation(), arriveAt, "Arrive from information display not correct");
        Assert.assertEquals(bookTicketPage.getSeatType(), seatType, "Seat type information display not correct");
        Assert.assertEquals(bookTicketPage.getAmount(), ticketAmount, "Ticket amount information display not correct");
    }

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        homePage.gotoTimetablePage();
        TimetablePage timetablePage = new TimetablePage();
        String departFrom =Constant.DATA_CHECK_DEPART_FROM;
        String arriveAt = Constant.DATA_CHECK_ARRIVE_AT;
        timetablePage.gotoBookTicketOfRoute(departFrom, arriveAt);

        Assert.assertTrue(Utilities.isAtPage("Book Ticket"), "Book ticket page not display");
        BookTicketPage bookTicketPage = new BookTicketPage();
        Assert.assertEquals(bookTicketPage.getSelectedOptionDepartFrom(), departFrom, "Depart Station not the same in Timetable");
        Assert.assertEquals(bookTicketPage.getSelectedOptionArriveAt(), arriveAt, "Arrive Station not the same in Timetable");
    }
}

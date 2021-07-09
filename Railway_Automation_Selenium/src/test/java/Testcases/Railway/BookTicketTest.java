package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertTrue(Utilities.isAtPage("Home"), "Login not successfully");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
    }


    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {

        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        String departDate = Utilities.getTodayPlusDays(Constant.DAYS_NUMBER);
        String departFrom = Constant.DATA_BOOK_DEPART_FROM;
        String arriveAt = Constant.DATA_BOOK_ARRIVE_AT;
        String seatType = Constant.DATA_SEAT_TYPE;
        String ticketAmount = Constant.DATA_TICKET_AMOUNT;

        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        bookTicketPage.submitBookTicketInfo(ticket);

        Assert.assertEquals(bookTicketPage.getMessageBookTicketSuccess(), Constant.MSG_BOOK_TICKET_SUCCESSFULLY, "Message Book ticket successfully not display correct");

        Assert.assertEquals(bookTicketPage.getDepartDate(), ticket.getTicketDepartDate(), "Depart date information display not correct");
        Assert.assertEquals(bookTicketPage.getDepartStation(), ticket.getTicketDepartFrom(), "Depart from information display not correct");
        Assert.assertEquals(bookTicketPage.getArriveStation(), ticket.getTicketArriveAt(), "Arrive from information display not correct");
        Assert.assertEquals(bookTicketPage.getSeatType(), ticket.getTicketSeatType(), "Seat type information display not correct");
        Assert.assertEquals(bookTicketPage.getAmount(), ticket.getTicketTicketAmount(), "Ticket amount information display not correct");
    }

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {

        homePage.gotoTimetablePage();
        TimetablePage timetablePage = new TimetablePage();
        String departFrom = Constant.DATA_CHECK_DEPART_FROM;
        String arriveAt = Constant.DATA_CHECK_ARRIVE_AT;
        timetablePage.gotoBookTicketOfRoute(departFrom, arriveAt);

        Assert.assertTrue(Utilities.isAtPage("Book Ticket"), "Book ticket page not display");
        BookTicketPage bookTicketPage = new BookTicketPage();
        Assert.assertEquals(bookTicketPage.getSelectedOptionDepartFrom(), departFrom, "Depart Station not the same in Timetable");
        Assert.assertEquals(bookTicketPage.getSelectedOptionArriveAt(), arriveAt, "Arrive Station not the same in Timetable");
    }

    @Test(description = "User can cancel a ticket")
    public void TC16() {

        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        String departDate = Utilities.getTodayPlusDays(Constant.DAYS_NUMBER);
        String departFrom = Constant.DATA_BOOK_DEPART_FROM;
        String arriveAt = Constant.DATA_BOOK_ARRIVE_AT;
        String seatType = Constant.DATA_SEAT_TYPE;
        String ticketAmount = Constant.DATA_TICKET_AMOUNT;

        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        bookTicketPage.submitBookTicketInfo(ticket);

        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.cancelTicket(ticket);
        Assert.assertTrue(myTicketPage.isTicketDisappear(ticket), "Ticket still display");
    }

}

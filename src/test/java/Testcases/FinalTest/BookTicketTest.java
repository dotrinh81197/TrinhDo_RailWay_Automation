package Testcases.FinalTest;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import PageObjects.Railway.Ticket;
import Testcases.Railway.TestBase;
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
//        homePage.logout();
    }

    @Test(description = "User can book 1 ticket at a time")
    public void FTTC701() {
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        //fill information of ticket
        String departDate = Utilities.getTodayPlusDays(Constant.DAYS_NUMBER);
        String departFrom = "Nha Trang";// Nha trang chỉ only đi được Sài Gòn
        String arriveAt = "Huế";
        String seatType = "Soft seat";
        String ticketAmount = "2";
        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        bookTicketPage.submitBookTicketInfo(ticket);

        Assert.assertEquals(bookTicketPage.getMessageBookTicketSuccess(), Constant.MSG_BOOK_TICKET_SUCCESSFULLY, "Message Book ticket successfully not display correct");

        Assert.assertEquals(bookTicketPage.getDepartDate(), ticket.getTicketDepartDate(), "Depart date information display not correct");
        Assert.assertEquals(bookTicketPage.getDepartStation(), ticket.getTicketDepartFrom(), "Depart from information display not correct");
        Assert.assertEquals(bookTicketPage.getArriveStation(), ticket.getTicketArriveAt(), "Arrive from information display not correct");
        Assert.assertEquals(bookTicketPage.getSeatType(), ticket.getTicketSeatType(), "Seat type information display not correct");
        Assert.assertEquals(bookTicketPage.getAmount(), ticket.getTicketTicketAmount(), "Ticket amount information display not correct");

    }

    @Test(description = "User can filter \"Manage ticket\" with both Arrive station and Depart date ")
    public void FTTC702() {
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        String departDate = Utilities.getTodayPlusDays(Constant.DAYS_NUMBER);
        Ticket ticket = new Ticket(departDate, Constant.DATA_BOOK_DEPART_FROM, Constant.DATA_BOOK_ARRIVE_AT, Constant.DATA_SEAT_TYPE, Constant.DATA_TICKET_AMOUNT);
        bookTicketPage.bookTicketsSeveralTime(6, ticket);
        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.filterBy()

    }

}

package Testcases.FinalTest;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertTrue(Utilities.isAtPage("Home"), "Login not successfully");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.cancelAllTicket();
        homePage.logout();
    }

    @Test(description = "User can book 1 ticket at a time")
    public void FNTC01() {
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        Ticket ticket = new Ticket(Utilities.getTodayPlusDays(Constant.DAYS_NUMBER), Constant.DATA_DEPART_FROM, Constant.DATA_ARRIVE_AT, Constant.DATA_SEAT_TYPE_HB, Constant.TICKET_AMOUNT);
        bookTicketPage.submitBookTicketInfo(ticket);
        //checkpoint after book ticket
        Assert.assertEquals(bookTicketPage.getMessageBookTicketSuccess(), Constant.MSG_BOOK_TICKET_SUCCESSFULLY, "Message Book ticket successfully not display correct");
        Assert.assertEquals(bookTicketPage.getDepartDate(), ticket.getTicketDepartDate(), "Depart date information display not correct");
        Assert.assertEquals(bookTicketPage.getDepartStation(), ticket.getTicketDepartFrom(), "Depart from information display not correct");
        Assert.assertEquals(bookTicketPage.getArriveStation(), ticket.getTicketArriveAt(), "Arrive from information display not correct");
        Assert.assertEquals(bookTicketPage.getSeatType(), ticket.getTicketSeatType(), "Seat type information display not correct");
        Assert.assertEquals(bookTicketPage.getAmount(), ticket.getTicketTicketAmount(), "Ticket amount information display not correct");

    }


    @Test(description = "User can filter \"Manage ticket\" with Depart date ")
    public void FNTC02() {
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        String departDate = Utilities.getTodayPlusDays(Constant.DAYS_NUMBER);
        Ticket ticket = new Ticket(departDate, Constant.DATA_BOOK_DEPART_FROM, Constant.DATA_BOOK_ARRIVE_AT, Constant.DATA_SEAT_TYPE_SBC, Constant.DATA_TICKET_AMOUNT);
        bookTicketPage.bookTicketsSeveralTimes(6, ticket);
        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.filterBy(null, null, departDate, null);
        Assert.assertTrue(myTicketPage.checkTicketDisplayWithFilter(departDate), "\"Manage ticket\" table shows not correct");
    }

    @Test(description = "User can book ticket after checking price")
    public void FNTC03() {
        homePage.gotoTicketPricePage();
        TicketPricePage ticketPricePage = new TicketPricePage();
        ticketPricePage.bookTicketFromTicketPricePage(Constant.DATA_CHECK_PRICE_DEPART_FROM, Constant.DATA_CHECK_PRICE_ARRIVE_AT, Constant.DATA_SEAT_TYPE_SB);
        //Checkpoint at Book ticket page
        BookTicketPage bookTicketPage = new BookTicketPage();
        Assert.assertEquals(bookTicketPage.getSelectedOptionDepartFrom(), Constant.DATA_CHECK_PRICE_DEPART_FROM, "Value of depart station is not correct");
        Assert.assertEquals(bookTicketPage.getSelectedOptionArriveAt(), Constant.DATA_CHECK_PRICE_ARRIVE_AT, "Value of arrive station is not correct");
        Assert.assertEquals(bookTicketPage.getSelectedOptionSeatType(), Constant.DATA_SEAT_TYPE_SB, "Value of seatType is not correct");
    }
}

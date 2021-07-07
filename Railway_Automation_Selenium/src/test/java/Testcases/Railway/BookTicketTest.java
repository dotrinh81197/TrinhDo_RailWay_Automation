package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
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
        String departDate = "7/10/2021";
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        String ticketAmount = "1";

        bookTicketPage.submitBookTicketInfo(departDate, departFrom, arriveAt, seatType, ticketAmount);
        String expectMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(bookTicketPage.getMessageBookTicketSuccess(),expectMsg,"Message Book ticket successfully not display correct");

        Assert.assertEquals(bookTicketPage.getDepartDate(),departDate,"Depart date information display not correct");
        Assert.assertEquals(bookTicketPage.getDepartStation(),departFrom,"Depart from information display not correct");
        Assert.assertEquals(bookTicketPage.getArriveStation(),arriveAt,"Arrive from information display not correct");
        Assert.assertEquals(bookTicketPage.getSeatType(),seatType,"Seat type information display not correct");
        Assert.assertEquals(bookTicketPage.getAmount(),ticketAmount,"Ticket amount information display not correct");
    }

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15(){
        
    }

}

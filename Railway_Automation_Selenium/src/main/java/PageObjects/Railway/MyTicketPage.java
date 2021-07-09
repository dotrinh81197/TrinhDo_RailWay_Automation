package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class MyTicketPage {
    //locators

    //elements
//    public WebElement getBtnCancelTicketOfRoute(String departStation, String arriveStation) {
//        String xpath1 = "//table/tbody/tr/td[text()='";
//        String xpath2 = "']/following::td[text()='";
//        String xpath3 = "']/following::td[8]/input[@value='Cancel']";
//        String resultXpath = xpath1 + departStation + xpath2 + arriveStation + xpath3;
//        By btnCancelTicketOfRoute = By.xpath(resultXpath);
//        return Constant.WEBDRIVER.findElement(btnCancelTicketOfRoute);
//    }

    protected WebElement getRowTicket(Ticket ticket){
        String xpath1 = "//table/tbody/tr/td[text()='";
        String xpath2 = "']/following::td[text()='";
        String xpath3 = "']/..";
        String resultXpath = xpath1 + ticket.getTicketDepartFrom() + xpath2 + ticket.getTicketArriveAt() + xpath3;
        By rowTicketOfRout = By.xpath(resultXpath);
        return Constant.WEBDRIVER.findElement(rowTicketOfRout);

    }

    //methods
//    public void cancelTicket(String departStation, String arriveStation) {
//        Utilities.scrollAndClickIntoView(this.getBtnCancelTicketOfRoute(departStation, arriveStation));
//        Constant.WEBDRIVER.switchTo().alert().accept();
//    }

    public boolean isTicketDisappear(Ticket ticket){
        boolean isElementDisappear= false;
        try {
            if (this.getRowTicket(ticket) != null) {
                WebElement RowTicket = this.getRowTicket(ticket);
                isElementDisappear = RowTicket.isDisplayed();
            }

        } catch (NoSuchElementException e) {
            isElementDisappear = true;
        }
        return isElementDisappear;
    }

    public void cancelTicket(Ticket ticket) {
        Utilities.scrollAndClickIntoView(this.getBtnCancelTicketOfRoute(ticket));
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    private WebElement getBtnCancelTicketOfRoute(Ticket ticket) {
        String xpath1 = "//table/tbody/tr/td[text()='";
        String xpath2 = "']/following::td[text()='";
        String xpath3 = "']/following::td[8]/input[@value='Cancel']";
        String resultXpath = xpath1 + ticket.getTicketDepartFrom() + xpath2 + ticket.getTicketArriveAt() + xpath3;
        By btnCancelTicketOfRoute = By.xpath(resultXpath);
        return Constant.WEBDRIVER.findElement(btnCancelTicketOfRoute);
    }
}

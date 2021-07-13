package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class MyTicketPage {
    //locators

    protected WebElement getRowTicket(Ticket ticket){
        String xpath1 = "//table[@class='MyTable']/tbody/tr/td[text()='";
        String xpath2 = "']/following::td[text()='";
        String xpath3 = "']/..";
        String resultXpath = xpath1 + ticket.getTicketDepartFrom() + xpath2 + ticket.getTicketArriveAt() + xpath3;
        By rowTicketOfRout = By.xpath(resultXpath);
        return Utilities.findElement(rowTicketOfRout);

    }

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
        String xpath1 = "//table[@class='MyTable']/tbody/tr/td[text()='";
        String xpath2 = "']/following::td[text()='";
        String xpath3 = "']/following::td/input[@value='Cancel']";
        String resultXpath = xpath1 + ticket.getTicketDepartFrom() + xpath2 + ticket.getTicketArriveAt() + xpath3;
        By btnCancelTicketOfRoute = By.xpath(resultXpath);
        return Utilities.findElement(btnCancelTicketOfRoute);
    }
}

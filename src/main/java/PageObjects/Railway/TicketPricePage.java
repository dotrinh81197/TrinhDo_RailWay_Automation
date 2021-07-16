package PageObjects.Railway;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //locators

    //elements
    protected WebElement getBtnCheckPrice(String departFrom, String arrivedAt) {
        String xpath1 = "//tr//td//li[text()='";
        String xpath2 = "']//ancestor::tr//td//a[text()='Check Price']";
        String locator = xpath1 + departFrom + "\sto\s" + arrivedAt + xpath2;
        By resultLocator = By.xpath(locator);
        return Utilities.findElement(resultLocator);
    }

    protected WebElement getBtnBookTicket(String seatType) {
        String xpath1 = "//tr//td//text()[contains(.,'";
        String xpath2 = "')]//ancestor::td//..//td//a[text()='Book ticket']";
        String locator = xpath1 + seatType + xpath2;
        By resultLocator = By.xpath(locator);
        return Utilities.findElement(resultLocator);
    }

    //methods

    public void checkPrice(String departForm, String arriveAt) {
        Utilities.scrollAndClickIntoView(getBtnCheckPrice(departForm, arriveAt));
    }

    public void bookTicketFromTicketPricePage(String departForm, String arriveAt,String seatType) {
        this.checkPrice(departForm, arriveAt);
        Utilities.scrollAndClickIntoView(getBtnBookTicket(seatType));
    }
}

package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class MyTicketPage {
    //locators

    //elements
    public WebElement getBtnCancelTicketOfRoute(String departStation, String arriveStation) {
        String xpath1 = "//table/tbody/tr/td[text()='";
        String xpath2 = "']/following::td[text()='";
        String xpath3 = "']/following::td[8]/input[@value='Cancel']";
        String resultXpath = xpath1 + departStation + xpath2 + arriveStation + xpath3;
        By btnCancelTicketOfRoute = By.xpath(resultXpath);
        return Constant.WEBDRIVER.findElement(btnCancelTicketOfRoute);
    }

    protected WebElement getRowTicket(String departStation, String arriveStation){
        String xpath1 = "//table/tbody/tr/td[text()='";
        String xpath2 = "']/following::td[text()='";
        String xpath3 = "']/..";
        String resultXpath = xpath1 + departStation + xpath2 + arriveStation + xpath3;
        By rowTicketOfRout = By.xpath(resultXpath);
        return Constant.WEBDRIVER.findElement(rowTicketOfRout);

    }

    //methods
    public void cancelTicket(String departStation, String arriveStation) {
        Utilities.scrollAndClickIntoView(this.getBtnCancelTicketOfRoute(departStation, arriveStation));
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isTicketDisappear(String departStation, String arriveStation){
        boolean isElementDisappear= false;
        try {
            if (this.getRowTicket(departStation, arriveStation) != null) {
                WebElement ticket = this.getRowTicket(departStation, arriveStation);
                isElementDisappear = ticket.isDisplayed();
            }

        } catch (NoSuchElementException e) {
            isElementDisappear = true;
        }
        return isElementDisappear;
    }
}

package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    //locators

    //elements
    private WebElement getLinkBookTicketOfRoute(String departFrom, String ArriveAt) {
        String xpath1 = "//table/tbody/tr/td[contains(.,'";
        String xpath2 = "')]/following-sibling::td[contains(.,'";
        String xpath3 = "')]/../td[contains(.,'book ticket')]/a";
        String resultXpath = xpath1 + departFrom + xpath2 + ArriveAt + xpath3;
        By linkBookTicketOfRoute = By.xpath(resultXpath);
        return Constant.WEBDRIVER.findElement(linkBookTicketOfRoute);
    }

    //methods

    public void gotoBookTicketOfRoute(String departFrom, String arriveAt) {
       Utilities.scrollAndClickIntoView(this.getLinkBookTicketOfRoute(departFrom, arriveAt));
    }
}




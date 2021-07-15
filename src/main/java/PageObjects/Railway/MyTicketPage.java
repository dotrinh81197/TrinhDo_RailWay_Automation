package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //locators
    private final By _rowsTicket = By.xpath("//tr[@class='OddRow' or @class='EvenRow']");

    //cell_filter_DpStation : //td//select[@name='FilterDpStation']
    // btn_apply_filter: //input[@value = 'Apply Filter']

    //elements

    private WebElement getBtnCancelTicket(int row) {
        String xpath1 = "//table[@class='MyTable']//tr[";
        String xpath2 = "]//td[11]/input[@value ='Cancel']";
        String resultXpath = xpath1 + row + xpath2;
        By btnCancelTicket = By.xpath(resultXpath);
        return Utilities.findElement(btnCancelTicket);
    }

    //methods
    private final Integer rows = Constant.WEBDRIVER.findElements(_rowsTicket).size();

    protected int getRowsTicket() {
        return Constant.WEBDRIVER.findElements(_rowsTicket).size();
    }

    public boolean isTicketDisappear() {
        boolean isElementDisappear;
        isElementDisappear = this.getRowsTicket() == rows - 1;
        return isElementDisappear;
    }

    public void cancelTicket(int row) {
        Utilities.scrollAndClickIntoView(this.getBtnCancelTicket(row));
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
}

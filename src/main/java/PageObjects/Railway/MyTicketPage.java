package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //locators
    private final By _rowsTicket = By.xpath("//tr[@class='OddRow' or @class='EvenRow']");

    private final By cell_filter_DpStation = By.xpath("//td//select[@name='FilterDpStation']");
    private final By cell_filter_ArStation = By.xpath("//td//select[@name='FilterArStation']");
    private final By btn_apply_filter = By.xpath("//input[@value = 'Apply Filter']");

    //elements

    private WebElement getBtnCancelTicket(int row) {
        String xpath1 = "//table[@class='MyTable']//tr[";
        String xpath2 = "]//td[11]/input[@value ='Cancel']";
        String resultXpath = xpath1 + row + xpath2;
        By btnCancelTicket = By.xpath(resultXpath);
        return Utilities.findElement(btnCancelTicket);
    }

    public WebElement getCellFilterDpStation(){
        return Constant.WEBDRIVER.findElement(cell_filter_DpStation);
    }

    public WebElement getCellFilterArStation(){
        return Constant.WEBDRIVER.findElement(cell_filter_ArStation);
    }

    public WebElement getBtnApplyFilter(){
        return Constant.WEBDRIVER.findElement(btn_apply_filter);
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

    public void filterBy(String departStation, String arriveStation, String departDate, String status) {

    }

    public void fillFilter(String departStation, String arriveStation, String departDate, String status) {

    }
}

package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class MyTicketPage {
    //locators
    private final By _rowsTicket = By.xpath("//tr[@class='OddRow' or @class='EvenRow']");

    private final By cbb_filter_DpStation = By.name("FilterDpStation");
    private final By cbb_filter_ArStation = By.name("FilterArStation");
    private final By text_filter_DepartDate = By.name("FilterDpDate");
    private final By cbb_filter_Status = By.name("FilterStatus");
    private final By btn_apply_filter = By.xpath("//input[@value = 'Apply Filter']");

    //elements

    private WebElement getBtnCancelTicket(int row) {
        String xpath1 = "//table[@class='MyTable']//tr[";
        String xpath2 = "]//td[11]/input[@value ='Cancel']";
        String resultXpath = xpath1 + row + xpath2;
        By btnCancelTicket = By.xpath(resultXpath);
        return Utilities.findElement(btnCancelTicket);
    }

    public WebElement getCbbFilterDpStation() {
        return Constant.WEBDRIVER.findElement(cbb_filter_DpStation);
    }

    public WebElement getCbbFilterArStation() {
        return Constant.WEBDRIVER.findElement(cbb_filter_ArStation);
    }

    public WebElement getTxtFilterDepartDate() {
        return Constant.WEBDRIVER.findElement(text_filter_DepartDate);
    }

    public WebElement getCbbFilterStatus() {
        return Constant.WEBDRIVER.findElement(cbb_filter_Status);
    }

    public WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btn_apply_filter);
    }

    public void getDepartStation(String value) {
//        Utilities.scrollAndClickIntoView(this.getCbbFilterDpStation());
        Select departDate = new Select(this.getCbbFilterDpStation());
        departDate.selectByVisibleText(Objects.requireNonNullElse(value, "Ignore"));
    }

    public void getArriveStation(String value) {
//        Utilities.scrollAndClickIntoView(this.getCbbFilterArStation());
        Select departDate = new Select(this.getCbbFilterArStation());
        departDate.selectByVisibleText(Objects.requireNonNullElse(value, "Ignore"));
    }

    public void getDepartDate(String value) {
//        Utilities.scrollAndClickIntoView(this.getTxtFilterDepartDate());
        this.getTxtFilterDepartDate().sendKeys(value);
    }

    public void getStatus(String value) {
//        Utilities.scrollAndClickIntoView(this.getCbbFilterStatus());
        Select departDate = new Select(this.getCbbFilterStatus());
        departDate.selectByVisibleText(Objects.requireNonNullElse(value, "Ignore"));
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
        this.getDepartStation(departStation);
        this.getArriveStation(arriveStation);
        this.getDepartDate(departDate);
        this.getStatus(status);
        this.getBtnApplyFilter().click();
    }

    public boolean checkTicketDisplayWithFilter(String departDate) {

        By tickets = By.xpath("//table[@class='MyTable']//td[text()='" + departDate + "']/..");
        return Utilities.findElement(tickets) != null;

    }
}

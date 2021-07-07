package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //locators
    private final By _comboBoxDepartDate = By.xpath("//select[@name='Date']");
    private final By _comboBoxDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By _comboBoxArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By _comboBoxSeatType = By.xpath("//select[@name='SeatType']");
    private final By _comboBoxTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//input[@type='submit']");
    private final By _lblBookTicketSuccessMsg = By.xpath("//div[@id='content']/h1");
    private final By _cellDepartStation = By.xpath("//table[@class ='MyTable WideTable']/tbody/tr[1]/following-sibling::tr/td[1]");
    private final By _cellDepartDate = By.xpath("//table[@class ='MyTable WideTable']/tbody/tr[1]/following-sibling::tr/td[4]");
    private final By _cellArriveStation = By.xpath("//table[@class ='MyTable WideTable']/tbody/tr[1]/following-sibling::tr/td[2]");
    private final By _cellSeatType = By.xpath("//table[@class ='MyTable WideTable']/tbody/tr[1]/following-sibling::tr/td[3]");
    private final By _cellAmount = By.xpath("//table[@class ='MyTable WideTable']/tbody/tr[1]/following-sibling::tr/td[7]");


    //elements
    protected WebElement getComboBoxDepartDate() {

        return Constant.WEBDRIVER.findElement(_comboBoxDepartDate);
    }

    protected WebElement getComboBoxDepartStation() {
        return Constant.WEBDRIVER.findElement(_comboBoxDepartStation);
    }

    protected WebElement getComboBoxArriveStation() {
        return Constant.WEBDRIVER.findElement(_comboBoxArriveStation);
    }

    protected WebElement getComboBoxSeatType() {
        return Constant.WEBDRIVER.findElement(_comboBoxSeatType);
    }

    protected WebElement getComboBoxTicketAmount() {
        return Constant.WEBDRIVER.findElement(_comboBoxTicketAmount);
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }

    protected WebElement getLblBookTicketSuccess() {
        return Constant.WEBDRIVER.findElement(_lblBookTicketSuccessMsg);
    }

    protected WebElement getCellDepartStation() {
        return Constant.WEBDRIVER.findElement(_cellDepartStation);
    }

    protected WebElement getCellDepartDate() {
        return Constant.WEBDRIVER.findElement(_cellDepartDate);
    }

    protected WebElement getCellArriveStation() {
        return Constant.WEBDRIVER.findElement(_cellArriveStation);
    }

    protected WebElement getCellSeatType() {
        return Constant.WEBDRIVER.findElement(_cellSeatType);
    }

    protected WebElement getCellAmount() {
        return Constant.WEBDRIVER.findElement(_cellAmount);
    }

    //methods

    public void getDepartDate(String value) {
        Utilities.scrollAndClickIntoView(this.getComboBoxDepartDate());
        Select departDate = new Select(this.getComboBoxDepartDate());
        departDate.selectByVisibleText(value);
    }

    public void getDepartStation(String value) {
        Utilities.scrollAndClickIntoView(this.getComboBoxDepartStation());
        Select departStation = new Select(Constant.WEBDRIVER.findElement(_comboBoxDepartStation));
        departStation.selectByVisibleText(value);
    }

    public void getArriveStation(String value) {
        Utilities.scrollAndClickIntoView(this.getComboBoxArriveStation());
        Select arriveStation = new Select(Constant.WEBDRIVER.findElement(_comboBoxArriveStation));
        arriveStation.selectByVisibleText(value);
    }

    public void getSeatType(String value) {
        Utilities.scrollAndClickIntoView(this.getComboBoxSeatType());
        Select seatType = new Select(Constant.WEBDRIVER.findElement(_comboBoxSeatType));
        seatType.selectByVisibleText(value);
    }

    public void getTicketAmount(String value) {
        Utilities.scrollAndClickIntoView(this.getComboBoxTicketAmount());
        Select ticketAmount = new Select(Constant.WEBDRIVER.findElement(_comboBoxTicketAmount));
        ticketAmount.selectByVisibleText(value);
    }

    public void fillBookTicketInfo(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.getDepartDate(departDate);
        this.getDepartStation(departFrom);
        this.getArriveStation(arriveAt);
        this.getSeatType(seatType);
        this.getTicketAmount(ticketAmount);
    }

    public void submitBookTicketInfo(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.fillBookTicketInfo(departDate, departFrom, arriveAt, seatType, ticketAmount);
        Utilities.scrollAndClickIntoView(getBtnBookTicket());
    }

    public String getMessageBookTicketSuccess() {
        return this.getLblBookTicketSuccess().getText();
    }

    public String getDepartDate() {
        return this.getCellDepartDate().getText();
    }

    public String getDepartStation() {
        return this.getCellDepartStation().getText();
    }

    public String getArriveStation() {
        return this.getCellArriveStation().getText();
    }

    public String getSeatType() {
        return this.getCellSeatType().getText();
    }

    public String getAmount() {
        return this.getCellAmount().getText();
    }

    public String getSelectedOptionDepartFrom() {
        Utilities.scrollAndClickIntoView(this.getComboBoxDepartStation());
        Select departDate = new Select(Constant.WEBDRIVER.findElement(_comboBoxDepartStation));
        return departDate.getFirstSelectedOption().getText();
    }

    public String getSelectedOptionArriveAt() {
        Utilities.scrollAndClickIntoView(this.getComboBoxArriveStation());
        Select departDate = new Select(Constant.WEBDRIVER.findElement(_comboBoxArriveStation));
        return departDate.getFirstSelectedOption().getText();
    }


}

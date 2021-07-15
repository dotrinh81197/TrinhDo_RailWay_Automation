package PageObjects.Railway;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //locators
    private final By _comboBoxDepartDate = By.name("Date");
    private final By _comboBoxDepartStation = By.name("DepartStation");
    private final By _comboBoxArriveStation = By.name("ArriveStation");
    private final By _comboBoxSeatType =  By.name("SeatType");
    private final By _comboBoxTicketAmount = By.name("TicketAmount");
    private final By _btnBookTicket = By.xpath("//input[@type='submit']");
    private final By _lblBookTicketSuccessMsg = By.xpath("//div[@id='content']//h1");
    private final By _cellDepartStation = By.xpath("//td[1]");
    private final By _cellDepartDate = By.xpath("//td[4]");
    private final By _cellArriveStation = By.xpath("//td[2]");
    private final By _cellSeatType = By.xpath("//td[3]");
    private final By _cellAmount = By.xpath("//td[7]");

    //elements
    protected WebElement getComboBoxDepartDate() {
        return Utilities.findElement(_comboBoxDepartDate);
    }

    protected WebElement getDepartStationElement() {
        return Utilities.findElement(_comboBoxDepartStation);
    }

    protected WebElement getArriveStationElement() {
        return Utilities.findElement(_comboBoxArriveStation);
    }

    protected WebElement getSeatTypeElement() {
        return Utilities.findElement(_comboBoxSeatType);
    }

    protected WebElement getTicketAmountElement() {
        return Utilities.findElement(_comboBoxTicketAmount);
    }

    protected WebElement getBtnBookTicket() {
        return Utilities.findElement(_btnBookTicket);
    }

    protected WebElement getLblBookTicketSuccess() {
        return Utilities.findElement(_lblBookTicketSuccessMsg);
    }

    protected WebElement getCellDepartStation() {
        return Utilities.findElement(_cellDepartStation);
    }

    protected WebElement getCellDepartDate() {
        return Utilities.findElement(_cellDepartDate);
    }

    protected WebElement getCellArriveStation() {
        return Utilities.findElement(_cellArriveStation);
    }

    protected WebElement getCellSeatType() {
        return Utilities.findElement(_cellSeatType);
    }

    protected WebElement getCellAmount() {
        return Utilities.findElement(_cellAmount);
    }

    //methods

    public void getDepartDate(String value) {
        Utilities.scrollAndClickIntoView(this.getComboBoxDepartDate());
        Select departDate = new Select(this.getComboBoxDepartDate());
        departDate.selectByVisibleText(value);
    }

    public void getDepartStation(String value) {
        Utilities.scrollAndClickIntoView(this.getDepartStationElement());
        Select departStation = new Select(Utilities.findElement(_comboBoxDepartStation));
        departStation.selectByVisibleText(value);
    }

    public void getArriveStation(String value) {
        Utilities.scrollAndClickIntoView(this.getArriveStationElement());
        Select arriveStation = new Select(Utilities.findElement(_comboBoxArriveStation));
        arriveStation.selectByVisibleText(value);
    }

    public void getSeatType(String value) {
        Utilities.scrollAndClickIntoView(this.getSeatTypeElement());
        Select seatType = new Select(Utilities.findElement(_comboBoxSeatType));
        seatType.selectByVisibleText(value);
    }

    public void getTicketAmount(String value) {
        Utilities.scrollAndClickIntoView(this.getTicketAmountElement());
        Select ticketAmount = new Select(Utilities.findElement(_comboBoxTicketAmount));
        ticketAmount.selectByVisibleText(value);
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
        Utilities.scrollAndClickIntoView(this.getDepartStationElement());
        Select departDate = new Select(Utilities.findElement(_comboBoxDepartStation));
        return departDate.getFirstSelectedOption().getText();
    }

    public String getSelectedOptionArriveAt() {
        Utilities.scrollAndClickIntoView(this.getArriveStationElement());
        Select departDate = new Select(Utilities.findElement(_comboBoxArriveStation));
        return departDate.getFirstSelectedOption().getText();
    }

    public void submitBookTicketInfo(Ticket ticket) {
        this.fillBookTicketInfo(ticket);
        Utilities.scrollAndClickIntoView(getBtnBookTicket());
    }

    private void fillBookTicketInfo(Ticket ticket) {
        this.getDepartDate(ticket.ticketDepartDate);
        this.getDepartStation(ticket.ticketDepartFrom);
        this.getArriveStation(ticket.ticketArriveAt);
        this.getSeatType(ticket.ticketSeatType);
        this.getTicketAmount(ticket.ticketTicketAmount);
    }
}

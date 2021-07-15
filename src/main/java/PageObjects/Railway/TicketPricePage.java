package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //locators
    private final By _btnCheckPrice = By.xpath("//tr/td//li[text()='Sài Gòn to Phan Thiết']//ancestor::tr//td//a");
    private final By _btnBookTicket = By.xpath("//tr//td//text()[contains(., 'Hard seat')]//ancestor::td//..//td//a[text()='Book ticket']");
    private final By ticketTitle = By.cssSelector("th[colspan='7']");
    //elements
    protected WebElement getBtnCheckPrice(String departFrom, String arrivedAt){
        String xpath1 = "//tr//td//li[text()='";

        String xpath2 = "']//ancestor::tr//td//a[text()='Check Price']";
        String locator = xpath1 + departFrom +"\sto\s"+ arrivedAt +xpath2;
        By resultLocator = By.xpath(locator);
        return Utilities.findElement(resultLocator);
    }

    protected WebElement getBtnBookTicket(String seatType){
        String xpath1 = "//tr//td//text()[contains(., '";
        String xpath2 = "')]//ancestor::td//..//td//a[text()='Book ticket']";
        String locator = xpath1 + seatType +xpath2;
        By resultLocator = By.xpath(locator);
        return Utilities.findElement(resultLocator);
    }

//    public static void main(String[] args) {
//        String departFrom = "Sài Gòn";
//        String arrivedAt = "Phan Thiết";
//        String xpath1 = "//tr/td/li[text()='";
//        String xpath2 = "']/ancestor::tr/td/a[text()='Check Price']";
//        String locator = xpath1 + departFrom +"\sto\s"+ arrivedAt +xpath2;
//        System.out.println(locator);
//    }

    //methods
}

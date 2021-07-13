package PageObjects.Railway;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By tabLogin = By.xpath("//a[.='Login']");
    private final By tabLogout = By.xpath("//a[.='Log out']");
    private final By tabBookTicket = By.xpath("//a[.='Book ticket']");
    private final By tabMyTicket = By.xpath("//a[.='My ticket']");
    private final By tabRegister = By.xpath("//a[.='Register']");
    private final By tabTimetable = By.xpath("//a[.='Timetable']");
    private final By tabChangePassword = By.xpath("//a[.='Change password']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space()]");

    //elements
    protected WebElement getTabLogin() {
        return Utilities.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Utilities.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() {
        return Utilities.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Utilities.findElement(tabRegister);
    }

    protected WebElement getLblWelcomeMessage() {
        return Utilities.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabMyTicket() {
        return Utilities.findElement(tabMyTicket);
    }

    protected WebElement getTabTimetable() {
        return Utilities.findElement(tabTimetable);
    }

    protected WebElement getTabChangePassword() {
        return Utilities.findElement(tabChangePassword);
    }

    //methods

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public boolean isWelcomeMsgDisplayed() {
        return getLblWelcomeMessage().isDisplayed();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();

    }

    public void gotoTimetablePage() {
        this.getTabTimetable().click();

    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();

    }

    public ChangePasswordPage gotoChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public boolean isLogoutTabExist() {
        return Utilities.isElementExist(tabLogout);
    }

    public void logout() {
        if (this.isLogoutTabExist()) {
            this.getTabLogout().click();
        }
    }

    public boolean isTabMyTicketDisplay() {
        boolean isTabDisplay = false;
        try {
           if(Utilities.isElementExist(tabMyTicket)){
               isTabDisplay = getTabMyTicket().isDisplayed();}
        } catch (NoSuchElementException exception) {
            isTabDisplay = false;
        }
        return isTabDisplay;
    }

    public boolean isTabLogOutDisplay() {
        boolean isTabDisplay;
        try {
            isTabDisplay = this.getTabLogout().isDisplayed();
        } catch (NoSuchElementException exception) {
            isTabDisplay = false;
        }
        return isTabDisplay;
    }

    public boolean isTabChangePasswordDisplay() {
        boolean isTabDisplay;
        try {
            isTabDisplay = this.getTabChangePassword().isDisplayed();
        } catch (NoSuchElementException exception) {
            isTabDisplay = false;
        }
        return isTabDisplay;
    }

}


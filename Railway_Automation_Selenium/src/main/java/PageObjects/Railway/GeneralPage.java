package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By tabLogin = By.xpath("//a[.='Login']");
    private final By tabLogout = By.xpath("//a[.='Log out']");
    private final By tabBookTicket = By.xpath("//a[.='Book ticket']");
    private final By tabMyTicket = By.xpath("//a[.='My ticket']");
    private final By tabChangePassword = By.xpath("//a[.='Change password']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space()]");
//    private final By tabPageActive = By.xpath("//li[@class='selected']/a");

    //elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }
    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    //methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public boolean checkWelcomeMsgDisplayed() {
        return getLblWelcomeMessage().isDisplayed();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoMyTicketPage(){
        this.getTabMyTicket().click();

    }

    public void gotoChangePasswordPage(){
        this.getTabChangePassword().click();
    }

    public boolean isLogoutTabExist() {
        return Constant.WEBDRIVER.findElements(tabLogout).size() != 0;
    }

    public void logout() {
        if (this.isLogoutTabExist()) {
            this.getTabLogout().click();
        }
    }

    public boolean checkTabMyTicketDisplay(){
        boolean isTabExist= false;
        try {
            isTabExist = getTabMyTicket().isDisplayed();
        }
        catch (NoSuchElementException exception){
            isTabExist= false;
        }
        return isTabExist;
    }

    public boolean checkTabLogOutDisplay(){
        boolean isTabExist= false;
        try {
            isTabExist = getTabLogout().isDisplayed();
        }
        catch (NoSuchElementException exception){
            isTabExist= false;
        }
        return isTabExist;
    }

    public boolean isAtLoginPage() {
        String pageTitle = Constant.WEBDRIVER.getTitle();
        return pageTitle.contains("Login");
    }

    public boolean isAtMyTicketPage() {
        String pageTitle = Constant.WEBDRIVER.getTitle();
        return pageTitle.contains("My Ticket");
    }

    public boolean isAtChangePasswordPage(){
        String pageTitle = Constant.WEBDRIVER.getTitle();
        return pageTitle.contains("Change Password");
    }
}


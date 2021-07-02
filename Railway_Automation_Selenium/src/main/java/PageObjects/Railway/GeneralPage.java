package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By tabLogin = By.xpath("//a[.='Login']");
    private final By tabLogout = By.xpath("//a[.='Log out']");
    private final By tabBookTicket = By.xpath("//a[.='Book ticket']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space()]");
    private final By tabPageActive = By.xpath("//li[@class='selected']/a");

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

    protected WebElement getTabPageActive() {
        return Constant.WEBDRIVER.findElement(tabPageActive);
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

    public boolean isAtLoginPage() {
        String pageTitle = Constant.WEBDRIVER.getTitle();
        return pageTitle.contains("Login");
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public boolean isLogoutTabExist() {
        return Constant.WEBDRIVER.findElements(tabLogout).size() != 0;
    }

    public void logout() {
        if (this.isLogoutTabExist()) {
            this.getTabLogout().click();
        }
    }
}


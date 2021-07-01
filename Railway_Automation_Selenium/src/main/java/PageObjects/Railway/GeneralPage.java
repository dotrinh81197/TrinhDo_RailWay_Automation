package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage<webElement> {
    //locators
    private final By tabLogin = By.xpath("//a[.='Login']");
    private final By tabLogout = By.xpath("//a[.='Log out']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong[normalize-space()]");

    //elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    //methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public boolean isLoggedIn() {
        return Constant.WEBDRIVER.findElements(tabLogout).size() !=0;
    }

    public void logout() {
        this.getTabLogout().click();
    }
}


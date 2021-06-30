package Railway;

import Constant.Constant;
import org.openqa.selenium.By;

public class GeneralPage<webElement> {
    //locators
    private final By tabLogin = By.xpath("//a[.='Login']");
    private final By tabLogout = By.xpath("//a[.='Log out']");
    private final By LblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //elements
    protected webElement getTablogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);

    }
    protected webElement getTablogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);

    }
    protected webElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(LblWelcomeMessage);

    }

    //methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTablogin().click();
        return new LoginPage();
    }
}

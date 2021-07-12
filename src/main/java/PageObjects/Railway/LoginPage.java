package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class LoginPage extends GeneralPage {

    //locators
    private final By _txtUsername = By.id("username");
    private final By _textPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@type='submit']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _linkForgotPasswordPage = By.xpath("//a[contains(@href, 'ForgotPassword')]");

    //elements
    public WebElement getUsernameElement() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getPasswordElement() {
        return Constant.WEBDRIVER.findElement(_textPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
            return  Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getForgotPasswordPageElement(){
        return Constant.WEBDRIVER.findElement(_linkForgotPasswordPage);
    }

    //methods
    public void gotoForgotPasswordPage(){
        this.getForgotPasswordPageElement().click();
    }

    public void login(String username, String password) {
        //submit Login credentials
        this.getUsernameElement().sendKeys(username);
        this.getPasswordElement().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void multipleLogin(int times) {
        for (int i = 1; i < times; i++) {
            this.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);
        }
    }

    public String getLoginErrorMessage() {
        return this.getLblLoginErrorMsg().getText();
    }

    public boolean isLoginErrorMessageDisplay() {
        boolean isElementDisplay = false;
        try {
            if (this.getLblLoginErrorMsg() != null) {
                WebElement loginErrorMsg = this.getLblLoginErrorMsg();
                isElementDisplay = loginErrorMsg.isDisplayed();
            }

        } catch (NoSuchElementException e) {
            isElementDisplay = false;
        }
        return isElementDisplay;
    }
}

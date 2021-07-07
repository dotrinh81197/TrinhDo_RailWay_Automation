package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //locators

    protected final By _txtEmail = By.id("email");
    protected final By _txtPassword = By.id("password");
    protected final By _txtConfirmPassword = By.id("confirmPassword");
    protected final By _txtPID = By.id("pid");
    protected final By _btnRegister = By.xpath("//input[@type='submit']");
    protected final By _msgRegisterSuccess = By.xpath("//div[@id='content']/p");
    protected final By _msgRegisterError = By.xpath("//p[@class='message error']");
    protected final By _lblPasswordError = By.xpath("//li[@class='password']/label[@class='validation-error']");
    protected final By _lblPidError = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");



    //elements

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(_txtPID);
    }

    public WebElement getMsgRegisterSuccess() {
        return Constant.WEBDRIVER.findElement(_msgRegisterSuccess);
    }

    public WebElement getMsgRegisterError() {
        return Constant.WEBDRIVER.findElement(_msgRegisterError);
    }

    public WebElement getLblPasswordError() {
        return Constant.WEBDRIVER.findElement(_lblPasswordError);
    }

    public WebElement getLblPidError() {
        return Constant.WEBDRIVER.findElement(_lblPidError);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    //methods

    public void fillRegisterInfo(String registerEmail, String registerPassword, String confirmPassword, String pid) {
//        String registerEmail = Utilities.generateRandomEmail();
        this.getTxtEmail().sendKeys(registerEmail);
        this.getTxtPassword().sendKeys(registerPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(pid);

    }

    public void registerAccount(String email, String password, String confirmPassword, String pid) {
        this.fillRegisterInfo(email, password, confirmPassword, pid);
        Utilities.scrollAndClickIntoView(this.getBtnRegister());

    }

    public String getRegisterSuccessMsg(){
       return this.getMsgRegisterSuccess().getText();
    }

    public String getRegisterErrorMsg(){
        return this.getMsgRegisterError().getText();
    }

    public String getRegisterErrorPassword(){
        return this.getLblPasswordError().getText();
    }

    public String getRegisterErrorPid(){
        return this.getLblPidError().getText();
    }

}

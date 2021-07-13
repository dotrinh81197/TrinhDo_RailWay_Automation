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

    public WebElement getEmailElement() {
        return Utilities.findElement(_txtEmail);
    }

    public WebElement getPasswordElement() {
        return Utilities.findElement(_txtPassword);
    }

    public WebElement getConfirmPasswordElement() {
        return Utilities.findElement(_txtConfirmPassword);
    }

    public WebElement getPIDElement() {
        return Utilities.findElement(_txtPID);
    }

    public WebElement getMsgRegisterSuccess() {
        return Utilities.findElement(_msgRegisterSuccess);
    }

    public WebElement getMsgRegisterError() {
        return Utilities.findElement(_msgRegisterError);
    }

    public WebElement getLblPasswordError() {
        return Utilities.findElement(_lblPasswordError);
    }

    public WebElement getLblPidError() {
        return Utilities.findElement(_lblPidError);
    }

    public WebElement getBtnRegister() {
        return Utilities.findElement(_btnRegister);
    }

    //methods

    public void fillRegisterInfo(String registerEmail, String registerPassword, String confirmPassword, String pid) {
        this.getEmailElement().sendKeys(registerEmail);
        this.getPasswordElement().sendKeys(registerPassword);
        this.getConfirmPasswordElement().sendKeys(confirmPassword);
        this.getPIDElement().sendKeys(pid);

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

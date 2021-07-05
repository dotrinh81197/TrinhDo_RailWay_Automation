package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //locators

    protected final By _txtEmail = By.id("email");
    protected final By _txtPassword = By.id("password");
    protected final By _txtConfirmPassword = By.id("confirmPassword");
    protected final By _txtPID = By.id("pid");
//    protected final By _btnRegister = By.xpath("//input[@type='submit']");
    protected final By _msgRegisterSuccess = By.xpath("//div[@id='content']/p");


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

//    public WebElement getBtnRegister() {
//        return Constant.WEBDRIVER.findElement(_btnRegister);
//    }

    //methods

    public void fillRegisterInfo(String registerEmail, String registerPassword, String confirmPassword, String pid) {
//        String registerEmail = Utilities.generateRandomEmail();
        this.getTxtEmail().sendKeys(registerEmail);
        this.getTxtPassword().sendKeys(registerPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(pid);

    }

    public RegisterPage registerAccount(String email, String password, String confirmPassword, String pid) {
        this.fillRegisterInfo(email, password, confirmPassword, pid);
//        try {
//            this.getBtnRegister().click();
//        } catch (Exception e) {
//            WebDriver driver = new ChromeDriver();
//            Actions action = new Actions(driver);
//            action.sendKeys(Keys.PAGE_DOWN);
//            this.getBtnRegister().click();
//        }
        this.getTxtPID().sendKeys(Keys.ENTER);
        return new RegisterPage();
    }

    public String getRegisterSuccessMsg(){
       return this.getMsgRegisterSuccess().getText();
    }



}

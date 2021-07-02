package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{

    //locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _textPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private  final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //elements
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);

    }

    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_textPassword);

    }

    public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);

    }

    public WebElement getLblLoginErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    //methods

    public HomePage login(String username, String password){
        //submit Login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        //land on Home page
        return new HomePage();
    }

    public void multipleLogin(int times){
        for (int i = 1; i < times; i++) {
            this.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);
        }
    }

    public String getLoginErrorMessage(){
        return this.getLblLoginErrorMsg().getText();
    }
}

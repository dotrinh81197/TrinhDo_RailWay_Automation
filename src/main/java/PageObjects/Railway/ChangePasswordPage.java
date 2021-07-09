package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    //locators
    private final By _txtCurrentPassword = By.id("currentPassword");
    private final By _textNewPassword = By.id("newPassword");
    private final By _textConfirmPassword = By.id("confirmPassword");
    private final By _btnChangePassword = By.xpath("//input[@type='submit']");
    private final By _lblMessageSuccess = By.xpath("//p[@class='message success']");
    //elements

    protected WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }

    protected WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(_textNewPassword);
    }

    protected WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_textConfirmPassword);
    }

    protected WebElement getBtnChangePassword(){
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }

    protected WebElement getLblMessageSuccess(){
        return Constant.WEBDRIVER.findElement(_lblMessageSuccess);
    }

    //methods
    public void fillChangePasswordInfo(String currentPassword, String newPassword, String confirmPassword){
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
    }

    public void submitChangePassword(String currentPassword, String newPassword, String confirmPassword){
        this.fillChangePasswordInfo(currentPassword, newPassword, confirmPassword);
        this.getBtnChangePassword().click();
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword){
        this.submitChangePassword(currentPassword, newPassword, confirmPassword);
    }

    public String getChangePasswordSuccessMsg(){
        return this.getLblMessageSuccess().getText();
    }


}

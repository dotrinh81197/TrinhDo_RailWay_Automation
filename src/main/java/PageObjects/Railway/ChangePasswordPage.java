package PageObjects.Railway;

import Common.Common.Utilities;
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

    protected WebElement getCurrentPasswordElement(){
        return Utilities.findElement(_txtCurrentPassword);
    }

    protected WebElement getNewPasswordElement(){
        return Utilities.findElement(_textNewPassword);
    }

    protected WebElement getConfirmPasswordElement(){
        return Utilities.findElement(_textConfirmPassword);
    }

    protected WebElement getBtnChangePassword(){
        return Utilities.findElement(_btnChangePassword);
    }

    protected WebElement getMessageSuccessElement(){
        return Utilities.findElement(_lblMessageSuccess);
    }

    //methods
    public void fillChangePasswordInfo(String currentPassword, String newPassword, String confirmPassword){
        this.getCurrentPasswordElement().sendKeys(currentPassword);
        this.getNewPasswordElement().sendKeys(newPassword);
        this.getConfirmPasswordElement().sendKeys(confirmPassword);
    }

    public void submitChangePassword(String currentPassword, String newPassword, String confirmPassword){
        this.fillChangePasswordInfo(currentPassword, newPassword, confirmPassword);
        this.getBtnChangePassword().click();
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword){
        this.submitChangePassword(currentPassword, newPassword, confirmPassword);
    }

    public String getChangePasswordSuccessMsg(){
        return this.getMessageSuccessElement().getText();
    }


}

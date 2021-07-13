package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //locators
    private final By _txtEmailAddress = By.id("email");

    private final By _btnSubmitEmail = By.xpath("//input[@type='submit']");

    //elements
    protected WebElement getEmailAddressElement(){
        return Utilities.findElement(_txtEmailAddress);
    }

    protected WebElement getBtnSubmitEmail(){
        return Utilities.findElement(_btnSubmitEmail);
    }

    //methods

    public void submitEmail(String registerEmail){
        this.getEmailAddressElement().sendKeys(registerEmail);
        Utilities.scrollAndClickIntoView(getBtnSubmitEmail());
    }
}

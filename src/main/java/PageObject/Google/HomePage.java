package PageObject.Google;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    //locators
    public final By search_box = By.xpath("//input[@class='gLFyf gsfi']");
    private final By google_BigLogo = By.xpath("//img[@class='lnXdpd']");
    private final By button_search = By.xpath("//img[@class='gNO89b']");
    private final By button_firstPage = By.xpath("//img[@class='RNmpXc']");
    private final By link_LanguageEnglish = By.xpath("//div[@id='SIvCob']//a[text()='English']");

    //elements
    public WebElement getSearchBox() {
        return Utilities.findElement(search_box);
    }

    protected WebElement getBtnSearch() {
        return Utilities.findElement(button_search);
    }

    public WebElement getGoogleBigLogo() {
        return Utilities.findElement(google_BigLogo);
    }

    protected WebElement getBtnFirstPage() {
        return Utilities.findElement(button_firstPage);
    }

    public WebElement getLink_LanguageEnglish() {
        return Utilities.findElement(link_LanguageEnglish);
    }


    public void searchFor(String text) {
        getSearchBox().sendKeys(text);
        getSearchBox().submit();
    }

    public String getSearchBoxValue() {
        return getSearchBox().getAttribute("value");
    }

    public void switchToEnglish() {
        if (Utilities.isElementExist(link_LanguageEnglish)) {
            Utilities.clickElement(this.getLink_LanguageEnglish());
        }
    }

}

package PageObject.Google;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    //locators
    private final By searchTextBox = By.xpath("//input[@class='gLFyf gsfi']");
    private final By logo = By.xpath("//img[@class='lnXdpd']");
    private final By searchButton = By.xpath("//img[@class='gNO89b']");
    private final By firstPageButton = By.xpath("//img[@class='RNmpXc']");
    private final By languageEnglishLink = By.xpath("//div[@id='SIvCob']//a[text()='English']");

    //elements
    public WebElement getSearchBox() {
        return Utilities.findElement(searchTextBox);
    }

    protected WebElement getBtnSearch() {
        return Utilities.findElement(searchButton);
    }

    public WebElement getGoogleBigLogo() {
        return Utilities.findElement(logo);
    }

    protected WebElement getBtnFirstPage() {
        return Utilities.findElement(firstPageButton);
    }

    public WebElement getLanguageEnglishLink() {
        return Utilities.findElement(languageEnglishLink);
    }


    public void searchFor(String text) {
        getSearchBox().sendKeys(text);
        getSearchBox().submit();
    }

    public String getSearchBoxValue() {
        return getSearchBox().getAttribute("value");
    }

    public void switchToEnglish() {
        if (Utilities.isElementExist(languageEnglishLink)) {
            Utilities.clickElement(this.getLanguageEnglishLink());
        }
    }

}

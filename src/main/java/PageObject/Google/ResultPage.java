package PageObject.Google;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Common.Log;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ResultPage extends Utilities {
    //locators
    public final By peopleAlsoAskSection = By.xpath("//span[text()='People also ask']//ancestor::div[@class='Wt5Tfe']");
    private final By google_BigLogo = By.xpath("//img[@class='lnXdpd']");
    private final By button_search = By.xpath("//img[@class='gNO89b']");
    private final By button_firstPage = By.xpath("//img[@class='RNmpXc']");
    private final By link_LanguageEnglish = By.xpath("//div[@id='SIvCob']//a[text()='English']");
    public final By firstResult = By.xpath("(//div[@class='yuRUbf']//h3[@class='LC20lb MBeuO DKV0Md'])[1]");
    public final By peopleFirstQuestion = By.xpath("(//span[text()='People also ask']//ancestor::div[@class='Wt5Tfe']//div[@class='iDjcJe IX9Lgd wwB5gf'])[1]");
    public final By label_topStory = By.xpath("//div[@class='iJ1Kvb']//h3[text()='Top stories']");
    public final By label_firstStory = By.xpath("(//div[@class='mCBkyc tNxQIb ynAwRc nDgy9d'])[1]");
    public final By firstVideo = By.xpath("(//div[@class='uOId3b'])[1]");

    String videosTitles = "(//div[@class='mLmaBd']//div[@role='heading'])[%d]";


    //elements
    public WebElement getPeopleFirstQuestion() {
        return findElement(peopleFirstQuestion);
    }

    private WebElement getFirstStory() {
        return findElement(label_firstStory);
    }

    public WebElement getFirstVideo() {
         return findElement(firstVideo);
    }


    //methods
    public void checkPeopleAlsoAskSection(String searchValue) {
        try {
            if (isElementExist(peopleAlsoAskSection)) {
                Assert.assertTrue(isElementExist(peopleFirstQuestion));
                String firstQuestion = getPeopleFirstQuestion().getText().toLowerCase();
                Assert.assertTrue(firstQuestion.contains(searchValue.toLowerCase()), "First question contains search value" + searchValue);
            }
        } catch (Exception e) {
            Log.error(e);
        }
    }

    public void checkVideoSection(String searchValue) {
        try {
            for (int i = 1; i < 4; i++) {
                WebElement itemText = Utilities.findElement(By.xpath(String.format(videosTitles, i)));
                Assert.assertTrue(itemText.getText().toLowerCase().contains(searchValue.toLowerCase()), "Video header contains search value" + searchValue);

            }
        } catch (Exception e) {
            Log.error(e);
        }
    }

    public void checkTopStoriesSection(String searchValue) {
        try {
            if (isElementExist(label_topStory)) {
                Assert.assertTrue(isElementExist(label_firstStory));
                String firstQuestion = getFirstStory().getText().toLowerCase();
                Assert.assertTrue(firstQuestion.contains(searchValue.toLowerCase()), "First story contains search value" + searchValue);
            }
        } catch (Exception e) {
            Log.error(e);
        }
    }

}

package PageObject.Google;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ResultPage extends Utilities {

    //locators
    private final By peopleAlsoAskSection = By.xpath("//span[text()='People also ask']//ancestor::div[@class='Wt5Tfe']");
    private final By firstResult = By.xpath("(//div[@class='FGpTBd']//h3[@class='H1u2de'])");
    private final By peopleFirstQuestion = By.xpath("(//span[text()='People also ask']//ancestor::div[@class='Wt5Tfe']//div[@class='iDjcJe IX9Lgd wwB5gf'])[1]");
    private final By topStoryLabel = By.xpath("//div[@class='iJ1Kvb']//h3[text()='Top stories']");
    private final By firstStoryLabel = By.xpath("(//div[@class='mCBkyc tNxQIb ynAwRc nDgy9d'])[1]");
    private final By firstVideo = By.xpath("(//div[@class='uOId3b'])[1]");

    String videosTitles = "(//div[@class='mLmaBd']//div[@role='heading'])[%d]";


    //elements
    public WebElement getPeopleFirstQuestion() {
        return findElement(peopleFirstQuestion);
    }

    public WebElement getFirstResult() {
        return findElement(firstResult);
    }

    private WebElement getFirstStory() {
        return findElement(firstStoryLabel);
    }

    public WebElement getFirstVideo() {
        return findElement(firstVideo);
    }

    public boolean doesFirstResultDisplay() {
        if (Utilities.checkControlExit(this.getFirstResult()) == true) {
            return true;
        } else return false;
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

        }
    }

    public void checkVideoSection(String searchValue) {
        try {
            for (int i = 1; i < 4; i++) {
                WebElement itemText = Utilities.findElement(By.xpath(String.format(videosTitles, i)));
                Assert.assertTrue(itemText.getText().toLowerCase().contains(searchValue.toLowerCase()), "Video header contains search value" + searchValue);

            }
        } catch (Exception e) {

        }
    }

    public void checkTopStoriesSection(String searchValue) {
        try {
            if (isElementExist(topStoryLabel)) {
                Assert.assertTrue(isElementExist(firstStoryLabel));
                String firstQuestion = getFirstStory().getText().toLowerCase();
                Assert.assertTrue(firstQuestion.contains(searchValue.toLowerCase()), "First story contains search value" + searchValue);
            }
        } catch (Exception e) {

        }
    }

    public void open1stVideo() {
        Utilities.waitForControl(getFirstVideo());
        getFirstVideo().click();
    }

    public String getTitleVideo() {
        String videoTitle = getFirstVideo().getText().trim();
        return videoTitle;

    }

}

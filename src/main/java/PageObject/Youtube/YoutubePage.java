package PageObject.Youtube;

import Common.Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YoutubePage {

    //locators
    private final By playButton = By.xpath("//div[@class='ytp-chrome-controls']//button[contains(@class,'play-button')]");
    private final By timeVideoPlayed = By.xpath("//span[@class='ytp-time-current']");
    private final By videoTitle = By.xpath("//div[@id='info-contents']//h1[contains(@class,'title')]");

    //elements
    public WebElement getPlayButton() {
        return Utilities.findElement(playButton);
    }

    public WebElement getTimeVideoPlayed() {
        return Utilities.findElement(timeVideoPlayed);
    }

    public WebElement getVideoTitle() {
        return Utilities.findElement(videoTitle);
    }

    public void playVideoFor(int duration) throws InterruptedException {
        Thread.sleep(duration * 1000);
        getPlayButton().click();
    }

    public boolean doesVideoPlayFor(int duration) {
        int minutes = duration / 60;
        int seconds = duration % 60;
        String strMinutes = String.valueOf(minutes);
        String strSeconds = String.valueOf(seconds);

        if (seconds < 10) {
            strSeconds = "0".concat(strSeconds);
        }

        return getTimeVideoPlayed().getText().equals(strMinutes + ":" + strSeconds);
    }

    public String getYoutubeVideoTitle() {
        Utilities.waitForControl(getVideoTitle());
        return getVideoTitle().getText().trim();
    }

}

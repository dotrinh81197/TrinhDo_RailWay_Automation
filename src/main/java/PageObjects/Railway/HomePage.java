package PageObjects.Railway;

import Common.Constant.Constant;

public class HomePage extends GeneralPage {
    //locators

    //elements

    //methods
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAIlWAY_URL);
        return this;
    }

}

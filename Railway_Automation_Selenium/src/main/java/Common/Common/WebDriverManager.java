//package Common.Common;
//
//import Common.Constant.Constant;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WebDriverManager {
//    ChromeDriver driver;
//    private static WebDriverManager instance = null;
//    private WebDriverManager(){
//        driver = new ChromeDriver();
//    }
//
//    public static WebDriverManager getInstance(){
//        if (instance == null){
//            instance = new WebDriverManager();
//
//        }
//        return instance;
//    }
//
//    public void maximize(){
//        driver.manage().window().maximize();
//
//    }
//
//    public void navigate(){
//        driver.navigate().to(Constant.RAIlWAY_URL);
//    }
//
//    public WebElement findElement(String locator){
//        By element=null;
//        if(locator.contains("xp")){
//             element = By.xpath(locator);
//        }else {
//            if (!locator.contains("id")) {
//                return driver.findElement(element);
//            }
//            element = By.xpath(locator);
//        }
//        return driver.findElement(element);
//    }
//}

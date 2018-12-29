package mytest.example.au.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by roya.
 */
public class Communication {

    private static Long implicitWait = 18000L;

    private static Long delay = 30000L;

    private static WebDriver driver = setDelayProperties(chooseTrueDriver());

    public static WebDriver getDriver() {
        return driver;
    }


    public static void implicitWaitVisibleId(String idName){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id(idName))));
    }

    public static void implicitWaitVisibleClass(String className){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.className(className))));
    }

    public static void implicitWaitVisibleId(String idName, int time){
        WebDriverWait wait = new WebDriverWait(getDriver(),time);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id(idName))));
    }

    public static void implicitWaitIdInvisible(String idName){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.id(idName))));
    }

    public static void implicitWaitClassInvisible(String className){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.className(className))));
    }

    public static void implicitWaitTitle(String title){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void implicitWaitXpath(String xpath){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(xpath))));
    }

    public static void implicitWaitXpathInvisibel(String xpath){
        WebDriverWait wait = new WebDriverWait(getDriver(),delay);
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath(xpath))));
    }

    public boolean navigatedToWebSite( String url , String verificationElementId){
        getDriver().navigate().to(url);
        implicitWaitVisibleId(verificationElementId);
        if(getDriver().findElement(By.id(verificationElementId)) != null)
            return true;
        else
            return false;
    }

    public static Long getImplicitWait() {
        return implicitWait;
    }

    public static void setImplicitWait(Long implicitWait) {
        Communication.implicitWait = implicitWait;
    }

    public static Long getDelay() {
        return delay;
    }

    public static void setDelay(Long delay) {
        Communication.delay = delay;
    }

    private static WebDriver chooseTrueDriver() {
        switch (System.getProperty("os.name")){
            case "Linux":
                setProperties("/Drivers/chromedriver_linux");
                return new ChromeDriver();
            case "Windows 7":
                setProperties("/Drivers/chromedriver.exe");
                return new ChromeDriver();
            case "Windows 10":
                setProperties("/Drivers/chromedriver.exe");
                return new ChromeDriver();
            case "Mac OS X":
                setProperties("/Drivers/chromedriver_mac");
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }

private static WebDriver setDelayProperties(WebDriver webDriver){
        webDriver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.MILLISECONDS);
//        webDriver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.MILLISECONDS);
        return webDriver;
    }

    private static void setProperties(String fileName){
        String driverPath = Communication.class.getResource(fileName).getPath();
        System.setProperty("webdriver.chrome.driver" , driverPath);
    }
}

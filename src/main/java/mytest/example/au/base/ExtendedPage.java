package mytest.example.au.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * Created by roya.
 */
public abstract class ExtendedPage {

    private WebDriver driver = Communication.getDriver();

    protected void setTextBoxWithId(String id, String value){
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).click();
        driver.findElement(By.id(id)).sendKeys(value);
    }
    protected void setTextBoxWithXpath(String xpath, String value){
        Communication.implicitWaitXpath(xpath);
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    protected void clickWithId(String id){
        driver.findElement(By.id(id)).click();
    }


    protected void clickWithClass(String className){
        driver.findElement(By.className(className)).click();
    }

    protected void selectWithXpath(String xpath){
        Communication.implicitWaitXpath(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void selectWithId(String Id){
        Communication.implicitWaitVisibleId(Id);
        driver.findElement(By.id(Id)).click();
    }

    protected void selectDropDownList(String id,String value){
        Communication.implicitWaitVisibleId(id);
        new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
    }

    protected void selectLIListByClass(String className,int choiceNumber){
        Communication.implicitWaitVisibleClass(className);
        List<WebElement> webDriverList = driver.findElements(By.xpath("//ol[@class='"+className+"']/li"));
        webDriverList.get(choiceNumber).click();
    }

    protected void select2ListByClass(String className, String className2 ,int choiceNumber){
        Communication.implicitWaitVisibleClass(className);
        driver.findElement(By.className(className)).click();
        List<WebElement> webDriverList = driver.findElements(By.xpath("//ul[@class='"+className2+"']/li"));
        webDriverList.get(choiceNumber).click();
    }



    protected void selectLIListByID(String id,int choiceNumber){
        Communication.implicitWaitVisibleId(id);
        List<WebElement> webDriverList = driver.findElements(By.xpath("//ul[@id='"+id+"']/li"));
        webDriverList.get(choiceNumber).click();
    }

    protected void selectbuttonByClassTag(String className,String tag){
        Communication.implicitWaitVisibleClass(className);
        WebElement webDriverList = driver.findElement(By.className(className)).findElement(By.tagName(tag));
        webDriverList.click();
    }

    protected void pressEnterKey(String id){
        driver.findElement(By.id(id)).sendKeys(Keys.ENTER);
    }


    public abstract boolean init() throws InterruptedException;

    protected void navigateToURL(String baseURL , String postFix , String pageTile){
        driver.navigate().to(baseURL+postFix);
        Communication.implicitWaitTitle(pageTile);
    }

    protected void navigateToSpaceURL(String space){
        driver.navigate().to("https://qeatlassian.atlassian.net/wiki/spaces/"+space);
        Communication.implicitWaitTitle(space.toLowerCase()+" - Confluence");
    }

    protected void clickOnConsistedStringLink(String text){
        driver.findElement(By.partialLinkText(text)).click();
    }
}

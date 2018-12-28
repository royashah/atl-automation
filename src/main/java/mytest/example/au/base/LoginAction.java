package mytest.example.au.base;

import mytest.example.au.page.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by roya.
 */
public class LoginAction {
    public static boolean isLogin() {
        LoginPage loginPage = new LoginPage();
        Communication.getDriver().manage().timeouts().implicitlyWait(5000L, TimeUnit.MILLISECONDS);
        if (Communication.getDriver().findElements(By.id("logo")).size() == 0) {
            Communication.getDriver().manage().timeouts().implicitlyWait(Communication.getImplicitWait(), TimeUnit.MILLISECONDS);
            Communication communication = new Communication();
            if (communication.navigatedToWebSite("https://id.atlassian.com/login?continue=https%3A%2F%2Fqeatlassian.atlassian.net%2Flogin%3FredirectCount%3D1%26dest-url%3D%252Fwiki%252Findex.action&email=donetobeba%40nando1.com&errorCode", loginPage.getUsenameID())) {
                loginPage.setUserName("donetobeba@nando1.com");
                loginPage.setPassword("r@123456789");
                loginPage.setLoginID("login-submit");
                if (loginPage.init()) {
                    Assert.assertTrue("Check Title", communication.getDriver().getTitle().startsWith("Dashboard - Confluence"));
                }
            }
        }
        return true;
    }
}

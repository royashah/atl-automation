package mytest.example.au.test;

import mytest.example.au.base.Communication;
import mytest.example.au.base.LoginAction;
import mytest.example.au.page.CreatPage;
import mytest.example.au.page.LoginPage;
import mytest.example.au.page.RestrictionPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class SetRestrictionTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        if(LoginAction.isLogin()){
            RestrictionPage restrictionPage = new RestrictionPage();
            restrictionPage.setSpace("Test");
            restrictionPage.setPage("HP810VIR");
            restrictionPage.setIdRightSideMenu("action-menu-link");
            restrictionPage.setIdRestriction("action-page-permissions-link");
            restrictionPage.setClassSelect2("select2-choice");
            restrictionPage.setIdSubmitbutton("page-restrictions-dialog-save-button");
            restrictionPage.setNumberOfRestriction(2);
            if(restrictionPage.init()) {
                Assert.assertEquals(restrictionPage.getPage(), Communication.getDriver().findElement(By.id("title-text")).getText());
            }
        }
        Communication.getDriver().close();
    }
}

package mytest.example.au.test;

import mytest.example.au.base.Communication;
import mytest.example.au.base.ExtendedPage;
import mytest.example.au.base.GeneralUtils;
import mytest.example.au.base.LoginAction;
import mytest.example.au.page.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;


public class SimpleCreatePageTest {
    @Test
    public static void main(String[] args) {
        if(LoginAction.isLogin()){
            CreatPage creatPage = new CreatPage();
            creatPage.setNumberOfPageType(0);
            String randStr = GeneralUtils.getRandString(8);
            creatPage.setText(randStr);
            if(creatPage.init()) {
                Assert.assertEquals(randStr, Communication.getDriver().findElement(By.id("title-text")).getText());
            }
        }
        Communication.getDriver().close();
    }
}

package mytest.example.au.page;

import mytest.example.au.base.Communication;
import mytest.example.au.base.ExtendedPage;

/**
 * Created by roya.
 */
public class LoginPage extends ExtendedPage {

    private String userName;
    private String password;
    private String loginID;
    private String passwordID = "password";
    private String usenameID = "username";
    private String welcomPageID = "Dashboard - Confluence";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }


    public String getPasswordID() {
        return passwordID;
    }

    public void setPasswordID(String passwordID) {
        this.passwordID = passwordID;
    }

    public String getUsenameID() {
        return usenameID;
    }

    public void setUsenameID(String usenameID) {
        this.usenameID = usenameID;
    }

    public String getWelcomPageID() {
        return welcomPageID;
    }

    public void setWelcomPageID(String welcomPageID) {
        this.welcomPageID = welcomPageID;
    }

    @Override
    public boolean init() {
        setTextBoxWithId(getUsenameID(),getUserName());
        clickWithId(getLoginID());
        Communication.implicitWaitVisibleId(getPasswordID());
        setTextBoxWithId(getPasswordID(),getPassword());
        clickWithId(getLoginID());
        Communication.implicitWaitTitle(getWelcomPageID());
        return true;
    }
}

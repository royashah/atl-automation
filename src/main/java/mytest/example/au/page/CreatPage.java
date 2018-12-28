package mytest.example.au.page;

import mytest.example.au.base.Communication;
import mytest.example.au.base.ExtendedPage;

/**
 * Created by roya.
 */
public class CreatPage extends ExtendedPage {

    private String creatID = "create-page-button";
    private String creatDialogWindowID = "create-dialog";
    private String text ;
    private Integer numberOfPageType;

    public String getCreatID() {
        return creatID;
    }

    public void setCreatID(String creatID) {
        this.creatID = creatID;
    }

    public String getCreatDialogWindowID() {
        return creatDialogWindowID;
    }

    public void setCreatDialogWindowID(String creatDialogWindowID) {
        this.creatDialogWindowID = creatDialogWindowID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumberOfPageType() {
        return numberOfPageType;
    }

    public void setNumberOfPageType(Integer numberOfPageType) {
        this.numberOfPageType = numberOfPageType;
    }

    @Override
    public boolean init() {
        clickWithId(getCreatID());
        Communication.implicitWaitVisibleId(getCreatDialogWindowID());
        Communication.implicitWaitVisibleClass("templates");
        selectLIListByClass("templates",getNumberOfPageType());
        selectbuttonByClassTag("dialog-button-panel","button");
        Communication.implicitWaitTitle("Add Page - Confluence");
        Communication.implicitWaitVisibleId("content-title-div");
        setTextBoxWithId("content-title",getText());
        pressEnterKey("content-title");
        clickWithId("rte-button-publish");
        Communication.implicitWaitIdInvisible("rte-button-publish");
        Communication.implicitWaitVisibleId("title-text");
        return true;
    }
}

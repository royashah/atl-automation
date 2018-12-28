package mytest.example.au.page;

import mytest.example.au.base.Communication;
import mytest.example.au.base.ExtendedPage;

/**
 * Created by roya.
 */
public class RestrictionPage extends ExtendedPage {

    private String space;
    private String page;
    private String idRightSideMenu;
    private String idRestriction;
    private String classSelect2;
    private String idSubmitbutton;
    private Integer numberOfRestriction;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getIdRightSideMenu() {
        return idRightSideMenu;
    }

    public void setIdRightSideMenu(String idRightSideMenu) {
        this.idRightSideMenu = idRightSideMenu;
    }

    public String getIdRestriction() {
        return idRestriction;
    }

    public void setIdRestriction(String idRestriction) {
        this.idRestriction = idRestriction;
    }

    public String getIdSubmitbutton() {
        return idSubmitbutton;
    }

    public void setIdSubmitbutton(String idSubmitbutton) {
        this.idSubmitbutton = idSubmitbutton;
    }

    public String getClassSelect2() {
        return classSelect2;
    }

    public void setClassSelect2(String classSelect2) {
        this.classSelect2 = classSelect2;
    }

    public Integer getNumberOfRestriction() {
        return numberOfRestriction;
    }

    public void setNumberOfRestriction(Integer numberOfRestriction) {
        if(numberOfRestriction > 3 || numberOfRestriction < 1 )
            this.numberOfRestriction = 0;
        else
            this.numberOfRestriction = numberOfRestriction - 1;
    }

    @Override
    public boolean init() throws InterruptedException {
        navigateToSpaceURL(getSpace());
        clickOnConsistedStringLink(getPage());
        clickWithId(getIdRightSideMenu());
        selectWithId(getIdRestriction());
        select2ListByClass(getClassSelect2(),"select2-results",getNumberOfRestriction());
        selectWithId(getIdSubmitbutton());
        return true;
    }
}

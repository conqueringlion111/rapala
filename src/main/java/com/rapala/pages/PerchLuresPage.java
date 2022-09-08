package com.rapala.pages;

import com.rapala.locators.PerchLuresPageLocators;
import com.rapala.pagebase.PageBase;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PerchLuresPage extends PageBase {

    public PerchLuresPage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public PerchLuresPage verifyPageTitleValue(String value) {
        Assert.assertEquals(sel.getText(PerchLuresPageLocators.PAGE_TITLE_CSS), value, "The expected page title did not display");
        return this;
    }


}

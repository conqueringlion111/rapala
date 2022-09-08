package com.rapala.pages;

import com.rapala.helper.Waits;
import com.rapala.locators.BlueFoxPageLocators;
import com.rapala.pagebase.PageBase;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BlueFoxPage extends PageBase {
    public BlueFoxPage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public BlueFoxPage waitForPageLoadComplete() {
        sel.jsWaitForPageLoadComplete();
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(BlueFoxPageLocators.BLUE_FOX_PAGE_SECONDARY_NAV);
        return new BlueFoxPage(driver);
    }
    public BlueFoxPage verifyNavigationToBlueFoxPageSuccessful(String expectedTitleStr) {
        String pageTitle = sel.getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains(expectedTitleStr.toLowerCase()), "expected title is not visible");
        return new BlueFoxPage(driver);
    }

    public BlueFoxPage verifyBlueFoxPageContainsExpectedTitleStr(String expectedTitleStr) {
        sel.jsWaitForPageLoadCompleteV2();
        Waits wait = new Waits(driver);
        wait.waitForVisibilityOfElementBy(BlueFoxPageLocators.SPINNERS_LINK_TOP_X);
        String pageTitle = sel.getTitle();
        Assert.assertTrue(pageTitle.contains(expectedTitleStr), "expected title is not visible");
        return new BlueFoxPage(driver);
    }

}

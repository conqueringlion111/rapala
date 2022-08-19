package com.rapala.pagebase;

import com.rapala.locators.PerchLuresPageLocators;
import com.rapala.pages.PerchLuresPage;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPageTitleValue(WebDriver driver, By locator, String value) {
        SeleniumMethods sel = new SeleniumMethods(driver);
        Assert.assertEquals(sel.getText(locator), value, "The expected page title did not display");
    }

}

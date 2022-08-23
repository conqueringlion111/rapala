package com.rapala.pages;

import com.rapala.pagebase.PageBase;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ToolsPage extends PageBase {
    public ToolsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTotalNumberOfItemsAvailable(By locator, String totalItems) {
        SeleniumMethods sel = new SeleniumMethods(driver);
        int totalCount = sel.findTotalElementCount(locator);
        Assert.assertTrue(totalCount >= Integer.parseInt(totalItems), "the expected number of items not available*");
    }
}

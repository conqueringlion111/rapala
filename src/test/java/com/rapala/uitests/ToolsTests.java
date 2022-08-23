package com.rapala.uitests;

import com.rapala.locators.CommonLocators;
import com.rapala.locators.HomePageLocators;
import com.rapala.locators.ToolsPageLocators;
import com.rapala.locators.WelcomeToRapalaPopUpLocators;
import com.rapala.testbase.TestBase;
import com.rapala.utils.SeleniumMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolsTests extends TestBase {

    @Test(groups = "tools", dataProvider = "dataProvider", description = "Test to validate user can navigate to Tools Page")
    public void verifyNavigateToToolsPageSuccessful(String expectedTitle) {
        homepage.navigateToToolsPage()
                .verifyPageTitleValue(driver, CommonLocators.PAGE_TITLE_CSS, expectedTitle);
    }

    @Test(groups = "tools", dataProvider = "dataProvider", description = "Test to validate user can navigate to Tools Page")
    public void verifyNavigateToToolsPageSuccessfulV2(String expectedTitle) {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(WelcomeToRapalaPopUpLocators.ACCEPT_ALL_COOKIES_BUTTON_X);
        sel.selClickBy(HomePageLocators.TOOLS_BUTTON_X);
        sel.verifyPageTitleValue(driver, CommonLocators.PAGE_TITLE_CSS, expectedTitle);
    }

    @Test(groups = "tools", dataProvider = "dataProvider", description = "Test to validate the total number of displayed tools")
    public void verifyTotalNumberOfItemsOnPage(String totalItems) {
        homepage.navigateToWelcomeToRapalaPopUp()
                .clickOnAcceptAllCookiesButton()
                .navigateToToolsPage()
                .verifyTotalNumberOfItemsAvailable(ToolsPageLocators.ALL_DISPLAYED_ITEMS_CSS, totalItems);
    }

    @Test(groups = "tools", dataProvider = "dataProvider", description = "Test to validate the total number of displayed tools")
    public void verifyTotalNumberOfItemsOnPageV2(String totalItems) {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(WelcomeToRapalaPopUpLocators.ACCEPT_ALL_COOKIES_BUTTON_X);
        sel.selClickBy(HomePageLocators.TOOLS_BUTTON_X);
        int totalItemsOnPage = sel.findTotalElementCount(ToolsPageLocators.ALL_DISPLAYED_ITEMS_CSS);
        Assert.assertTrue(totalItemsOnPage >= Integer.parseInt(totalItems), "expected number of items not returned*");
    }

}

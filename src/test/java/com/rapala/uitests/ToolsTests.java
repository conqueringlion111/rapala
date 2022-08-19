package com.rapala.uitests;

import com.rapala.locators.CommonLocators;
import com.rapala.locators.HomePageLocators;
import com.rapala.locators.WelcomeToRapalaPopUpLocators;
import com.rapala.testbase.TestBase;
import com.rapala.utils.SeleniumMethods;
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
}

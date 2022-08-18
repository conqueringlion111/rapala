package com.rapala.uitests;

import com.rapala.locators.HomePageLocators;
import com.rapala.locators.PerchLuresPageLocators;
import com.rapala.locators.WelcomeToRapalaPopUpLocators;
import com.rapala.testbase.TestBase;
import com.rapala.utils.SeleniumMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PerchLuresTests extends TestBase {

    @Test(groups = "lures", dataProvider = "dataProvider", description = "Test to validate user can navigate to Perch Lures Page")
    public void verifyNavigationToPerchLuresPageSuccessful(String expectedTitle) {
        homepage.navigateToWelcomeToRapalaPopUp()
                .clickOnAcceptAllCookiesButton()
                .navigateToPerchLuresPage()
                .verifyPageTitleValue(expectedTitle);
    }

    @Test(groups = "lures", dataProvider = "dataProvider", description = "Test to validate user can navigate to Perch Lures Page")
    public void verifyNavigationToPerchLuresPageSuccessfulV2(String expectedTitle) {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(WelcomeToRapalaPopUpLocators.ACCEPT_ALL_COOKIES_BUTTON_X);
        sel.selClickBy(HomePageLocators.PERCH_LURE_LINK_X);
        String verifyTitleText = sel.getText(PerchLuresPageLocators.PAGE_TITLE_CSS);
        Assert.assertEquals(verifyTitleText, expectedTitle, "the expected title did not display");
    }
}

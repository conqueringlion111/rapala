package com.rapala.uitests;

import com.rapala.testbase.TestBase;
import org.testng.annotations.Test;

public class BlueFoxTests extends TestBase {

    @Test(groups = "bluefox", dataProvider = "dataProvider", description = "Test to validate user can navigate to Blue Fox Page via bottom link")
    public void verifyNavigateToBlueFoxPageViaBottomLinkSuccessful(String expectedTitle) {
        homepage.navigateToWelcomeToRapalaPopUp()
                .clickOnAcceptAllCookiesButton()
                .navigateToBlueFoxPageViaBottomLink()
                .verifyBlueFoxPageContainsExpectedTitleStr(expectedTitle);

    }

    @Test(groups = "bluefox", dataProvider = "dataProvider", description = "Test to validate user can navigate to Blue Fox Page via bottom link")
    public void verifyNavigateToBlueFoxPageViaTopLinkSuccessful(String expectedTitle) {
        homepage.navigateToWelcomeToRapalaPopUp()
                .clickOnAcceptAllCookiesButton()
                .navigateToBlueFoxPageViaTopLink()
                .waitForPageLoadComplete()
                .verifyNavigationToBlueFoxPageSuccessful(expectedTitle);

    }

}

package com.rapala.uitests;

import com.rapala.testbase.TestBase;
import org.testng.annotations.Test;

public class PerchLuresTests extends TestBase {

    @Test(groups = "lures",  description = "Test to validate user can navigate to Perch Lures Page")
    public void verifyNavigationToPerchLuresPageSuccessful() {
        homepage.navigateToWelcomeToRapalaPopUp()
                .clickOnAcceptAllCookiesButton()
                .navigateToPerchLuresPage()
                .verifyPageTitleValue("PERCH LURES");
    }
}

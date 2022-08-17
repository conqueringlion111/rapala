package com.rapala.pages;

import com.rapala.locators.HomePageLocators;
import com.rapala.pagebase.PageBase;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WelcomeToRapalaPopUp navigateToWelcomeToRapalaPopUp() {
        return new WelcomeToRapalaPopUp(driver);
    }

    public PerchLuresPage navigateToPerchLuresPage() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.PERCH_LURE_LINK_X);
        return new PerchLuresPage(driver);
    }

}

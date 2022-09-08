package com.rapala.pages;

import com.rapala.locators.WelcomeToRapalaPopUpLocators;
import com.rapala.pagebase.PageBase;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class WelcomeToRapalaPopUp extends PageBase {

    public WelcomeToRapalaPopUp(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public HomePage clickOnAcceptAllCookiesButton() {
        sel.selClickBy(WelcomeToRapalaPopUpLocators.ACCEPT_ALL_COOKIES_BUTTON_X);
        return new HomePage(driver);
    }
}

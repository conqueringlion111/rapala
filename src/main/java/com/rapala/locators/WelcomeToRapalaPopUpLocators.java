package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomeToRapalaPopUpLocators extends PageBase {

    public WelcomeToRapalaPopUpLocators(WebDriver driver) {
        super(driver);
    }

    public static final By ACCEPT_ALL_COOKIES_BUTTON_X = By.xpath("//button[@id='onetrust-accept-btn-handler']");

}

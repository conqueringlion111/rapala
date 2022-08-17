package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPageLocators extends PageBase {

    public MyAccountPageLocators(WebDriver driver) {
        super(driver);
    }

    public static final By LOG_OUT_LINK_X = By.xpath("//span[contains(text(), 'Log out')]");

}

package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerchLuresPageLocators extends PageBase {

    public PerchLuresPageLocators(WebDriver driver) {
        super(driver);
    }

    public static final By PAGE_TITLE_CSS = By.cssSelector("h1.title");
}

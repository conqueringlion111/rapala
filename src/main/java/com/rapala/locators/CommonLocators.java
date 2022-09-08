package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonLocators {

    public static final By LOGOUT_BUTTON_X = By.xpath("//p[contains(text(), 'Logout')]");
    public static final By PAGE_TITLE_CSS = By.cssSelector("h1.title");
}

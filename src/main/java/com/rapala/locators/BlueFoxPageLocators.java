package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlueFoxPageLocators extends PageBase {
    public BlueFoxPageLocators(WebDriver driver) {
        super(driver);
    }

    public static final By BLUE_FOX_PAGE_SECONDARY_NAV = By.xpath("//div[@class='o-header-secondary-nav']");
    public static final By BLUE_FOX_PAGE_IMAGE = By.xpath("//a[@class='a-logo Blue Fox']");
    public static final By SPINNERS_LINK_TOP_X = By.xpath("//nav[@class='secondary-nav-items']//span[contains(text(),'Spinners')]");

}

package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLocators extends PageBase {

    public HomePageLocators(WebDriver driver) {
        super(driver);
    }

    public static final By PERCH_LURE_LINK_X = By.xpath("(//div[@class='sf-carousel']//a[@title='Perch Lures'])[2]");
}

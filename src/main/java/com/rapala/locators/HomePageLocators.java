package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLocators extends PageBase {

    public HomePageLocators(WebDriver driver) {
        super(driver);
    }

    public static final By PERCH_LURE_LINK_X = By.xpath("(//div[@class='sf-carousel']//a[@title='Perch Lures'])[2]");
    public static final By TOOLS_BUTTON_X = By.xpath("//span[@class='category-name'][contains(text(),'Tools')]");
    public static final By CLOTHING_BUTTON_X = By.xpath("//span[@class='category-name'][contains(text(),'Clothing')]");
    public static final By BAGS_BUTTON_X = By.xpath("//span[@class='category-name'][contains(text(),'Bags')]");
    public static final By ICE_BUTTON_X = By.xpath("//span[@class='category-name'][contains(text(),'Ice')]");
    public static final By NEW_ARRIVALS_BUTTON_X = By.xpath("//span[@class='category-name'][contains(text(),'New Arrivals')]");
    public static final By BLUE_FOX_LINK_TOP_X = By.xpath("//a[@href='/eu_en/blue-fox']");
    public static final By BLUE_FOX_LINK_BOTTOM_X = By.xpath("(//a[contains(@title,'Vibrax')])[2]");
}

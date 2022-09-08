package com.rapala.locators;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsPageLocators {
    public static final By ALL_DISPLAYED_ITEMS_CSS = By.cssSelector("div.products div.products__grid > div");
    public static final By ALL_DISPLAYED_ITEMS_X = By.xpath("//div[@class='products']//div[@class='products__grid']/div");

}

package com.rapala.pages;

import com.rapala.locators.HomePageLocators;
import com.rapala.pagebase.PageBase;
import com.rapala.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public WelcomeToRapalaPopUp navigateToWelcomeToRapalaPopUp() {
        return new WelcomeToRapalaPopUp(driver);
    }

    public PerchLuresPage navigateToPerchLuresPage() {
        sel.selClickBy(HomePageLocators.PERCH_LURE_LINK_X);
        return new PerchLuresPage(driver);
    }

    public ToolsPage navigateToToolsPage() {
        sel.selClickBy(HomePageLocators.TOOLS_BUTTON_X);
        return new ToolsPage(driver);
    }

    public BlueFoxPage navigateToBlueFoxPageViaBottomLink() {
        sel.jsScroll(HomePageLocators.BLUE_FOX_LINK_BOTTOM_X);
        sel.clickBy(HomePageLocators.BLUE_FOX_LINK_BOTTOM_X);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new BlueFoxPage(driver);
    }

    public BlueFoxPage navigateToBlueFoxPageViaTopLink() {
        sel.actionsMoveToElementBy(HomePageLocators.BLUE_FOX_LINK_TOP_X);
        sel.selClickBy(HomePageLocators.BLUE_FOX_LINK_TOP_X);
        return new BlueFoxPage(driver);
    }

}

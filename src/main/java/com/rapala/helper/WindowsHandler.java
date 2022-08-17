package com.rapala.helper;

import com.rapala.pagebase.PageBase;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;

public class WindowsHandler extends PageBase {

    public WindowsHandler(WebDriver driver) {
        super(driver);
    }

    public void switchToNewWindow() throws InterruptedException {
        Iterator<String> wh = driver.getWindowHandles().iterator();
        String mainWinow = wh.next();
        String newWinow = wh.next();
        driver.switchTo().window(newWinow);
    }

    public void switchToMainWindow() throws InterruptedException {
        Iterator<String> wh = driver.getWindowHandles().iterator();
        String mainWin = wh.next();
        driver.switchTo().window(mainWin);
    }

}

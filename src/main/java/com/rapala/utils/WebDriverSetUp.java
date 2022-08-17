package com.rapala.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverSetUp {

    public static WebDriver createDriver(String browser, String runFromSuite, String browserRemote)
            throws MalformedURLException, InstantiationException, IllegalAccessException {
        String osName = System.getProperty("os.name");
        WebDriver driver = null;
        if (osName.contains("Windows")) {
            if (runFromSuite.equalsIgnoreCase("true")) {
                if (browserRemote.equalsIgnoreCase("chromeRemote")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--window-size=1560,1070");
                    options.addArguments("enable-automation");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--dns-prefetch-disable");
                    options.addArguments("--disable-gpu");
                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new ChromeDriver(options);

                } else if (browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1560,1070");
                    options.addArguments("enable-automation");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--dns-prefetch-disable");
                    options.addArguments("--disable-gpu");
                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new ChromeDriver(options);
                }
                else if (browserRemote.equalsIgnoreCase("firefoxRemote")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--window-size=1560,1070");
                    driver = new FirefoxDriver(options);
                }
                else if (browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new FirefoxDriver(options);
                }

                else if (browserRemote.equalsIgnoreCase("edgeRemote")) {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    driver = new EdgeDriver();
                }

                else if (browserRemote.equalsIgnoreCase("chromeGalaxyS5Headless")) {
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", "Galaxy S5");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                }

                else {
                    throw new InvalidParameterException(
                            browserRemote + "- is not a valid web browser for remote driver.");
                }
            }

            else {
                if (browser.equalsIgnoreCase("Firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("FireFoxHeadless")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new FirefoxDriver(options);
                }

                else if (browser.equalsIgnoreCase("Chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-infobars");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("ChromeHeadless")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new ChromeDriver(options);
                }

                else if (browser.equalsIgnoreCase("chromeGalaxyS5")) {
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", "Galaxy S5");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    driver = new ChromeDriver(options);
                }

                else if (browser.equalsIgnoreCase("IE")) {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("Edge")) {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }

                else {
                    throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
                }
            }

        }

        if (osName.contains("Mac")) {
            if (runFromSuite.equalsIgnoreCase("true")) {
                if (browserRemote.equalsIgnoreCase("chromeRemote")) {
                    System.out.println("Opening Chrome Driver");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--window-size=1560,1070");
                    driver = new ChromeDriver(options);
                }

                else if (browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new ChromeDriver(options);
                }

                else if (browserRemote.equalsIgnoreCase("firefoxRemote")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--window-size=1560,1070");
                    driver = new FirefoxDriver(options);
                }

                else if (browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new FirefoxDriver(options);

                } else {
                    throw new InvalidParameterException(
                            browserRemote + "- is not a valid web browser for remote driver.");
                }
            }
            else {
                if (browser.equalsIgnoreCase("Firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--window-size=1560,1070");
                    driver = new FirefoxDriver(options);
                }
                else if (browser.equalsIgnoreCase("firefoxHeadless")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new FirefoxDriver(options);
                }
                else if (browser.equalsIgnoreCase("Chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-infobars");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }
                else if (browser.equalsIgnoreCase("ChromeHeadless")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1840,990");
                    driver = new ChromeDriver(options);
                }
                else if (browser.equalsIgnoreCase("chromeGalaxyS5")) {
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", "Galaxy S5");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    driver = new ChromeDriver(options);
                }

                else if (browser.equalsIgnoreCase("chromeGalaxyS5headless")) {
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", "Galaxy S5");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                } else {
                    throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
                }
            }
        }
        if (osName.contains("Linux")) {
            if (runFromSuite.equalsIgnoreCase("true")) {
                if (browserRemote.equalsIgnoreCase("chromeRemote")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }

                else if (browserRemote.equalsIgnoreCase("chromeRemoteHeadless")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("firefoxRemote")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }

                else if (browserRemote.equalsIgnoreCase("firefoxRemoteHeadless")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    driver = new FirefoxDriver(options);
                    driver.manage().window().maximize();
                }

                else {
                    throw new InvalidParameterException(
                            browserRemote + "- is not a valid web browser for remote driver.");
                }
            }
            else {
                if (browser.equalsIgnoreCase("Firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("firefoxHeadless")) {
                    System.out.println("Opening Gecko Driver Headless");
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    driver = new FirefoxDriver(options);
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("Chrome")) {
                    System.out.println("Opening Chrome Driver");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("ChromeHeadless")) {
                    System.out.println("Opening Chrome Driver Headless");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("disable-infobars");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("IE")) {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                }

                else if (browser.equalsIgnoreCase("Edge")) {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }

                else {
                    throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
                }
            }

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        driver.quit();
    }

}

package com.rapala.testbase;

import com.rapala.pages.HomePage;
import com.rapala.utils.JsonReader;
import com.rapala.utils.WebDriverSetUp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Properties;

public class TestBase {

    protected WebDriver driver;
    protected HomePage homepage;
    protected static Properties testConfig;
    protected String baseUrl;
    protected String email;
    protected String password;
    protected String myPassword;
    @BeforeSuite(alwaysRun = true)
    public void beforSuite() throws IOException {
        testConfig = new Properties();
        testConfig.load(new FileInputStream("TestConfig.properties"));
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserRemote"})
    public void beforeMethod(@Optional String browserRemote) throws MalformedURLException, InstantiationException, IllegalAccessException
    {
        driver = WebDriverSetUp.createDriver(testConfig.getProperty("browser"), testConfig.getProperty("runFromSuite"), browserRemote);
        if(System.getProperty("test.env") != null) {
            baseUrl = System.getProperty("test.env");
        }
        else {
            baseUrl = testConfig.getProperty("baseUrl");
        }
        if(System.getProperty("email") != null) {
            email = System.getProperty("email");
        }
        else {
            email = testConfig.getProperty("email");
        }
        if(System.getProperty("password") != null) {
            password = System.getProperty("password");
        }
        else {
            password = testConfig.getProperty("password");
        }
        if(System.getProperty("myPassword") != null) {
            myPassword = System.getProperty("myPassword");
        }
        else {
            myPassword = testConfig.getProperty("myPassword");
        }
        driver.get(baseUrl);
        homepage = new HomePage(driver);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] passData(Method method) throws IOException, ParseException
    {
        testConfig = new Properties();
        testConfig.load(new FileInputStream("TestConfig.properties"));
        String name = getClass().getName();
        String fileName = name.substring(name.lastIndexOf(".") + 1).trim();
        return JsonReader.getdata(testConfig.getProperty("dataLocation").concat(fileName).concat(".json"), method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception
    {
        if(ITestResult.FAILURE==result.getStatus()) {
            try{
                TakesScreenshot screenshot = (TakesScreenshot)driver;
                File srs = screenshot.getScreenshotAs(OutputType.FILE);
                String osName = System.getProperty("os.name");
                System.out.println(System.getProperty("os.name"));
                if(osName.contains("Windows")) {
                    FileUtils.copyFile(srs, new File(".\\printscreen\\failureprintscreen"+result.getName()+".png"));
                }
                else {
                    FileUtils.copyFile(srs, new File("printscreen/failureprintscreen"+result.getName()+".png"));
                }
                System.out.println("Successfully captured a screenshot");
            }catch (Exception e){
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        WebDriverSetUp.quitDriver(driver);
    }

}

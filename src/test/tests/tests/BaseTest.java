package tests;

import driver.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import java.io.File;


public class BaseTest {

    protected static String enviroment;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite
    @Parameters({"env"})
    public void init(@Optional("https://google.com") String env) {
        enviroment = env;
        Driver.initDriverFactory();
    }

    @BeforeMethod
    @Parameters({"browser", "width", "height"})
    public void openBrowser(@Optional("firefox") String browser, @Optional("1980") String width, @Optional("1200") String height) {
        driver.set(Driver.getDriver(browser));
        driver.get().manage().window().setSize(new Dimension(Integer.valueOf(width), Integer.valueOf(height)));
        driver.get().manage().deleteAllCookies();
        driver.get().get(enviroment);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowserInstances() {
        Driver.closeDriverInstances();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver.get();
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}

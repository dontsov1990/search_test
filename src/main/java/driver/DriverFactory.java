package driver;

import org.openqa.selenium.WebDriver;

class DriverFactory {

    private WebDriver driver;
    private DriverType driverType;

    WebDriver getDriver(String name) {
        if (null == driver) {
            getDriverType(name);
            initWebDriver();
        }
        return driver;
    }

    void closeDriver() {
        if (null != driver)
            driver.quit();
    }

    private void getDriverType(String name) {
        switch (name) {
            case "firefox":
                driverType = DriverType.FIREFOX;
                break;
            case "chrome":
                driverType = DriverType.CHROME;
                break;
            default:
                driverType = DriverType.FIREFOX;
        }
    }

    private void initWebDriver() {
        driver = driverType.getInstance();
        driverType.setCapabilities();
    }
}
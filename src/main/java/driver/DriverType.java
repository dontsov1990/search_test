package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public enum DriverType implements DriverSetup {

    FIREFOX {

        public void setCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
        }

        public WebDriver getInstance() {
            System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
            return new FirefoxDriver();
        }
    },

    CHROME {

        public void setCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        }

        public WebDriver getInstance() {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
            return new ChromeDriver();
        }
    }

}
package driver;

import org.openqa.selenium.WebDriver;


public interface DriverSetup {

    WebDriver getInstance();

    void setCapabilities();
}

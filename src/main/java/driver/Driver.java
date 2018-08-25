package driver;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;

    public static void initDriverFactory() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    public static WebDriver getDriver(String name) {
        return driverFactory.get().getDriver(name);
    }

    public static void closeDriverInstances() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.closeDriver();
        }
    }
}

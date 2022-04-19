package utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.Base.APP_PATH;

public class Driver {

    private static IOSDriver driver;

    private Driver() {
    }

    public static IOSDriver capabilities() throws MalformedURLException {

        File app = new File(APP_PATH);

        if (driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
            cap.setCapability("commandTimeouts", "12000");
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        }
        return driver;
    }
}

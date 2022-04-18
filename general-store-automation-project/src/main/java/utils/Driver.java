package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static utils.Path.CD_PATH;

public class Driver {

    private static AndroidDriver<AndroidElement> driver;

    private Driver() {
    }

    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {

        File app = new File("src", "General-Store.apk");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        if (driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            if (device.equals("real")) {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            } else if (device.equals("emulator")) {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
            } else if (device.equals("hybrid")) {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
                cap.setCapability("chromedriverExecutable", CD_PATH);
            }
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

            driver = new AndroidDriver<>(url, cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void contextSwitch(int context) {
        if (driver != null) {
            Set<String> contextNames = driver.getContextHandles();
            driver.context((String) contextNames.toArray()[context]);
        }
    }

}

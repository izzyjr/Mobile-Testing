package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {

        File app = new File("src", "ApiDemos-debug.apk");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities cap = new DesiredCapabilities();
        if (device.equals("real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        } else if (device.equals("emulator")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
        }
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "uiautomator2");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

}

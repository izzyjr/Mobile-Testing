import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Base{

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");

        // Touch Action - Tap
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(expandList))).perform();
    }
}

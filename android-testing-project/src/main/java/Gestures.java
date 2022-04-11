import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertTrue;

public class Gestures extends Base{

    @Test
    private void isSampleMenuDisplayed() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();

        // Touch Action - Tap
        TouchAction t = new TouchAction(driver);

        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        t.tap(tapOptions().withElement(element(views))).perform();

        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(tapOptions().withElement(element(expandList))).perform();

        WebElement customAdapter = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        t.tap(tapOptions().withElement(element(customAdapter))).perform();

        // Touch Action - Long Press
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        t.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();

        //Assert True
        assertTrue(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
    }
}

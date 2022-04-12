import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertTrue;

public class Gestures extends Base{

    private AndroidDriver<AndroidElement> driver;
    private TouchAction t;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities();
        t = new TouchAction(driver);
    }

    @Test
    private void isSampleMenuDisplayed() throws MalformedURLException {

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

    @Test
    private void swipeDemo() throws MalformedURLException {

        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        t.tap(tapOptions().withElement(element(views))).perform();

        WebElement dateWidgets = driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
        t.tap(tapOptions().withElement(element(dateWidgets))).perform();

        WebElement inline = driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']");
        t.tap(tapOptions().withElement(element(inline))).perform();

        WebElement number9 = driver.findElementByXPath("//*[@content-desc='9']");
        t.tap(tapOptions().withElement(element(number9))).perform();

        // Touch Action - Swipe
        // Long press on element, move to another element and then release
        WebElement number15 = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement number45 = driver.findElementByXPath("//*[@content-desc='45']");
        t.longPress(longPressOptions().withElement(element(number15)).withDuration(ofSeconds(2)))
                .moveTo(element(number45)).release().perform();

        //Assert True
        assertTrue(number45.isSelected());
    }
}

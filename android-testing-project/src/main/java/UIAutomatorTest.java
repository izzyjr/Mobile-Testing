import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;

public class UIAutomatorTest extends Base {

    @Test
    private void validateNumberOfClickableElements() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();

        // By AndroidUIAutomator - attribute('value')
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        // Validate clickable feature for all options
        assertEquals(0, driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
    }

}

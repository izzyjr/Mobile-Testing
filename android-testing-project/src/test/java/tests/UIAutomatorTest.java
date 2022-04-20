package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiDemosDebugPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static utils.Driver.capabilities;

public class UIAutomatorTest {

    private AndroidDriver<AndroidElement> driver;
    private ApiDemosDebugPage apiDemosDebugPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities("emulator");
        apiDemosDebugPage = new ApiDemosDebugPage(driver);
    }

    @Test
    private void validateNumberOfClickableElements() throws MalformedURLException {

        // By AndroidUIAutomator - attribute('value')
        apiDemosDebugPage.clickOnViews();

        // Validate clickable feature for all options
        assertEquals(0, apiDemosDebugPage.findClickableElements());
    }

}

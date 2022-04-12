package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiDemosDebugPage;
import utils.Base;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;

public class UIAutomatorTest extends Base {

    private AndroidDriver<AndroidElement> driver;
    private ApiDemosDebugPage apiDemosDebugPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities();
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

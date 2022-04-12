package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiDemosDebugPage;
import utils.Base;

import java.net.MalformedURLException;

public class Basics extends Base {

    private AndroidDriver<AndroidElement> driver;
    private ApiDemosDebugPage apiDemosDebugPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities();
        apiDemosDebugPage = new ApiDemosDebugPage(driver);
    }

    @Test
    public void basics() {
        // Click Element
        apiDemosDebugPage.clickOnPreference();
        apiDemosDebugPage.clickOnPreferenceDependencies();
        apiDemosDebugPage.clickOnWifiCheckbox();
        apiDemosDebugPage.clickOnWifiSettings();

        // Enter Text
        apiDemosDebugPage.inputTextInEditText("Testing");

        // Click OK
        apiDemosDebugPage.selectButton(1);
    }
}

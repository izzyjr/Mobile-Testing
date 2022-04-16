package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiDemosDebugPage;

import java.net.MalformedURLException;

import static utils.Driver.capabilities;

public class Basics {

    private AndroidDriver<AndroidElement> driver;
    private ApiDemosDebugPage apiDemosDebugPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities("real");
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

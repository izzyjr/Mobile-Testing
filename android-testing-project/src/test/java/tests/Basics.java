package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiDemosDebugPage;

import java.net.MalformedURLException;

import static utils.Driver.capabilities;
import static utils.Driver.closeDriver;

public class Basics {

    private AndroidDriver<AndroidElement> driver;
    private ApiDemosDebugPage apiDemosDebugPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities("real");
        apiDemosDebugPage = new ApiDemosDebugPage(driver);
    }

    @Test
    private void basics() {
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

    @AfterClass
    private void cleanUp() {
        closeDriver();
    }
}

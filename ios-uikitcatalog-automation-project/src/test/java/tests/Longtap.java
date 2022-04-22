package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LongtapPage;
import static org.testng.Assert.assertFalse;
import java.net.MalformedURLException;

import static utils.Driver.closeDriver;
import static utils.Driver.longtapAppCapabilities;

public class Longtap {

    private IOSDriver driver;
    private IOSTouchAction t;
    private LongtapPage longtapPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = longtapAppCapabilities();
        t = new IOSTouchAction(driver);
        longtapPage = new LongtapPage(driver, t);
    }

    @Test
    private void longPressDemo() {
        longtapPage.longPressOnLongTapButton();
        longtapPage.tapOnNameSwitchToggleValue();
        longtapPage.tapOnEmailSwitchToggleValue();
        assertFalse(longtapPage.getNameSwitchToggleValue());
        assertFalse(longtapPage.getEmailSwitchToggleValue());
    }

    @AfterClass
    private void cleanUp() {
        closeDriver();
    }
}

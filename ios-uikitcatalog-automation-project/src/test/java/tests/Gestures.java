package tests;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UIKitCatalogPage;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import static utils.Driver.closeDriver;
import static utils.Driver.uiKitCatalogCapabilities;

public class Gestures {

    private IOSDriver driver;
    private UIKitCatalogPage uiKitCatalogPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = uiKitCatalogCapabilities();
        uiKitCatalogPage = new UIKitCatalogPage(driver);
    }

    @Test
    private void scrollDemo() {
        uiKitCatalogPage.scrollToAndClickWebView();
        assertTrue(uiKitCatalogPage.isTextDisplayed());
    }

    @Test
    private void wheelPickerDemo() {
        uiKitCatalogPage.clickOnPickerView();
        uiKitCatalogPage.selectValuesFromWheelPicker(5, 25, 75);
        assertEquals(5, uiKitCatalogPage.getWheelAValue());
        assertEquals(25, uiKitCatalogPage.getWheelBValue());
        assertEquals(75, uiKitCatalogPage.getWheelCValue());
    }

    @Test
    private void slidersDemo() {
        uiKitCatalogPage.clickOnSliders();
        assertEquals(uiKitCatalogPage.setDefaultSliderValue("0.50%"), "50%");
    }

    @AfterClass
    private void cleanUp() {
        closeDriver();
    }
}

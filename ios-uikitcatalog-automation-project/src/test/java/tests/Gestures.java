package tests;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UIKitCatalogPage;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import static utils.Driver.capabilities;

public class Gestures {

    private IOSDriver driver;
    private UIKitCatalogPage uiKitCatalogPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities();
        uiKitCatalogPage = new UIKitCatalogPage(driver);
    }

    @Test
    private void scrollDemo() {
        uiKitCatalogPage.scrollToAndClickWebView();
        assertTrue(uiKitCatalogPage.isTextDisplayed());
    }

}

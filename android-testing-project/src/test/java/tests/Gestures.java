package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiDemosDebugPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;
import static utils.Driver.capabilities;
import static utils.Driver.closeDriver;

public class Gestures {

    private AndroidDriver<AndroidElement> driver;
    private ApiDemosDebugPage apiDemosDebugPage;
    private TouchAction t;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities("real");
        t = new TouchAction(driver);
        apiDemosDebugPage = new ApiDemosDebugPage(driver, t);
    }

    @Test
    private void isSampleMenuDisplayed() throws MalformedURLException {

        // Touch Action - Tap
        apiDemosDebugPage.tapOnViews();
        apiDemosDebugPage.tapOnExpandList();
        apiDemosDebugPage.tapOnCustomAdapter();

        // Touch Action - Long Press
        apiDemosDebugPage.longPressPeopleNames();

        //Assert True
        assertTrue(apiDemosDebugPage.isSampleMenuDisplayed());
    }

    @Test
    private void swipeDemo() throws MalformedURLException {

        apiDemosDebugPage.tapOnViews();
        apiDemosDebugPage.tapOnDateWidgets();
        apiDemosDebugPage.tapOnInline();
        apiDemosDebugPage.tapOnNumber9();

        // Touch Action - Swipe
        // Long press on element, move to another element and then release
        apiDemosDebugPage.longPressThanMove();

        //Assert True
        assertTrue(apiDemosDebugPage.isNumber45Selected());
    }

    @Test
    private void scrollDemo() throws MalformedURLException {

        apiDemosDebugPage.tapOnViews();

        // Scroll down to WebView3 and Assert True
        assertTrue(apiDemosDebugPage.isWebView3Displayed());
    }

    @Test
    private void dragAndDropDemo() throws MalformedURLException {

        apiDemosDebugPage.tapOnViews();
        apiDemosDebugPage.tapOnDragAndDrop();

        // Drag and drop
        apiDemosDebugPage.longPressAndDrag();
    }

    @AfterClass
    private void cleanUp() {
        closeDriver();
    }
}

package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MobileChromeBrowserPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;
import static utils.Driver.mobileChromeCapabilities;

public class mobileChromeBrowser {

    private AndroidDriver<AndroidElement> driver;
    private MobileChromeBrowserPage mobileChromeBrowserPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = mobileChromeCapabilities();
        mobileChromeBrowserPage = new MobileChromeBrowserPage(driver);
    }

    @Test
    private void testingAppFromMobileChromeBrowser() {
        mobileChromeBrowserPage.getWebUrl();
        mobileChromeBrowserPage.selectAppHamburgerMenu();
        mobileChromeBrowserPage.selectProducts();
        mobileChromeBrowserPage.scrollToDevopsAndClick();
        assertTrue(mobileChromeBrowserPage.isDevopsCourseTitleDisplayed());
    }

}

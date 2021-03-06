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

public class Basics {

    private IOSDriver driver;
    private UIKitCatalogPage uiKitCatalogPage;
    private static final String DESCRIPTION = "A message should be a short, complete sentence.";

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = uiKitCatalogCapabilities();
        uiKitCatalogPage = new UIKitCatalogPage(driver);
    }

    @Test
    private void basicCommands() throws InterruptedException {
        uiKitCatalogPage.clickOnAlertViews();
        uiKitCatalogPage.clickOnTextEntry();

        Thread.sleep(5000);
        assertTrue(uiKitCatalogPage.isTextInputDescriptionMessageDisplayed());

        uiKitCatalogPage.typeIntoTextInput("Synthesizer");
        uiKitCatalogPage.clickOKButton();
        uiKitCatalogPage.clickOnConfirmCancel();

        assertEquals(DESCRIPTION, uiKitCatalogPage.getDescriptionText());

        uiKitCatalogPage.clickCancel();
    }

    @AfterClass
    private void cleanUp() {
        closeDriver();
    }
}

package tests;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;

import static utils.Driver.capabilities;

public class Basics {

    private IOSDriver driver;
    private UIKitCatalogPage uiKitCatalogPage;
    private static final String DESCRIPTION = "A message should be a short, complete sentence.";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities();
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

}

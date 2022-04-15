package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Base;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;

public class LoginForm extends Base {

    private AndroidDriver<AndroidElement> driver;
    private LoginPage generalStorePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities("emulator");
        generalStorePage = new LoginPage(driver);
    }

    @Test
    private void completeLoginFormToasterError() {
        generalStorePage.selectFemale();
        generalStorePage.clickOnCountryDropdown();
        generalStorePage.clickOnArgentina();
        generalStorePage.clickOnLetsShopButton();
        assertEquals(generalStorePage.toasterError() ,"Please enter your name");
    }

    @Test(priority = 1)
    private void completeLoginForm() {
        generalStorePage.inputName("Jane Jane");
        generalStorePage.hideKeyboard();
        generalStorePage.selectFemale();
        generalStorePage.clickOnCountryDropdown();
        generalStorePage.clickOnArgentina();
        generalStorePage.clickOnLetsShopButton();
        assertTrue(generalStorePage.isProductsHeaderDisplayed());
    }

}

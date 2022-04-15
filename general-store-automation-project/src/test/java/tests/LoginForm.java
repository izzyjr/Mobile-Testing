package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GeneralStorePage;
import utils.Base;

import java.net.MalformedURLException;

public class LoginForm extends Base {

    private AndroidDriver<AndroidElement> driver;
    private GeneralStorePage generalStorePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities("emulator");
        generalStorePage = new GeneralStorePage(driver);
    }

    @Test
    private void completeLoginForm() {
        generalStorePage.inputName("Jane Jane");
        generalStorePage.hideKeyboard();
        generalStorePage.selectFemale();
        generalStorePage.clickOnCountryDropdown();
        generalStorePage.clickOnArgentina();
        generalStorePage.clickOnLetsShopButton();
    }

}

package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static utils.Driver.capabilities;

import java.net.MalformedURLException;

public class LoginForm {

    private AndroidDriver<AndroidElement> driver;
    private LoginPage loginPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities("emulator");
        loginPage = new LoginPage(driver);
    }

    @Test
    private void completeLoginFormToasterError() {
        loginPage.selectFemale();
        loginPage.clickOnCountryDropdown();
        loginPage.clickOnArgentina();
        loginPage.clickOnLetsShopButton();
        assertEquals(loginPage.toasterError() ,"Please enter your name");
    }

    @Test(priority = 1)
    private void completeLoginForm() {
        loginPage.inputName("Jane Jane");
        loginPage.hideKeyboard();
        loginPage.selectFemale();
        loginPage.clickOnCountryDropdown();
        loginPage.clickOnArgentina();
        loginPage.clickOnLetsShopButton();
        assertTrue(loginPage.isProductsHeaderDisplayed());
    }

}

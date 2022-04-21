package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.WebViewPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import static pages.Product.*;
import static utils.Driver.*;

public class Cart {

    private AndroidDriver<AndroidElement> driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private TouchAction t;
    private WebViewPage webViewPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities("hybrid");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        t = new TouchAction(driver);
        cartPage = new CartPage(driver, t);
        webViewPage = new WebViewPage(driver);
    }

    @Test()
    private void totalAmountMatchesSumOfProducts() {
        loginPage.goToProductsPage();
        productPage.addProductToCart(NIKE_SFB_JUNGLE);
        productPage.addProductToCart(AIR_JORDAN_1_MID_SE);
        productPage.addProductToCart(JORDAN_LIFT_OFF);
        productPage.addProductToCart(CONVERSE_ALL_STAR);
        productPage.clickOnCartButton();
        assertEquals(cartPage.getTotalAmountFromCartPage(), productPage.allProductsAddedPrice());
    }

    @Test(priority = 1)
    private void validateTermsOfConditionsMessage() {
        cartPage.longPressTermsOfConditions();
        assertTrue(cartPage.isTermsOfConditionsTitleDisplayed());
    }

    @Test(priority = 2)
    private void nativeAppToWebViewAndBack() throws InterruptedException {
        cartPage.tapOnCloseButton();
        cartPage.tapOnEmailDiscountCheckbox();
        cartPage.tapOnProceedToWebViewButton();
        Thread.sleep(5000);

        // switch context to WebView
        contextSwitch(1);
        webViewPage.search("Synthesizer");

        // switch back to app
        webViewPage.backToApp();
        Thread.sleep(5000);

        contextSwitch(0);
        assertTrue(loginPage.isAppTitleDisplayed());
    }

    @AfterClass
    private void cleanUp() {
        closeDriver();
    }
}

package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import static pages.Product.*;
import static utils.Driver.capabilities;

public class Cart {

    private AndroidDriver<AndroidElement> driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeClass
    private void setUp() throws MalformedURLException {
        driver = capabilities("emulator");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
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
}

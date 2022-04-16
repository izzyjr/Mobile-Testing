package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.Product.NIKE_SFB_JUNGLE;
import static utils.Driver.capabilities;

public class Products {

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

    @Test
    private void findAndAddProductToCart() {
        loginPage.goToProductsPage();
        productPage.addProductToCart(NIKE_SFB_JUNGLE);
        assertTrue(productPage.isCartCounterAt(1));
    }

    @Test(priority = 1)
    private void isCorrectProductInCart() {
        String productNameInProductsPage = productPage.getNikeJungleText();
        productPage.clickOnCartButton();
        assertEquals(productNameInProductsPage, cartPage.getNikeSFBJungleText());
    }
}

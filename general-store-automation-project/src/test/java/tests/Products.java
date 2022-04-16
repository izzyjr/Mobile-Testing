package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
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
        productPage.addNikeJungleToCart();
        assertTrue(productPage.isCartCounterAt(1));
    }

    @Test
    private void isCorrectProductInCart() {
        loginPage.goToProductsPage();
        productPage.addNikeJungleToCart();
        String productNameInProductsPage = productPage.getNikeJungleText();
        productPage.clickOnCartButton();
        assertEquals(productNameInProductsPage, cartPage.getNikeSFBJungleText());
    }

}

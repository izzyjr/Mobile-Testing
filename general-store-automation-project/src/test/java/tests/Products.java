package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;
import static utils.Driver.capabilities;

public class Products {

    private AndroidDriver<AndroidElement> driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = capabilities("emulator");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void findAndAddProductToCart() {
        loginPage.goToProductsPage();
        productPage.addNikeJungleToCart();
        assertTrue(productPage.isCartCounterAt(1));
    }

}

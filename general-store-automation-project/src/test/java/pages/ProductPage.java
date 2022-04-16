package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class ProductPage {

    AndroidDriver<AndroidElement> driver;
    TouchAction touchAction;
    public static double priceTotal;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()" +
            ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
            ".scrollIntoView(new UiSelector().textMatches(\"Nike SFB Jungle\")" +
            ".instance(0))")
    static AndroidElement scrollToNikeSFBJungle;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()" +
            ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
            ".scrollIntoView(new UiSelector().textMatches(\"Converse All Star\")" +
            ".instance(0))")
    static AndroidElement scrollToConverseAllStar;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()" +
            ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
            ".scrollIntoView(new UiSelector().textMatches(\"Jordan Lift Off\")" +
            ".instance(0))")
    static AndroidElement scrollToJordanLiftOff;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()" +
            ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
            ".scrollIntoView(new UiSelector().textMatches(\"Air Jordan 1 Mid SE\")" +
            ".instance(0))")
    static AndroidElement scrollToAirJordan1Mid1SE;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<AndroidElement> onscreenProducts;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<AndroidElement> onscreenProductAddToCartButtons;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<AndroidElement> onscreenProductPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    private AndroidElement cartCounter;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private AndroidElement cartButton;

    public ProductPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ProductPage(AndroidDriver<AndroidElement> driver, TouchAction touchAction) throws MalformedURLException {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void addProductToCart(Product product) {
        if (product.getProductPageLocator().isDisplayed()) {
            addToPriceTotalAndClickAddToCartButton(onscreenProducts, product.getTitle());
        }
    }

    public boolean isCartCounterAt(int numberOfProducts) {
        return cartCounter.getText().equals(Integer.toString(numberOfProducts));
    }

    private void addToPriceTotalAndClickAddToCartButton(List<AndroidElement> list, String productName) {
        int count = list.size();
        for (int i = 0; i < count; i++) {
            if (list.get(i).getText().equals(productName)) {
                priceTotal += Double.parseDouble(onscreenProductPrice.get(i).getText().replace("$", ""));
                onscreenProductAddToCartButtons.get(i).click();
                break;
            }
        }
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public String getNikeJungleText() {
        return scrollToNikeSFBJungle.getText();
    }

    public double allProductsAddedPrice() {
        double total = priceTotal;
        priceTotal = 0;
        return total;
    }
}

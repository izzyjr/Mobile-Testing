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

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()" +
            ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
            ".scrollIntoView(new UiSelector().textMatches(\"Nike SFB Jungle\")" +
            ".instance(0))")
    private AndroidElement scrollToNikeJungle;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<AndroidElement> onscreenProducts;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<AndroidElement> onscreenProductAddToCartButtons;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    private AndroidElement cartCounter;

    public ProductPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ProductPage(AndroidDriver<AndroidElement> driver, TouchAction touchAction) throws MalformedURLException {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void addNikeJungleToCart() {
        if (scrollToNikeJungle.isDisplayed()) {
            findProductAndClickAddToCartButton(onscreenProducts, scrollToNikeJungle.getText());
        }
    }

    public boolean isCartCounterAt(int numberOfProducts) {
        return cartCounter.getText().equals(Integer.toString(numberOfProducts));
    }

    private void findProductAndClickAddToCartButton(List<AndroidElement> list, String productName) {
        int count = list.size();
        for (int i = 0; i < count; i++) {
            if (list.get(i).getText().equals(productName)) {
                onscreenProductAddToCartButtons.get(i).click();
                break;
            }
        }
    }
}

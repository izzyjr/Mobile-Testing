package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class CartPage {

    AndroidDriver<AndroidElement> driver;
    TouchAction touchAction;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nike SFB Jungle']")
    private AndroidElement nikeSFBJungle;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private AndroidElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private AndroidElement termsOfConditions;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private AndroidElement termsOfConditionsTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CLOSE']")
    private AndroidElement closeButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    private AndroidElement emailDiscountCheckbox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private AndroidElement proceedToWebViewButton;

    public CartPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CartPage(AndroidDriver<AndroidElement> driver, TouchAction touchAction) throws MalformedURLException {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getNikeSFBJungleText() {
        return nikeSFBJungle.getText();
    }

    public double getTotalAmountFromCartPage() {
        return Double.parseDouble(totalAmount.getText().replace("$", ""));
    }

    public void longPressTermsOfConditions() {
        touchAction.longPress(longPressOptions()
                .withElement(element(termsOfConditions))
                .withDuration(ofSeconds(2)))
                .release()
                .perform();
    }

    public boolean isTermsOfConditionsTitleDisplayed() {
        return termsOfConditionsTitle.isDisplayed();
    }

    public void tapOnCloseButton() {
        touchAction.tap(tapOptions()
                .withElement(element(closeButton)))
                .perform();
    }

    public void tapOnEmailDiscountCheckbox() {
        touchAction.tap(tapOptions()
                .withElement(element(emailDiscountCheckbox)))
                .perform();
    }

    public void tapOnProceedToWebViewButton() {
        touchAction.tap(tapOptions()
                .withElement(element(proceedToWebViewButton)))
                .perform();
    }
}

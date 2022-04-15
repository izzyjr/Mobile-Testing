package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage {

    AndroidDriver<AndroidElement> driver;
    TouchAction touchAction;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private AndroidElement nameInputField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private AndroidElement countryDropdown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private AndroidElement femaleRadioButton;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")
    private AndroidElement scrollToArgentina;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private AndroidElement letsShopButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private AndroidElement productsHeader;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    private AndroidElement toasterErrorMessage;

    public LoginPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public LoginPage(AndroidDriver<AndroidElement> driver, TouchAction touchAction) throws MalformedURLException {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void inputName(String name) {
        nameInputField.sendKeys(name);
    }

    public void selectFemale() {
        femaleRadioButton.click();
    }

    public void clickOnCountryDropdown() {
        countryDropdown.click();
    }

    public void clickOnArgentina() {
        scrollToArgentina.click();
    }

    public void clickOnLetsShopButton() {
        letsShopButton.click();
    }

    public boolean isProductsHeaderDisplayed() {
        return productsHeader.isDisplayed();
    }

    public String toasterError() {
        return toasterErrorMessage.getAttribute("name");
    }
}

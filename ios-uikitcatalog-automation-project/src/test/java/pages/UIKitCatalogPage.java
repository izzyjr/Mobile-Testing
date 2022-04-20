package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.HashMap;

public class UIKitCatalogPage {

    private final IOSDriver driver;

    public UIKitCatalogPage(IOSDriver driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private IOSElement alertViewsTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Text Entry']")
    private IOSElement textEntryTab;

    @iOSXCUITFindBy(accessibility = "A message should be a short, complete sentence.")
    private IOSElement textInputDescriptionMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private IOSElement textInput;

    @iOSXCUITFindBy(accessibility = "OK")
    private IOSElement okButton;

    @iOSXCUITFindBy(accessibility = "Confirm / Cancel")
    private IOSElement confirmCancelTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'complete sent')]")
    private IOSElement description;

    @iOSXCUITFindBy(accessibility = "Cancel")
    private IOSElement cancelButton;

    @iOSXCUITFindBy(accessibility = "Web View")
    private IOSElement webViewTab;

    @iOSXCUITFindBy(accessibility = "This is HTML content inside a WKWebView .")
    private IOSElement text;

    @iOSXCUITFindBy(accessibility = "Picker View")
    private IOSElement pickerViewTab;

    @iOSXCUITFindBy(accessibility = "Red color component value")
    private IOSElement wheelA;

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private IOSElement wheelB;

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private IOSElement wheelC;

    @iOSXCUITFindBy(accessibility = "Sliders")
    private IOSElement slidersTab;

    @iOSXCUITFindBy(className = "XCUIElementTypeSlider")
    private IOSElement defaultSlider;

    public void clickOnAlertViews() {
        alertViewsTab.click();
    }

    public void clickOnTextEntry() {
        textEntryTab.click();
    }

    public boolean isTextInputDescriptionMessageDisplayed() {
        return textInputDescriptionMessage.isDisplayed();
    }

    public void typeIntoTextInput(String message) {
        textInput.sendKeys(message);
    }

    public void clickOKButton() {
        okButton.click();
    }

    public void clickOnConfirmCancel() {
        confirmCancelTab.click();
    }

    public String getDescriptionText() {
        return description.getText();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void scrollToAndClickWebView() {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("element", webViewTab);
        scrollObject.put("direction", "down");
        driver.executeScript("mobile:scroll", scrollObject);
        webViewTab.click();
    }

    public boolean isTextDisplayed() {
        return text.isDisplayed();
    }

    public void clickOnPickerView() {
        pickerViewTab.click();
    }

    public void selectValuesFromWheelPicker(int a, int b, int c) {
        wheelA.sendKeys(Integer.toString(a));
        wheelB.sendKeys(Integer.toString(b));
        wheelC.sendKeys(Integer.toString(c));
    }

    public int getWheelAValue() {
        return Integer.parseInt(wheelA.getText());
    }

    public int getWheelBValue() {
        return Integer.parseInt(wheelB.getText());
    }

    public int getWheelCValue() {
        return Integer.parseInt(wheelC.getText());
    }

    public void clickOnSliders() {
        slidersTab.click();
    }

    public String setDefaultSliderValue(String value) {
        defaultSlider.setValue(value);
        return defaultSlider.getText();
    }
}

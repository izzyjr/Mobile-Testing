package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class UIKitCatalogPage {

    IOSDriver driver;

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
}

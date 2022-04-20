package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class LongtapPage {

    private final IOSDriver driver;
    private IOSTouchAction touchAction;

    public LongtapPage(IOSDriver driver, IOSTouchAction touchAction) throws MalformedURLException {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Long tap']")
    private IOSElement longTapButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[1]")
    private IOSElement nameSwitchToggle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[2]")
    private IOSElement emailSwitchToggle;

    public void longPressOnLongTapButton() {
        touchAction.longPress(longPressOptions()
                .withElement(element(longTapButton))
                .withDuration(ofSeconds(3)))
                .release()
                .perform();
    }

    public void tapOnNameSwitchToggleValue() {
        touchAction.tap(tapOptions()
                .withElement(element(nameSwitchToggle)))
                .perform();
    }

    public void tapOnEmailSwitchToggleValue() {
        touchAction.tap(tapOptions()
                .withElement(element(emailSwitchToggle)))
                .perform();
    }

    public boolean getNameSwitchToggleValue() {
        String value = nameSwitchToggle.getAttribute("value");
        if (value.equals("0")) {
            return false;
        }
        return true;
    }

    public boolean getEmailSwitchToggleValue() {
        String value = emailSwitchToggle.getAttribute("value");
        if (value.equals("0")) {
            return false;
        }
        return true;
    }

}

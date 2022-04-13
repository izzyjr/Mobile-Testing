package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ApiDemosDebugPage {

    AndroidDriver<AndroidElement> driver;
    TouchAction touchAction;

    By preference = By.xpath("//android.widget.TextView[@text='Preference']");
    By preferenceDependencies = By.xpath("//android.widget.TextView[@text='3. Preference dependencies']");
    By wifiCheckbox = By.id("android:id/checkbox");
    By wifiSettings = By.xpath("(//android.widget.RelativeLayout)[2]");
    By editText = By.className("android.widget.EditText");
    By buttons = By.className("android.widget.Button");

    @AndroidFindBy(uiAutomator = "text(\"Views\")")
    private AndroidElement views;

    @AndroidFindBy(uiAutomator = "new UiSelector().clickable(true)")
    private List<AndroidElement> clickableElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
    private AndroidElement expandList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1. Custom Adapter']")
    private AndroidElement customAdapter;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    private AndroidElement peopleNames;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sample menu']")
    private AndroidElement sampleMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Date Widgets']")
    private AndroidElement dateWidgets;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2. Inline']")
    private AndroidElement inline;

    @AndroidFindBy(xpath = "//*[@content-desc='9']")
    private AndroidElement number9;

    @AndroidFindBy(xpath = "//*[@content-desc='15']")
    private AndroidElement number15;

    @AndroidFindBy(xpath = "//*[@content-desc='45']")
    private AndroidElement number45;

    public ApiDemosDebugPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ApiDemosDebugPage(AndroidDriver<AndroidElement> driver, TouchAction touchAction) throws MalformedURLException {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnPreference() {
        driver.findElement(preference).click();
    }

    public void clickOnPreferenceDependencies() {
        driver.findElement(preferenceDependencies).click();
    }

    public void clickOnWifiCheckbox() {
        driver.findElement(wifiCheckbox).click();
    }

    public void clickOnWifiSettings() {
        driver.findElement(wifiSettings).click();
    }

    public void inputTextInEditText(String text) {
        driver.findElement(editText).sendKeys(text);
    }

    public void selectButton(int buttonNumber) {
        driver.findElements(buttons).get(buttonNumber).click();
    }

    public void clickOnViews() {
        views.click();
    }

    public void tapOnViews() {
        touchAction.tap(tapOptions()
                .withElement(element(views)))
                .perform();
    }

    public int findClickableElements() {
        return clickableElements.size();
    }

    public void tapOnExpandList() {
        touchAction.tap(tapOptions()
                .withElement(element(expandList)))
                .perform();
    }

    public void tapOnCustomAdapter() {
        touchAction.tap(tapOptions()
                .withElement(element(customAdapter)))
                .perform();
    }

    public void longPressPeopleNames() {
        touchAction.longPress(longPressOptions()
                .withElement(element(peopleNames))
                .withDuration(ofSeconds(2)))
                .release()
                .perform();
    }

    public boolean isSampleMenuDisplayed() {
        return sampleMenu.isDisplayed();
    }

    public void tapOnDateWidgets() {
        touchAction.tap(tapOptions()
                .withElement(element(dateWidgets)))
                .perform();
    }

    public void tapOnInline() {
        touchAction.tap(tapOptions()
                .withElement(element(inline)))
                .perform();
    }

    public void tapOnNumber9() {
        touchAction.tap(tapOptions()
                .withElement(element(number9)))
                .perform();
    }

    public void longPressThanMove() {
        touchAction.longPress(longPressOptions()
                .withElement(element(number15))
                .withDuration(ofSeconds(2)))
                .moveTo(element(number45))
                .release()
                .perform();
    }

    public boolean isNumber45Selected() {
        return number45.isSelected();
    }
}

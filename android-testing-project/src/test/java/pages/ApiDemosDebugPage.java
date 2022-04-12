package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class ApiDemosDebugPage {

    AndroidDriver<AndroidElement> driver;

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

    public ApiDemosDebugPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
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

    public int findClickableElements() {
        return clickableElements.size();
    }
}

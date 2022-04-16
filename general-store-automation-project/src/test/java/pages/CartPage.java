package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class CartPage {

    AndroidDriver<AndroidElement> driver;
    TouchAction touchAction;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nike SFB Jungle']")
    private AndroidElement nikeSFBJungle;

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
}

package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class WebViewPage {

    AndroidDriver<AndroidElement> driver;

    public WebViewPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public void search(String search) {
        searchInput.sendKeys(search);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void backToApp() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

}

package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.net.MalformedURLException;

public class MobileChromeBrowserPage extends Base {

    AndroidDriver<AndroidElement> driver;

    public MobileChromeBrowserPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void getWebUrl() {
        driver.get(URL);
    }

}

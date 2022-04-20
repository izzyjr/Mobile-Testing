package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.net.MalformedURLException;

public class MobileChromeBrowserPage extends Base {

    private final AndroidDriver<AndroidElement> driver;

    @FindBy(xpath = "//span[@class='navbar-toggler-icon']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//a[@href='/angularAppdemo/products']")
    private WebElement products;

    @FindBy(xpath = "//a[@href='/angularAppdemo/products/3']")
    private WebElement devopsCourse;

    @FindBy(xpath = "//h3[text()='Devops']")
    private WebElement devopsCourseTitle;

    public MobileChromeBrowserPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void getWebUrl() {
        driver.get(URL);
    }

    public void selectAppHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void selectProducts() {
        products.click();
    }

    public void scrollToDevopsAndClick() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", devopsCourse);
        devopsCourse.click();
    }

    public boolean isDevopsCourseTitleDisplayed() {
        return devopsCourseTitle.isDisplayed();
    }
}

package pages;

import io.appium.java_client.android.AndroidElement;

import static pages.ProductPage.*;

public enum Product {
    NIKE_SFB_JUNGLE("Nike SFB Jungle", scrollToNikeSFBJungle),
    CONVERSE_ALL_STAR("Converse All Star", scrollToConverseAllStar),
    JORDAN_LIFT_OFF("Jordan Lift Off", scrollToJordanLiftOff),
    AIR_JORDAN_1_MID_SE("Air Jordan 1 Mid SE", scrollToAirJordan1Mid1SE);

    private final String title;
    private final AndroidElement productPageLocator;

    Product(String title, AndroidElement productPageLocator) {
        this.title = title;
        this.productPageLocator = productPageLocator;
    }

    public String getTitle() {
        return title;
    }

    public AndroidElement getProductPageLocator() {
        return productPageLocator;
    }
}
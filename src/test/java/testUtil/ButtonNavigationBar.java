package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ButtonNavigationBar {
    private AndroidDriver driver;

    MobileElement recordListButton;
    MobileElement analyticsButton;
    MobileElement createRecordButton;
    MobileElement accountListButton;
    MobileElement advanceFunctionsButton;
    public ButtonNavigationBar(AndroidDriver driver) {
        this.driver = driver;
    }

    public MobileElement getRecordListButton() {
        recordListButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_record_list");
        return recordListButton;
    }

    public MobileElement getAnalyticsButton() {
        analyticsButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_analytics");
        return analyticsButton;
    }

    public MobileElement getCreateRecordButton() {
        createRecordButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        return createRecordButton;
    }

    public MobileElement getAccountListButton() {
        accountListButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_account_list");
        return accountListButton;
    }

    public MobileElement getAdvanceFunctionsButton() {
        advanceFunctionsButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_profile");
        return advanceFunctionsButton;
    }
}

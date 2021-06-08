package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AdvanceFunctionsPage {
    private AndroidDriver driver;

    MobileElement searchRecordsButton;
    MobileElement notificationSettingButton;
    MobileElement accountOrderButton;
    MobileElement expenseCategoryButton;
    MobileElement IncomeCategoryButton;


    public AdvanceFunctionsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public MobileElement getSearchRecordsButton() {
        searchRecordsButton =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup");
        return searchRecordsButton;
    }

    public MobileElement getNotificationSettingButton() {
        notificationSettingButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[4]/android.view.ViewGroup");
        return notificationSettingButton;
    }

    public MobileElement getAccountOrderButton() {
        accountOrderButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup");
        return accountOrderButton;
    }

    public MobileElement getExpenseCategoryButton() {
        expenseCategoryButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup");
        return expenseCategoryButton;
    }

    public MobileElement getIncomeCategoryButton() {
        IncomeCategoryButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[3]/android.view.ViewGroup");
        return IncomeCategoryButton;
    }
}

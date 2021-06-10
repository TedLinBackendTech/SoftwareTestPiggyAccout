package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class ButtonNavigationBar {
    private AndroidDriver driver;

    MobileElement recordListButton;
    MobileElement analyticsButton;
    MobileElement createExpenseOrIncomeButton;
    MobileElement accountListButton;
    MobileElement advanceFunctionsButton;
    public ButtonNavigationBar(AndroidDriver driver) {
        this.driver = driver;
    }

    public MobileElement getRecordListButton() {
        try {
            recordListButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_record_list");

        }catch (org.openqa.selenium.NoSuchElementException e) {
            recordListButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[1]");
        }
        return recordListButton;
    }

    public MobileElement getAnalyticsButton() {
        try {
            analyticsButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_analytics");
        }catch (org.openqa.selenium.NoSuchElementException e) {
            analyticsButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[2]");
        }
        return analyticsButton;
    }

    public MobileElement getCreateExpenseOrIncomeButton() {
        try {
            createExpenseOrIncomeButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        }catch (org.openqa.selenium.NoSuchElementException e) {
            createExpenseOrIncomeButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[3]");
        }
        return createExpenseOrIncomeButton;
    }

    public MobileElement getAccountListButton() {
        try {
            accountListButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_account_list");
        }catch (org.openqa.selenium.NoSuchElementException e) {
            accountListButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[4]");
        }
        return accountListButton;
    }

    public MobileElement getAdvanceFunctionsButton() {
        try {
            advanceFunctionsButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_profile");
        }catch (org.openqa.selenium.NoSuchElementException e) {
            advanceFunctionsButton = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[5]");
        }
        return advanceFunctionsButton;
    }

    public void move(int fromX,int fromY,int toX,int toY){
        new TouchAction(driver)
                .press(PointOption.point(fromX,fromY))
                .moveTo(PointOption.point(toX,toY))
                .release()
                .perform();
    }
}

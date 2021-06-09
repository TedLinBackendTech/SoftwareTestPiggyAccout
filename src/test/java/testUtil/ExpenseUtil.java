package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ExpenseUtil {
    private AndroidDriver driver;
    public ExpenseUtil(AndroidDriver driver) {
        this.driver = driver;
    }

    public MobileElement getExpenseCategoryByText(String type) {
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.TextView[@text=" + "\"" + type +"\"" + "]";
        return (MobileElement) driver.findElementByXPath(xpath);
    }
    public MobileElement getExpenseAccountByText(String accountName) {
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.TextView[@text=" + "\"" + accountName +"\"" + "]";
        System.out.println(xpath);
        return (MobileElement) driver.findElementByXPath(xpath);
    }



}

package notifyfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.AdvanceFunctionsPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SetNotifyTest extends AbstractTest {
    public AdvanceFunctionsPage advanceFunctionsPage;
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
    }
    @Test
    public void Test_set_notify_happypath() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
        buttonNavigationBar.getAdvanceFunctionsButton().click();

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[4]/android.view.ViewGroup/android.widget.ImageView");
        el1.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Switch");
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Switch");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el6.click();

        MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.Switch");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]");
        el15.click();
        MobileElement el16 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el16.click();

        MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.Switch");
        el24.click();
        MobileElement el25 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]");
        el25.click();
        MobileElement el26 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el26.click();

        assertEquals("設定成功",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());


    }
}

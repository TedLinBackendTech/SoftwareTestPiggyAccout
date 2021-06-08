package incomefeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.ButtonNavigationBar;
import testUtil.Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
// TCS-2
public class DeleteExpenseTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    //utils
    private Calculator calculator;
    private ButtonNavigationBar buttonNavigationBar;
    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "piggyTest");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "C:\\Users\\William\\Desktop\\pig.apk");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("noReset","true");
        caps.setCapability("automationName","uiautomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        calculator = new Calculator(driver);
        buttonNavigationBar = new ButtonNavigationBar(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        el1.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Input Data
        String Date = "09 June 2021";
        String money = "1000";
        String category = "";
        //choose expense
        MobileElement expenseButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_expense");
        expenseButton.click();

        // Input date
        MobileElement dateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_time");
        dateButton.clear();
        dateButton.click();
        MobileElement chosenDate = (MobileElement) driver.findElementByAccessibilityId(Date);
        chosenDate.click();


        MobileElement amountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_amount");
        amountButton.clear();
        amountButton.click();
        calculator.getOne().click();
        calculator.getZero().click();
        calculator.getDblZero().click();
        calculator.getOk();


        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        el10.click();

    }

    @Test
    public void Test_delete_expense_happypath(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement el0 = buttonNavigationBar.getRecordListButton();
        el0.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el3.click();


    }
}

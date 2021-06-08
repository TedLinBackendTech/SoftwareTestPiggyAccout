package incomefeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.ButtonNavigationBar;
import testUtil.Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// TCS-3
public class EditExpenseTest extends AbstractTest {

    @BeforeMethod
    public void setup () throws MalformedURLException {

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
    public void Test_edit_expense_happypath(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        el2.click();
        String Date = "30 June 2021";
        // Input date
        MobileElement dateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_time");
        dateButton.clear();
        dateButton.click();
        MobileElement chosenDate = (MobileElement) driver.findElementByAccessibilityId(Date);
        chosenDate.click();

        MobileElement amountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_amount");
        amountButton.clear();
        amountButton.click();
        calculator.getThree().click();
        calculator.getZero().click();
        calculator.getDblZero().click();
        calculator.getOk();

        MobileElement el13 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        el13.click();
        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        el15.click();
        MobileElement el16 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        el17.click();
        MobileElement el18 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        el18.click();

    }
}




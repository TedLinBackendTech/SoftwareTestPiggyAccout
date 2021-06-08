package incomefeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.ButtonNavigationBar;
import testUtil.Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddExpenseTest extends AbstractTest {

    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
       super.setUp();

    }

    @Test
    public void Test_add_expense_happypath(){
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
//       net.eclipse_tech.naggingmoney:id/chatSendButton").click();
//        List<MobileElement> chatList = driver.findElementsByClassName("android.widget.TextView");
//        boolean isSuccess = false;
//        for(MobileElement chat : chatList){
//            if(chat.getText().equals("專案 $999999999999 ")){
//                isSuccess = true;
//                break;
//            }
//        }
//        assertTrue(isSuccess);
    }
    @AfterMethod
    public void delete_temp_data(){
        MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        el19.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el3.click();
    }
}

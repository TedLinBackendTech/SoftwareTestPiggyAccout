package incomefeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddExpenseTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    private Calculator calculator;
    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "piggyTest");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "C:\\Users\\Ted Lin\\Desktop\\pig.apk");
//        caps.setCapability("appPackage", "com.coceany.piggyaccounting");
//        caps.setCapability("appActivity","com.coceany.kokosaver.page.main.MainActivity");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("noReset","true");
        caps.setCapability("automationName","uiautomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        calculator = new Calculator(driver);
    }
    public void move(int fromPointX, int fromPointY, int toPointX, int toPointY ){
        new TouchAction(driver)
                .press(PointOption.point(fromPointX,fromPointY))
                .moveTo(PointOption.point(toPointX,toPointY))
                .release()
                .perform();
    }
    @Test
    public void Test_add_expense_happypath(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        move(666,670,375,1140); //skip opening info
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        move(477,2034,586,2034); //click +
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

//        amountButton.sendKeys("1000");
        MobileElement el8 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        el10.click();
//        driver.findElementById("net.eclipse_tech.naggingmoney:id/edtItem").sendKeys("專案");
//        driver.findElementById("net.eclipse_tech.naggingmoney:id/edtMoney").sendKeys("999999999999");
//        driver.findElementById("net.eclipse_tech.naggingmoney:id/chatSendButton").click();
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
}
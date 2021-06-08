package incomefeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class addIncomeTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "piggyTest");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "C:\\Users\\Ted Lin\\Desktop\\pig.apk");
//        caps.setCapability("appPackage", "net.eclipse_tech.naggingmoney");
//        caps.setCapability("appActivity","net.eclipse_tech.naggingmoney.MainActivity");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("noReset","true");
        caps.setCapability("automationName","uiautomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 為設備的性能或網路連線的關係，導致被測元件尚未出現於畫面中，所以設定每個指令最長的retry時間。
    }
    public void move(){
        new TouchAction(driver)
                .press(PointOption.point(707,1050))
                .moveTo(PointOption.point(7,1050))
                .release()
                .perform();
    }
    @Test
    public void A_CreateIncomeMoneyDigitalsLargerThanTen(){
        move();
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

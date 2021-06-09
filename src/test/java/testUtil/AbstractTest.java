package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    //utils
    public Calculator calculator;
    public ButtonNavigationBar buttonNavigationBar;
    public AdvanceFunctionsPage advanceFunctionsPage;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "piggyTest");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("app", "C:\\Users\\Ted Lin\\Desktop\\pig.apk");
        caps.setCapability("appPackage", "com.coceany.piggyaccounting");
        caps.setCapability("appActivity","com.coceany.kokosaver.page.main.SplashActivity");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("noReset","true");
        caps.setCapability("automationName","uiautomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        calculator = new Calculator(driver);
        buttonNavigationBar = new ButtonNavigationBar(driver);
        advanceFunctionsPage = new AdvanceFunctionsPage(driver);
    }
}

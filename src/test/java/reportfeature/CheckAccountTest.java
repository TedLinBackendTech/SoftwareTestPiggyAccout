package reportfeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testUtil.AbstractTest;
import testUtil.ButtonNavigationBar;
import testUtil.Calculator;

public class CheckAccountTest extends AbstractTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    //utils
    private Calculator calculator;
    private ButtonNavigationBar buttonNavigationBar;
}

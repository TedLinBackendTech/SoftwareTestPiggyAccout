package reportfeature;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.AccountType;
import testUtil.ButtonNavigationBar;
import testUtil.Calculator;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CheckAccountListTest extends AbstractTest {
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        if (driver != null) {
            driver.closeApp(); // close app
            driver.quit(); // end session
        }
    }

    @Test
    public void Test_check_account_list_empty() {
        buttonNavigationBar.getAccountListButton().click();
        boolean isValid = true;
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]";
        if (!driver.findElementByXPath(xpath).getText().equals("$0")) {
            isValid = false;
        }
        assertTrue(isValid);
    }

    @Test
    public void Test_check_account_list() {
        buttonNavigationBar.getAccountListButton().click();

        String xpath = "//android.widget.TextView[@content-desc=\"新增\"]";
        MobileElement addButton = (MobileElement)driver.findElementByXPath(xpath);
        addButton.click();

        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]";
        MobileElement nameField = (MobileElement)driver.findElementByXPath(xpath);
        nameField.sendKeys("新光銀行");

        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]";
        MobileElement amountField = (MobileElement)driver.findElementByXPath(xpath);
        amountField.click();
        for (char ch: "1200".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button";
        MobileElement saveButton = (MobileElement)driver.findElementByXPath(xpath);
        saveButton.click();

        boolean isValid = true;
        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]";
        if (!driver.findElementByXPath(xpath).getText().equals("$1,200")) {
            isValid = false;
        }
        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]";
        if (!driver.findElementByXPath(xpath).getText().equals("$1,200")) {
            isValid = false;
        }
        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]";
        if (!driver.findElementByXPath(xpath).getText().equals("新光銀行")) {
            isValid = false;
        }
        xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[3]";
        if (!driver.findElementByXPath(xpath).getText().equals("$1,200")) {
            isValid = false;
        }
        assertTrue(isValid);
    }
}

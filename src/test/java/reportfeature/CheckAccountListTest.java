package reportfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

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
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]"));
    }

    @Test
    public void Test_check_account_list_with_edit_and_delete() {
        buttonNavigationBar.getAccountListButton().click();
        // add
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"新增\"]");
        // add - name
        elementUtil.SendKeysByXpath("新光銀行", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]");
        // add - amount
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]");
        for (char ch: "1200".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add - comment
        elementUtil.SendKeysByXpath("薪轉戶", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]");
        // add - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        // check - total amount
        assertTrue(elementUtil.CheckTextByXpath("$1,200", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]"));
        // check - general amount
        assertTrue(elementUtil.CheckTextByXpath("$1,200", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]"));
        // check - account name
        assertTrue(elementUtil.CheckTextByXpath("新光銀行", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]"));
        // check - account comment
        assertTrue(elementUtil.CheckTextByXpath("薪轉戶", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]"));
        // check - account amount
        assertTrue(elementUtil.CheckTextByXpath("$1,200", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[3]"));
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView");
        // edit
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        // edit - name
        elementUtil.SendKeysByXpath("台新銀行", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]");
        // edit - type (deposit)
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        // edit - amount
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]");
        for (char ch: "1300".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // edit - comment
        elementUtil.SendKeysByXpath("證券戶", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]");
        // edit - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        // back
        buttonNavigationBar.move(104,218,119,223);
        // check - total amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]"));
        // check - general amount
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]"));
        // check - deposit amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[2]"));
        // check - account name
        assertTrue(elementUtil.CheckTextByXpath("台新銀行", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[1]"));
        // check - account comment
        assertTrue(elementUtil.CheckTextByXpath("證券戶", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[2]"));
        // check - account amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[3]"));
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.ImageView");
        // edit
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        // edit - type (credit card)
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");
        // edit - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        // back
        buttonNavigationBar.move(104,218,119,223);
        // check - total amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]"));
        // check - general amount
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]"));
        // check - credit card amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[2]"));
        // check - account name
        assertTrue(elementUtil.CheckTextByXpath("台新銀行", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[1]"));
        // check - account comment
        assertTrue(elementUtil.CheckTextByXpath("證券戶", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[2]"));
        // check - account amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[3]"));
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.ImageView");
        // edit
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        // edit - type (insurance)
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[4]");
        // edit - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        // back
        buttonNavigationBar.move(104,218,119,223);
        // check - total amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]"));
        // check - general amount
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]"));
        // check - insurance amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[2]"));
        // check - account name
        assertTrue(elementUtil.CheckTextByXpath("台新銀行", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[1]"));
        // check - account comment
        assertTrue(elementUtil.CheckTextByXpath("證券戶", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[2]"));
        // check - account amount
        assertTrue(elementUtil.CheckTextByXpath("$1,300", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView[3]"));
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.ImageView");
        // edit
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        // delete
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        // confirm
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        // check - total amount
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]"));
    }
}

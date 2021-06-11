package reportfeature;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CheckExpenseTest extends AbstractTest {
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
    public void Test_check_expense() {
        buttonNavigationBar.getAccountListButton().click();
        // add account
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"新增\"]");
        // add account - name
        elementUtil.SendKeysByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]");
        // add account  - amount
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]");
        for (char ch: "1200".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add account - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        // add expense
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        // add expense - amount
        for (char ch: "50".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        // add expense - next
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[2]");
        // add expense - amount
        for (char ch: "50".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // income pie
        elementUtil.ClickByXpath("//android.widget.LinearLayout[@content-desc=\"收入圓餅\"]");
        // check income empty
        assertTrue(elementUtil.CheckTextByXpath("還沒有記錄喔，快點開始記帳吧！", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView"));
        // expense pie
        elementUtil.ClickByXpath("//android.widget.LinearLayout[@content-desc=\"支出圓餅\"]");
        // check percent
        assertTrue(elementUtil.CheckTextByXpath("50 %", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("50 %", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]"));
        // check type
        assertTrue(elementUtil.CheckTextByXpath("午餐", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]"));
        assertTrue(elementUtil.CheckTextByXpath("早餐", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]"));
        // check amount
        assertTrue(elementUtil.CheckTextByXpath("$50", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[3]"));
        assertTrue(elementUtil.CheckTextByXpath("$50", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[3]"));
        // account list
        buttonNavigationBar.getAccountListButton().click();
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView");
        // edit account
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        // edit account - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        // edit account - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        // edit expense
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        // edit expense - amount
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]");
        for (char ch: "150".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // edit expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[5]");
        // edit expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // back
        buttonNavigationBar.move(104,218,119,223);
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // expense pie
        elementUtil.ClickByXpath("//android.widget.LinearLayout[@content-desc=\"支出圓餅\"]");
        // check percent
        assertTrue(elementUtil.CheckTextByXpath("75 %", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("25 %", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]"));
        // check type
        assertTrue(elementUtil.CheckTextByXpath("服飾", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]"));
        assertTrue(elementUtil.CheckTextByXpath("午餐", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]"));
        // check amount
        assertTrue(elementUtil.CheckTextByXpath("$150", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[3]"));
        assertTrue(elementUtil.CheckTextByXpath("$50", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[3]"));
        // account list
        buttonNavigationBar.getAccountListButton().click();
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.ImageView");
        // edit expense
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        // delete expense
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        // confirm
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        // edit expense
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        // delete expense
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        // confirm
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        // edit account
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        // delete account
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        // confirm
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
    }
}

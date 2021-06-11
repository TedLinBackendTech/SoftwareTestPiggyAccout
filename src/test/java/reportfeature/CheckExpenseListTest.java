package reportfeature;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CheckExpenseListTest extends AbstractTest {
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
    public void Test_check_expense_list_T1() {
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
        for (char ch: "55".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // back month
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"上個週期\"]");
        // check month
        elementUtil.CheckTextByXpath("數據分析 (May)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
        // next month
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"下個週期\"]");
        // check month
        assertTrue(elementUtil.CheckTextByXpath("數據分析 (June)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
        // check income amount
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check income record
        assertTrue(elementUtil.CheckTextByXpath("0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check income average
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check income type one
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check income type two
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check income type three
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check income top amount
        // assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check income top account
        // assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("1", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type one
        // assertTrue(elementUtil.CheckTextByXpath("早餐 $55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type two
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense type three
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense top amount
        // assertTrue(elementUtil.CheckTextByXpath("$55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense top account
        // assertTrue(elementUtil.CheckTextByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // add expense
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        // add expense - amount
        for (char ch: "120".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$175", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$6", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type one
        // assertTrue(elementUtil.CheckTextByXpath("午餐 $120", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type two
        // assertTrue(elementUtil.CheckTextByXpath("早餐 $55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense type three
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense top amount
        // assertTrue(elementUtil.CheckTextByXpath("$120", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense top account
        // assertTrue(elementUtil.CheckTextByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // add expense
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        // add expense - amount
        for (char ch: "250".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type one
        // assertTrue(elementUtil.CheckTextByXpath("晚餐 $250", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type two
        // assertTrue(elementUtil.CheckTextByXpath("午餐 $120", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense type three
        // assertTrue(elementUtil.CheckTextByXpath("早餐 $55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense top amount
        // assertTrue(elementUtil.CheckTextByXpath("$250", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense top account
        // assertTrue(elementUtil.CheckTextByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
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
        // edit expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[5]");
        // edit expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // back
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        elementUtil.ClickByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type one
        // assertTrue(elementUtil.CheckTextByXpath("服飾 $250", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type two
        // assertTrue(elementUtil.CheckTextByXpath("午餐 $120", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense type three
        // assertTrue(elementUtil.CheckTextByXpath("早餐 $55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense top amount
        // assertTrue(elementUtil.CheckTextByXpath("$250", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense top account
        // assertTrue(elementUtil.CheckTextByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // account list
        buttonNavigationBar.getAccountListButton().click();
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageView");
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

    @Test
    public void Test_check_expense_list_T2() {
        buttonNavigationBar.getAccountListButton().click();
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"新增\"]");
        elementUtil.SendKeysByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]");
        for (char ch: "1200".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        for (char ch: "55".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        buttonNavigationBar.getAnalyticsButton().click();
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"上個週期\"]");
        elementUtil.CheckTextByXpath("數據分析 (May)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"下個週期\"]");
        assertTrue(elementUtil.CheckTextByXpath("數據分析 (June)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("$55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("1", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        for (char ch: "120".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        buttonNavigationBar.getAnalyticsButton().click();
        assertTrue(elementUtil.CheckTextByXpath("$175", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$6", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        for (char ch: "250".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        buttonNavigationBar.getAnalyticsButton().click();
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        buttonNavigationBar.getAccountListButton().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[5]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        elementUtil.ClickByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
        buttonNavigationBar.getAnalyticsButton().click();
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        buttonNavigationBar.getAccountListButton().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageView");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
    }

    @Test
    public void Test_check_expense_list_T3() {
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
        for (char ch: "55".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // back month
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"上個週期\"]");
        // check month
        elementUtil.CheckTextByXpath("數據分析 (May)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
        // next month
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"下個週期\"]");
        // check month
        assertTrue(elementUtil.CheckTextByXpath("數據分析 (June)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
        // check income amount
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check income record
        assertTrue(elementUtil.CheckTextByXpath("0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check income average
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check income type one
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check income type two
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check income type three
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("1", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type two
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // check expense type three
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // add expense
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        // add expense - amount
        for (char ch: "120".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$175", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$6", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense type one
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        // add expense
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        // add expense - amount
        for (char ch: "250".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        // add expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");
        // add expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
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
        // edit expense - type
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[5]");
        // edit expense - save
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        // back
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        elementUtil.ClickByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
        // analysis
        buttonNavigationBar.getAnalyticsButton().click();
        // check expense amount
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense record
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // check expense average
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        // account list
        buttonNavigationBar.getAccountListButton().click();
        // account detail
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageView");
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

    @Test
    public void Test_check_expense_list_T4() {
        buttonNavigationBar.getAccountListButton().click();
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"新增\"]");
        elementUtil.SendKeysByXpath("Bank", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]");
        for (char ch: "1200".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        for (char ch: "55".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        buttonNavigationBar.getAnalyticsButton().click();
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"上個週期\"]");
        elementUtil.CheckTextByXpath("數據分析 (May)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"下個週期\"]");
        assertTrue(elementUtil.CheckTextByXpath("數據分析 (June)", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$0", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("$55", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("1", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        for (char ch: "120".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        buttonNavigationBar.getAnalyticsButton().click();
        assertTrue(elementUtil.CheckTextByXpath("$175", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("2", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$6", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("無資料", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[6]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        buttonNavigationBar.getCreateExpenseOrIncomeButton().click();
        for (char ch: "250".toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        buttonNavigationBar.getAnalyticsButton().click();
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        buttonNavigationBar.getAccountListButton().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[5]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button[1]");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        elementUtil.ClickByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
        buttonNavigationBar.getAnalyticsButton().click();
        assertTrue(elementUtil.CheckTextByXpath("$425", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("3", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        assertTrue(elementUtil.CheckTextByXpath("$14", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/f.x.a.b/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        buttonNavigationBar.getAccountListButton().click();
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageView");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"編輯\"]");
        elementUtil.ClickByXpath("//android.widget.TextView[@content-desc=\"刪除\"]");
        elementUtil.ClickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]");
    }
}

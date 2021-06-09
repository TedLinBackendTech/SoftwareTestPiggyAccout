package searchfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.ExpenseUtil;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SearchforTextTest extends AbstractTest {
    private ExpenseUtil expenseUtil;
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        expenseUtil = new ExpenseUtil(driver);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        this.create_a_expense("20 June 2021","1000","晚餐","其他","跟同學聚餐");
    }
    @Test
    public void Test_search_happypath_with_text_as_type_Expect_get_result() {
        // Input Data
        String searchWords = "晚餐";
        int ExpectSearchResult = 2;

        buttonNavigationBar.getAdvanceFunctionsButton().click();
        advanceFunctionsPage.getSearchRecordsButton().click();
        MobileElement searchBar = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_search_keyword");
        searchBar.click();
        searchBar.sendKeys(searchWords);

        MobileElement searchButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_search");
        searchButton.click();

        int searchResultListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        assertTrue(1 == searchResultListLength);

        MobileElement exitSearch = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        exitSearch.click();

    }
    @Test
    public void Test_search_happypath_with_meanless_words_Expect_no_result() {
        // Input Data
        String searchWords = "!@####";

        buttonNavigationBar.getAdvanceFunctionsButton().click();
        advanceFunctionsPage.getSearchRecordsButton().click();
        MobileElement searchBar = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_search_keyword");
        searchBar.click();
        searchBar.sendKeys(searchWords);

        MobileElement searchButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_search");
        searchButton.click();


        String promtMsg = driver.findElementById("com.coceany.piggyaccounting:id/tv_empty").getText();
        assertTrue(promtMsg.equals("還沒有記錄喔，快點開始記帳吧！"));

        MobileElement exitSearch = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        exitSearch.click();

    }

    private void create_a_expense(String date ,String money,String category,String accountName, String comment) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        el1.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //choose expense
        MobileElement expenseButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_expense");
        expenseButton.click();

        // Input date
        MobileElement dateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_time");
        dateButton.clear();
        dateButton.click();
        MobileElement chosenDate = (MobileElement) driver.findElementByAccessibilityId(date);
        chosenDate.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement amountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_amount");
        amountButton.clear();
        amountButton.click();
        for (char ch: money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();


        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        MobileElement selectedCategory = expenseUtil.getExpenseCategoryByText(category);
        selectedCategory.click();

        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement selectedAccountName = expenseUtil.getExpenseAccountByText(accountName);
        selectedAccountName.click();

        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        commentButton.sendKeys(comment);

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    private void delete_a_expense(String date ,String money,String category,String accountName, String comment) {
        buttonNavigationBar.getRecordListButton().click();
        String EIxpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
        List<MobileElement> EILists = driver.findElementsByXPath(EIxpath);
        MobileElement preCreatedExpense = null;
        for (int i=1; i<=EILists.size();i++){
            String EIxpath_account = EIxpath + "[" + i +"]/android.widget.TextView[1]";
            String EIxpath_category = EIxpath + "[" + i +"]/android.widget.TextView[2]";
            String EIxpath_comment = EIxpath + "[" + i +"]/android.widget.TextView[3]";
            String EIxpath_amount = EIxpath + "[" + i +"]/android.widget.TextView[4]";
            try {
                MobileElement accountE = (MobileElement) driver.findElementByXPath(EIxpath_account);
                MobileElement categoryE = (MobileElement) driver.findElementByXPath(EIxpath_category);
                MobileElement commentE = (MobileElement) driver.findElementByXPath(EIxpath_comment);
                MobileElement amountE = (MobileElement) driver.findElementByXPath(EIxpath_amount);
                String amountEWithoutComma   =   amountE.getText().replace( ",","");

                if (accountE.getText().equals(accountName) &&
                        categoryE.getText().equals(category) &&
                        commentE.getText().equals(comment) &&
                        amountEWithoutComma.equals("$" + money)) {
                    preCreatedExpense = (MobileElement) driver.findElementByXPath(EIxpath + "[" + i +"]");
                    System.out.println("get element");
                }
            } catch (Exception e) {
                // 沒抓到 那就是日期欄
            }
        }
        preCreatedExpense.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el3.click();

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.delete_a_expense("20 June 2021","1000","晚餐","其他","跟同學聚餐");
    }
}

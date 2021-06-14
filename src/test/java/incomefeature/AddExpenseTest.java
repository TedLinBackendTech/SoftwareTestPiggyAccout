package incomefeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddExpenseTest extends AbstractTest {

    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
       super.setUp();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
    }

    private void create_a_simple_expense(String date, String money, String category, String accountName, String comment) {
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
        for (char ch : money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();


        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + category + "\")").click();

        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + accountName + "\")").click();

        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        commentButton.sendKeys(comment);

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    private void create_a_category(String incomeCategoryName){
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(incomeCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_income_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();

    }

    private void delete_category(String incomeCategoryName){
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        int index = 0;
        String xpath = "";
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(index = 1; index <= categoryListLength; index++){
            xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                break;
            }
        }

        driver.findElementByXPath(xpath).click();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el1.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el12.click();
    }

    private void  create_a_account(String accountName){
        String amount = "1200";
        MobileElement el2 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_profile");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView");
        el3.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el4 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_create");
        el4.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //InputData
        MobileElement el5 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el5.sendKeys(accountName);
        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.click();
        for (char ch: amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();
        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
    }

    private void delete_a_account(String accountName){
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getAccountOrderButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        int index = 0;
        String xpath = "";
        int acoountListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(index = 1; index <= acoountListLength; index++){
            xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(accountName)){
                break;
            }
        }

        driver.findElementByXPath(xpath).click();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el1.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el12.click();
    }

    private void create_a_regulation(String periodName){
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_create");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el3.sendKeys(periodName);
        MobileElement el4 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_duration");
        el4.sendKeys("1");
        MobileElement el5 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        el5.click();

    }

    private void delete_a_regulation(String periodName){
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView");
        el1.click();
        int index = 0;
        String xpath = "";
        int acoountListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(index = 1; index <= acoountListLength; index++){
            xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(periodName)){
                break;
            }
        }

        driver.findElementByXPath(xpath).click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el3.click();

    }

    private void delete_temp_data(){
        MobileElement el19 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        el19.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el3.click();
    }

    @Test
    public void Test_add_expense_tc1(){
        String date="02 June 2021";
        String money="0";
        String category="早餐";//預設
        String accountName="現金";//預設
        String comment="";//預設
        this.create_a_simple_expense(date,money,category,accountName,comment);
        boolean isCreateNewExpensetSuccess = false;
        int expenseListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for(int i = 1 ; i <= expenseListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
            String EIxpath_account = xpath + "[" + i + "]/android.widget.TextView[1]";
            String EIxpath_category = xpath + "[" + i + "]/android.widget.TextView[2]";
            String EIxpath_amount = xpath + "[" + i + "]/android.widget.TextView[3]";
            if(driver.findElementByXPath(EIxpath_account).getText().equals("現金") &&
                    driver.findElementByXPath(EIxpath_category).getText().equals("早餐") &&
                    driver.findElementByXPath(EIxpath_amount).getText().equals("$0")){
                isCreateNewExpensetSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewExpensetSuccess);
        this.delete_temp_data();
    }

    @Test
    public void Test_add_expense_tc2(){
        String money="1000";
        String category="午餐";
        String accountName="其他";
        String regulation= "每天";
        String comment=" "; //空白
        String et_invoice="A"; //發票號碼

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        el1.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //choose expense
        MobileElement expenseButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_expense");
        expenseButton.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement amountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_amount");
        amountButton.clear();
        amountButton.click();
        for (char ch : money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();

        //類別
        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + category + "\")").click();

        //帳戶
        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + accountName + "\")").click();

        //週期
        MobileElement regulationButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_regulation");
        regulationButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + regulation + "\")").click();

        //發票
        MobileElement et_invoiceButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_invoice");
        et_invoiceButton.click();
        et_invoiceButton.sendKeys(et_invoice);
        driver.navigate().back();

        //備註
        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        commentButton.sendKeys(comment);
        driver.navigate().back();

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        assertEquals("發票格式錯誤！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    @Test
    public void Test_add_expense_tc3(){

        String date="28 June 2021";
        String money="1200-2000=";
        String category="收入類別新增測試";
        String accountName="測試銀行帳號";
        String regulation= "測試週期";
        String comment="收入類別新增測試我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //創立使用者自訂類別
        create_a_category(category);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().back();

        // 使用者創建帳戶
        create_a_account(accountName);
        driver.navigate().back();

        // 使用者創建週期
        create_a_regulation(regulation);
        driver.navigate().back();

        MobileElement recordListButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_record_list");
        recordListButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        el1.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //choose income
        MobileElement expenseButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_income");
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
        for (char ch : money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();

        //類別
        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + category + "\")").click();

        //帳戶
        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + accountName + "\")").click();

        //週期
        MobileElement regulationButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_regulation");
        regulationButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + regulation + "\")").click();

        //備註
        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        commentButton.sendKeys(comment);

        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_amount").getText();
        assertTrue(!amountField.contains("-"));
        saveButton.click();


    }

    @Test
    public void Test_add_expense_tc4(){
        String date="02 June 2021";
        String money="1000";
        String category="晚餐";
        String accountName="其他";
        String comment="跟同學聚餐";
        String invoiceStr = "A12345678";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/iv_create_record");
        el1.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //choose income
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
        for (char ch : money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();

        //類別
        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + category + "\")").click();

        //帳戶
        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + accountName + "\")").click();

        //發票
        MobileElement invoiceButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_invoice");
        invoiceButton.click();
        invoiceButton.sendKeys(invoiceStr);
        driver.navigate().back();

        //備註
        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        commentButton.sendKeys(comment);

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        boolean isCreateNewExpensetSuccess = false;
        int expenseListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for(int i = 1 ; i <= expenseListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
            String EIxpath_account = xpath + "[" + i + "]/android.widget.TextView[1]";
            String EIxpath_category = xpath + "[" + i + "]/android.widget.TextView[2]";
            String EIxpath_comment = xpath + "[" + i + "]/android.widget.TextView[3]";
            String EIxpath_amount = xpath + "[" + i + "]/android.widget.TextView[4]";
            if(driver.findElementByXPath(EIxpath_account).getText().equals("其他") &&
                    driver.findElementByXPath(EIxpath_category).getText().equals("晚餐") &&
                    driver.findElementByXPath(EIxpath_comment).getText().equals("跟同學聚餐") &&
                    driver.findElementByXPath(EIxpath_amount).getText().equals("$1,000")){
                isCreateNewExpensetSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewExpensetSuccess);
        this.delete_temp_data();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void Test_add_expense_negative_path_with_cancel_Expected_cancel_add_expense(){
        String date="20 June 2021";
        String money="1000";
        String category="晚餐";
        String accountName="其他";
        String comment="會被取消的測試";
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
        for (char ch : money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();


        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + category + "\")").click();

        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + accountName + "\")").click();

        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        commentButton.sendKeys(comment);

        MobileElement cancelButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        cancelButton.click();


        boolean isCreateNewExpensetSuccess = true;
        int expenseListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for(int i = 1 ; i <= expenseListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
            String EIxpath_account = xpath + "[" + i + "]/android.widget.TextView[1]";
            String EIxpath_category = xpath + "[" + i + "]/android.widget.TextView[2]";
            String EIxpath_comment = xpath + "[" + i + "]/android.widget.TextView[3]";
            String EIxpath_amount = xpath + "[" + i + "]/android.widget.TextView[4]";
            if(driver.findElementByXPath(EIxpath_account).getText().equals("其他") &&
                    driver.findElementByXPath(EIxpath_category).getText().equals("晚餐") &&
                    driver.findElementByXPath(EIxpath_comment).getText().equals("跟同學聚餐") &&
                    driver.findElementByXPath(EIxpath_amount).getText().equals("$1,000")){
                isCreateNewExpensetSuccess = false;
                break;
            }
        }
        assertTrue(isCreateNewExpensetSuccess);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        String category="收入類別新增測試";
        String accountName="測試銀行帳號";
        String regulation= "測試週期";
        if(driver.currentActivity().equals("com.coceany.kokosaver.page.record.CreateRecordActivity")) {
            driver.navigate().back();
            //刪除測試類別
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            delete_category(category);
            driver.navigate().back();
            //刪除測試帳戶
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            delete_a_account(accountName);
            driver.navigate().back();

            //刪除測試週期
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            delete_a_regulation(regulation);
            driver.navigate().back();
        }
        super.tearDown();
        if (driver != null){
            driver.closeApp();
            driver.quit();
        }
    }

}
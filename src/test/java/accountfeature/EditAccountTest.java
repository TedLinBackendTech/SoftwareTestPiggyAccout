package accountfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.AccountType;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class EditAccountTest extends AbstractTest {
    private AccountType accountTypeSelector;
    //InputData
    private String accountName ;
    private String accountType ;
    private String amount;
    private String comment;
    private String afterAccountName ;

    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        accountTypeSelector = new AccountType(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.accountName = "自動化生成一般帳戶_編輯用";
        this.accountType = "一般";
        this.amount = "1235866490";
        this.comment = "樂透";
        this.afterAccountName = this.accountName;
        this.create_new_normal_account(this.accountName, this.accountType, this.amount, this.comment);

    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();

        if(driver.currentActivity().equals("com.coceany.kokosaver.page.account.CreateAccountActivity")) {
            MobileElement backToAccountListButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
            backToAccountListButton.click();
        }

        this.delete_the_specific_account(this.afterAccountName);
        if (driver != null) {
            driver.closeApp();// close APP
            driver.quit(); // end session
        }
    }
    private void clickCreatedAccount() {
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(this.accountName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }
    }

    @Test
    public void Test_edit_account_happypath() {
        //InputData
        String editAccountName = "自動化生成測試帳戶_After編輯";
        String editAccountType = "一般";
        String editAmount = "87";
        String editComment = "不~~樂透沒中";

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        String activity = driver.currentActivity();
        System.out.println("T1:" + activity);
        this.afterAccountName = editAccountName;

        boolean isEditNewAccountSuccess = false;
        int aftAccountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= aftAccountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(editAccountName)){
                isEditNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isEditNewAccountSuccess);

    }

    @Test
    public void Test_edit_account_negative_path_with_cancel_Expected_the_account_not_be_deleted() {
        //InputData
        String editAccountName = "自動化生成測試帳戶_編輯negativepath";
        String editAccountType = "一般";
        String editAmount = "878";
        String editComment = "要取消囉";

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);

        MobileElement cancelButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        cancelButton.click();


        boolean isCancelEditAccountSuccess = false;
        int aftAccountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= aftAccountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(this.accountName)){
                isCancelEditAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCancelEditAccountSuccess);

    }

    @Test
    public void Test_edit_account_T1_byECC_Expected_Input_Prompt() {
        //InputData

        String editAccountName = null;
        String editAccountType = "一般";
        String editAmount = "0";
        String editComment = null;

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        try{
            inputAccountNameField.sendKeys(editAccountName);
        }catch(IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }


        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        try{
            inputCommentField.sendKeys(editComment);
        }catch(IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        assertEquals("欄位還沒有填完喔！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());

    }

    @Test
    public void Test_edit_account_T2_byECC_Expected_get_Amount_should_not_be_negative() {
        //InputData
        String editAccountName = " ";
        String editAccountType = "信用卡";
        String editAmount = "1200-2123=";
        String editPeroidSettlementDate = "每月 01 號";
        String editPaySettlementDate = "每月 01 號";
        Boolean isNotifySet = true;
        String editComment = " ";

        this.clickCreatedAccount();//find the create account and click it
        String activity = driver.currentActivity();
        System.out.println("T2:" + activity);

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();


        MobileElement peroidSettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        peroidSettlementDateButton.clear();
        peroidSettlementDateButton.sendKeys(editPeroidSettlementDate);

        MobileElement paySettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_payment_due");
        paySettlementDateButton.clear();
        paySettlementDateButton.sendKeys(editPaySettlementDate);

        if(isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }


        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));


        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        boolean isEditAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(editAccountName)){
                isEditAccountSuccess = true;
                break;
            }
        }
        assertTrue(isEditAccountSuccess);

    }

    @Test
    public void Test_edit_account_T3_byECC_Expected_add_new_account_success() {
        //InputData
        String editAccountName = "自動化編輯信用卡帳戶測試_T3";
        String editAccountType = "信用卡";
        String editAmount = "723254";
        String editPeroidSettlementDate = "每月 30 號";
        String editPaySettlementDate = "每月 30 號";
        Boolean isNotifySet = false;
        String editComment = " ";

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement peroidSettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        peroidSettlementDateButton.clear();
        peroidSettlementDateButton.sendKeys(editPeroidSettlementDate);

        MobileElement paySettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_payment_due");
        paySettlementDateButton.clear();
        paySettlementDateButton.sendKeys(editPaySettlementDate);

        if(isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);


        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        this.afterAccountName = editAccountName;

        boolean isEditAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(editAccountName)){
                isEditAccountSuccess = true;
                break;
            }
        }
        assertTrue(isEditAccountSuccess);
        System.out.println("T3:" + driver.getContext());
        System.out.println("T3:" + this.afterAccountName);
    }

    @Test
    public void Test_edit_account_T4_byECC_Expected_add_new_account_success() {
        //InputData
        String editAccountName = "自動化編輯信用卡帳戶測試_T4";
        String editAccountType = "儲蓄保險";
        String editAmount = "72000";
        String editDueDate = "01 June 2021";
        Boolean isNotifySet = true;
        String editComment = "希望這次投資會中!!";

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement dueDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        dueDateButton.clear();
        dueDateButton.click();
        dueDateButton.sendKeys(editDueDate);

        if(isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        this.afterAccountName = editAccountName;

        boolean isEditAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(editAccountName)){
                isEditAccountSuccess = true;
                break;
            }
        }
        assertTrue(isEditAccountSuccess);
        System.out.println("T4:" + driver.getContext());
        System.out.println("T4:" + this.afterAccountName);
    }

    @Test
    public void Test_edit_account_T5_byECC_Expected_add_new_account_success() {
        //InputData
        String editAccountName = "自動化編輯儲蓄保險帳戶測試_T5";
        String editAccountType = "儲蓄保險";
        String editAmount = "9999999999999999";
        String editDueDate = "10 June 2021";
        Boolean isNotifySet = false;
        String editComment = "希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!";

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement dueDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        dueDateButton.clear();
        dueDateButton.click();
        dueDateButton.sendKeys(editDueDate);

        if(isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        this.afterAccountName = editAccountName;

        boolean isEditAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(editAccountName)){
                isEditAccountSuccess = true;
                break;
            }
        }
        assertTrue(isEditAccountSuccess);
        System.out.println("T5:" + driver.getContext());
        System.out.println("T5:" + this.afterAccountName);
    }


    @Test
    public void Test_edit_account_T6_byECC_Expected_add_new_account_success() {
        //InputData
        String editAccountName = "自動化編輯定期存款帳戶測試_T6";
        String editAccountType = "定期存款";
        String editAmount = "123456";
        String editDueDate = "31 June 2021";
        Boolean isNotifySet = false;
        String editComment = "可以的吧~希望這次投資會中!!希望這次投資會中!!";

        this.clickCreatedAccount();//find the create account and click it

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.clear();
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(editAccountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(editAccountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.clear();
        inputQuotaField.click();
        for (char ch: editAmount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement dueDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        dueDateButton.clear();
        dueDateButton.click();
        dueDateButton.sendKeys(editDueDate);

        if(isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.clear();
        inputCommentField.click();
        inputCommentField.sendKeys(editComment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        this.afterAccountName = editAccountName;

        boolean isEditAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(editAccountName)){
                isEditAccountSuccess = true;
                break;
            }
        }
        assertTrue(isEditAccountSuccess);
        System.out.println("T6:" + driver.getContext());
        System.out.println("T6:" + this.afterAccountName);
    }


    private void  create_new_normal_account(String accountName, String accountType, String amount, String comment){

        buttonNavigationBar.getAdvanceFunctionsButton().click();
        advanceFunctionsPage.getAccountOrderButton().click();
        MobileElement addNewAccountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_create");
        addNewAccountButton.click();

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.click();
        inputAccountNameField.sendKeys(accountName);

        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(accountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.click();

        //Enter the amount
        for (char ch: amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();


        boolean isCreateNewAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(accountName)){
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);
    }

    private void delete_the_specific_account(String deletedAccountName) {
        MobileElement preCreatedAccount = null ;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(deletedAccountName)){
                preCreatedAccount = driver.findElementByXPath(xpath);
                break;
            }
        }
        preCreatedAccount.click();

        MobileElement deleteAccountButton =(MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/menu_delete");
        deleteAccountButton.click();

        MobileElement deleteConfirmButton = null;
        try{
            deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        }catch (Exception e ){
            deleteConfirmButton = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\"確定\")");
        }
        deleteConfirmButton.click();

        boolean isDeleteAccountSuccess = false;
        int afterDeleteAccountListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for(int i = 1 ; i <= afterDeleteAccountListLength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(deletedAccountName)){
                isDeleteAccountSuccess = true;
                break;
            }
        }

        assertFalse(isDeleteAccountSuccess);
    }
}

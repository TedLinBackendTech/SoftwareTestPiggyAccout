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

public class AddNewAccountTest extends AbstractTest {
    private AccountType accountTypeSelector;
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        accountTypeSelector = new AccountType(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        if (driver != null) {
            driver.closeApp();// close APP
            driver.quit(); // end session
        }
    }

    @Test
    public void Test_add_account_happypath() {
        //InputData
        String accountName = "新光銀行happypath";
        String accountType = "一般";
        String amount = "1200";
        String comment = "薪轉戶";

        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
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
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);
        this.delete_the_account(accountName);
    }

    @Test
    public void Test_add_account_negative_path_with_cancel_Expected_cancel_add_account() {
        //InputData
        String accountName = "新增帳戶negativepath";
        String accountType = "一般";
        String amount = "12005";
        String comment = "會被取消";
        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);

        MobileElement cancelButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        cancelButton.click();

        boolean isCreateNewAccountCancel = true;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountCancel = false;
            }

        }
        assertTrue(isCreateNewAccountCancel);
    }

    @Test
    public void Test_add_account_T1_byECC_Expected_Input_Prompt() {
        //InputData
        String accountName = null;
        String accountType = "一般";
        String amount = "0";
        String comment = null;
        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
        advanceFunctionsPage.getAccountOrderButton().click();
        MobileElement addNewAccountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_create");
        addNewAccountButton.click();

        MobileElement inputAccountNameField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        inputAccountNameField.click();
        try {
            inputAccountNameField.sendKeys(accountName);
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }


        MobileElement inputTypeField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_type");
        inputTypeField.click();
        accountTypeSelector.getType(accountType).click();

        MobileElement inputQuotaField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount");
        inputQuotaField.click();
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        try {
            inputCommentField.sendKeys(comment);
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        assertEquals("欄位還沒有填完喔！", driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());
    }

    @Test
    public void Test_add_account_T2_byECC_Expected_get_Amount_warning() {
        //InputData
        String accountName = " ";
        String accountType = "信用卡";
        String amount = "1200-2000=";
        String peroidSettlementDate = "每月 01 號";
        String paySettlementDate = "每月 01 號";
        Boolean isNotifySet = true;
        String comment = " ";

        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();


        MobileElement peroidSettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        peroidSettlementDateButton.clear();
        peroidSettlementDateButton.sendKeys(peroidSettlementDate);

        MobileElement paySettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_payment_due");
        paySettlementDateButton.clear();
        paySettlementDateButton.sendKeys(paySettlementDate);

        if (isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }


        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));


        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();

        boolean isCreateNewAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);

    }

    @Test
    public void Test_add_account_T3_byECC_Expected_add_new_account_success() {
        //InputData
        String accountName = "自動化生成信用卡帳戶測試_T3";
        String accountType = "信用卡";
        String amount = "72000";
        String peroidSettlementDate = "每月 30 號";
        String paySettlementDate = "每月 30 號";
        Boolean isNotifySet = false;
        String comment = " ";

        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement peroidSettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        peroidSettlementDateButton.clear();
        peroidSettlementDateButton.sendKeys(peroidSettlementDate);

        MobileElement paySettlementDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_payment_due");
        paySettlementDateButton.clear();
        paySettlementDateButton.sendKeys(paySettlementDate);

        if (isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);


        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();


        boolean isCreateNewAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);
        this.delete_the_account(accountName);
    }

    @Test
    public void Test_add_account_T4_byECC_Expected_add_new_account_success() {
        //InputData
        String accountName = "自動化生成儲蓄保險帳戶測試_T4";
        String accountType = "儲蓄保險";
        String amount = "72000";
        String dueDate = "01 June 2021";
        Boolean isNotifySet = true;
        String comment = "希望這次投資會中!!";
        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement dueDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        dueDateButton.click();
        dueDateButton.sendKeys(dueDate);

        if (isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();


        boolean isCreateNewAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);
        this.delete_the_account(accountName);
    }

    @Test
    public void Test_add_account_T5_byECC_Expected_add_new_account_success() {
        //InputData
        String accountName = "自動化生成儲蓄保險帳戶測試_T5";
        String accountType = "儲蓄保險";
        String amount = "9999999999999999";
        String dueDate = "10 June 2021";
        Boolean isNotifySet = false;
        String comment = "希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!希望這次投資會中!!";

        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement dueDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        dueDateButton.click();
        dueDateButton.sendKeys(dueDate);

        if (isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();


        boolean isCreateNewAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);
        this.delete_the_account(accountName);
    }

    @Test
    public void Test_add_account_T6_byECC_Expected_add_new_account_success() {
        //InputData
        String accountName = "自動化生成定期存款帳戶測試_T6";
        String accountType = "定期存款";
        String amount = "123456";
        String dueDate = "31 June 2021";
        Boolean isNotifySet = false;
        String comment = "可以的吧~希望這次投資會中!!希望這次投資會中!!";

        buttonNavigationBar.clickAdvanceFunctionsButtonInbuttonNavigationBar();
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
        for (char ch : amount.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk().click();

        MobileElement dueDateButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_due");
        dueDateButton.click();
        dueDateButton.sendKeys(dueDate);

        if (isNotifySet) {
            MobileElement setNotifyButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/cb_enable_notification");
            setNotifyButton.click();
        }
        MobileElement inputCommentField = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        inputCommentField.click();
        inputCommentField.sendKeys(comment);

        //Before add ,should check is Amount negative
        String amountField = driver.findElementById("com.coceany.piggyaccounting:id/tv_current_amount").getText();
        assertTrue(!amountField.contains("-"));

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();


        boolean isCreateNewAccountSuccess = false;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(accountName)) {
                isCreateNewAccountSuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewAccountSuccess);
        this.delete_the_account(accountName);
    }

    private void delete_the_account(String deletedAccountName) {
        MobileElement preCreatedAccount = null;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for (int i = 1; i <= accountListlength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(deletedAccountName)) {
                preCreatedAccount = driver.findElementByXPath(xpath);
                break;
            }
        }

        preCreatedAccount.click();

        MobileElement deleteAccountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/menu_delete");
        deleteAccountButton.click();

        MobileElement deleteConfirmButton = null;
        try {
            deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        } catch (Exception e) {
            deleteConfirmButton = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"確定\")");
        }
        deleteConfirmButton.click();

        boolean isDeleteAccountSuccess = false;
        int afterDeleteAccountListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for (int i = 1; i <= afterDeleteAccountListLength; i++) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if (driver.findElementByXPath(xpath).getText().equals(deletedAccountName)) {
                isDeleteAccountSuccess = true;
                break;
            }
        }

        assertFalse(isDeleteAccountSuccess);
    }
}

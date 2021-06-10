package accountfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.AccountType;
import testUtil.ExpenseUtil;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class editAccountTest extends AbstractTest {
    private AccountType accountTypeSelector;
    //InputData
    private String accountName = "自動化生成一般帳戶_編輯用";
    private String accountType = "一般";
    private String amount = "1235866492232";
    private String comment = "樂透";
    private String afterAccountName;
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        accountTypeSelector = new AccountType(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.create_new_normal_account(this.accountName, this.accountType, this.amount, this.comment);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        this.delete_the_normal_account(this.afterAccountName);
        if (driver != null) {
            driver.closeApp();// close APP
            driver.quit(); // end session
        }
    }

    @Test
    public void Test_edit_account_happypath() {
        //InputData
        String editAccountName = "自動化生成測試帳戶_After編輯";
        String editAccountType = "一般";
        String editAmount = "0";
        String editComment = "不~~樂透沒中";
        //find the create account
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(this.accountName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

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

    private void  delete_the_normal_account(String deletedAccountName) {
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

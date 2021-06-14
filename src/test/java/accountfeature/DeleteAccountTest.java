package accountfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.AccountType;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteAccountTest extends AbstractTest {
    private AccountType accountTypeSelector;
    //Setup Input
    private String accountName = "新光銀行";
    private String accountType = "一般";
    private String amount = "12000";
    private String comment = "薪轉戶";
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        accountTypeSelector = new AccountType(driver);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); //wait for app opening
        this.create_new_normal_account(accountName,accountType,amount,comment);
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
    public void Test_delete_account_happypath_a() {
        String deletedAccountName = this.accountName;
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

        MobileElement deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
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



        MobileElement el1 = (MobileElement) driver.findElementByXPath
                ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView");
        el1.click();
        assertFalse(isDeleteAccountSuccess);
        //android.widget.TextView[@content-desc="刪除"]

    }

    @Test
    public void Test_delete_account_negative_path_a() {
        String deletedAccountName = this.accountName;
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

        MobileElement CancelButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_cancel");
        CancelButton.click();

        MobileElement backButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        backButton.click();

        boolean isCancelDeleteAccountSuccess = false;
        int afterDeleteAccountListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for(int i = 1 ; i <= afterDeleteAccountListLength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(deletedAccountName)){
                isCancelDeleteAccountSuccess = true;
                break;
            }
        }

        assertTrue(isCancelDeleteAccountSuccess);
        //android.widget.TextView[@content-desc="刪除"]
        delete_the_account(this.accountName);
    }

    @Test
    public void Test_delete_account_alternative_path_b() {
        String deletedAccountName = this.accountName;
        MobileElement orderOrDeleteButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete");
        orderOrDeleteButton.click();


        MobileElement deleteAccountButton = null ;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(deletedAccountName)){
                String deleteAccountButtonXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                        "android.view.ViewGroup["+ i + "]/android.widget.ImageButton[1]";
                deleteAccountButton = (MobileElement) driver.findElementByXPath(deleteAccountButtonXpath);
                break;
            }
        }
        deleteAccountButton.click();

        MobileElement saveDeleteActionButton =(MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete");
        saveDeleteActionButton.click();

        MobileElement deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        deleteConfirmButton.click();

        // after save , app will back to accountlists
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

    @Test
    public void Test_delete_account_negative_path_b() {
        String deletedAccountName = this.accountName;
        MobileElement orderOrDeleteButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete");
        orderOrDeleteButton.click();


        MobileElement deleteAccountButton = null ;
        int accountListlength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        for(int i = 1 ; i <= accountListlength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(deletedAccountName)){
                String deleteAccountButtonXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                        "android.view.ViewGroup["+ i + "]/android.widget.ImageButton[1]";
                deleteAccountButton = (MobileElement) driver.findElementByXPath(deleteAccountButtonXpath);
                break;
            }
        }
        deleteAccountButton.click();

        MobileElement saveDeleteActionButton =(MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete");
        saveDeleteActionButton.click();

        MobileElement deleteCancelButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_cancel");
        deleteCancelButton.click();

        MobileElement backButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        backButton.click();

        advanceFunctionsPage.getAccountOrderButton().click();

        // after save , app will back to accountlists
        boolean isCancelDeleteAccountSuccess = false;
        int afterDeleteAccountListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();

        for(int i = 1 ; i <= afterDeleteAccountListLength; i++ ) {
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
                    "android.view.ViewGroup["+ i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(deletedAccountName)){
                isCancelDeleteAccountSuccess = true;
                break;
            }
        }

        assertTrue(isCancelDeleteAccountSuccess);
        delete_the_account(this.accountName);
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

    private void  delete_the_account(String deletedAccountName) {
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

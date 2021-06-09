package accountfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import testUtil.AccountType;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddNewAccountTest extends AbstractTest {
    private AccountType accountTypeSelector;
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        accountTypeSelector = new AccountType(driver);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }
    @Test
    public void Test_add_account_happypath() {
        //InputData
        String accountName = "新光銀行2";
        String accountType = "一般";
        String amount = "1200";
        String comment = "薪轉戶";

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

}

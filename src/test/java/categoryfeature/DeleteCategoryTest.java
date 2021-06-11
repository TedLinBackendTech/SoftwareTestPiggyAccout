package categoryfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class DeleteCategoryTest extends AbstractTest {
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
    }

    @Test
    public void Test_delete_expense_category_happypath_a(){
        // add new category first
        String expenseCategoryName = "支出類別刪除測試a";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement backButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        driver.findElementByAccessibilityId("刪除").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm").click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isDeleteExpenseCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isDeleteExpenseCategorySuccess = false;
                break;
            }
            isDeleteExpenseCategorySuccess = true;
        }
        assertTrue(isDeleteExpenseCategorySuccess);
    }

    @Test
    public void Test_delete_income_category_happypath_a(){
        // add new category first
        String incomeCategoryName = "收入類別刪除測試a";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // delete
        driver.findElementByAccessibilityId("刪除").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm").click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isDeleteIncomeCategorySuccess = false;
        for(int i = 1; i <= categoryListLength; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isDeleteIncomeCategorySuccess = false;
                break;
            }
            isDeleteIncomeCategorySuccess = true;
        }
        assertTrue(isDeleteIncomeCategorySuccess);
    }

    @Test
    public void Test_delete_expense_and_cancel_category_happypath_a(){
        // add new category first
        String expenseCategoryName = "支出類別刪除測試取消a";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement backButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        driver.findElementByAccessibilityId("刪除").click();
        // cancel
        driver.findElementById("com.coceany.piggyaccounting:id/btn_cancel").click();
        MobileElement el = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        el.click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isDeleteExpenseAndCancelCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isDeleteExpenseAndCancelCategorySuccess = true;
                driver.findElementByXPath(xpath).click();
                break;
            }
        }
        assertTrue(isDeleteExpenseAndCancelCategorySuccess);

        // delete finally
        driver.findElementByAccessibilityId("刪除").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm").click();
    }

    @Test
    public void Test_delete_income_and_cancel_category_happypath_a(){
        // add new category first
        String incomeCategoryName = "收入類別刪除測試取消a";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // delete
        driver.findElementByAccessibilityId("刪除").click();
        // cancel
        driver.findElementById("com.coceany.piggyaccounting:id/btn_cancel").click();
        MobileElement el = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        el.click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isDeleteIncomeAndCancelCategorySuccess = false;
        for(int i = 1; i <= categoryListLength; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isDeleteIncomeAndCancelCategorySuccess =true;
                driver.findElementByXPath(xpath).click();
                break;
            }
        }
        assertTrue(isDeleteIncomeAndCancelCategorySuccess);

        // delete finally
        driver.findElementByAccessibilityId("刪除").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm").click();
    }

    @Test
    public void Test_delete_expense_category_happypath_b(){
        // add new category first
        String expenseCategoryName = "支出類別刪除測試b";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement backButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        backButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();

        // click delete
        driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete").click();

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.ImageButton[1]";
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // delete
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement saveDeleteActionButton =(MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete");
        saveDeleteActionButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"確定\")").click();
//        MobileElement deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
//        deleteConfirmButton.click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isDeleteExpenseCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isDeleteExpenseCategorySuccess = false;
                break;
            }
            isDeleteExpenseCategorySuccess = true;
        }
        assertTrue(isDeleteExpenseCategorySuccess);
    }

    @Test
    public void Test_delete_income_category_happypath_b(){
        // add new category first
        String incomeCategoryName = "收入類別刪除測試b";
        this.create_new_normal_income_category(incomeCategoryName);

        // click delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete").click();

        // search name which need to delete
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.ImageButton[1]";
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // delete
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement saveDeleteActionButton =(MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete");
        saveDeleteActionButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        deleteConfirmButton.click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isDeleteIncomeCategorySuccess = false;
        for(int i = 1; i <= categoryListLength; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isDeleteIncomeCategorySuccess = false;
                driver.findElementByXPath(xpath).click();
                break;
            }
            isDeleteIncomeCategorySuccess = true;
        }
        assertTrue(isDeleteIncomeCategorySuccess);
    }

    @Test
    public void Test_delete_expense_and_cancel_category_happypath_b(){
        // add new category first
        String expenseCategoryName = "支出類別刪除測試取消b";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        MobileElement backButton = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
//        backButton.click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        advanceFunctionsPage.getExpenseCategoryButton().click();

        // click delete
        driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete").click();

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.ImageButton[1]";
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // cancel
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_create");
        deleteConfirmButton.click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isDeleteExpenseAndCancelCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isDeleteExpenseAndCancelCategorySuccess = true;
                driver.findElementByXPath(xpath).click();
                break;
            }
        }
        assertTrue(isDeleteExpenseAndCancelCategorySuccess);

        // delete finally
        driver.findElementByAccessibilityId("刪除").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm").click();
    }

    @Test
    public void Test_delete_income_and_cancel_category_happypath_b(){
        // add new category first
        String incomeCategoryName = "收入類別刪除測試取消b";
        this.create_new_normal_income_category(incomeCategoryName);

        // click delete
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_order_or_delete").click();

        // search name which need to delete
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.ImageButton[1]";
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // cancel
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement deleteConfirmButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_create");
        deleteConfirmButton.click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isDeleteIncomeAndCancelCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isDeleteIncomeAndCancelCategorySuccess = true;
                driver.findElementByXPath(xpath).click();
                break;
            }
        }
        assertTrue(isDeleteIncomeAndCancelCategorySuccess);

        // delete finally
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("刪除").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm").click();
    }

    private void create_new_normal_expense_category(String categoryName){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(categoryName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
    }

    private void create_new_normal_income_category(String categoryName){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(categoryName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_income_category").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
    }
}

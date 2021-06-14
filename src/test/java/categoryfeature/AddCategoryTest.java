package categoryfeature;

import testUtil.AbstractTest;

import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddCategoryTest extends AbstractTest {
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
    }

    @Test
    public void Test_add_expense_category_happypath(){
        String expenseCategoryName = "支出類別新增測試我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(expenseCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // return first
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Navigate up").click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        advanceFunctionsPage.getExpenseCategoryButton().click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isCreateNewExpenseCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isCreateNewExpenseCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewExpenseCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_income_category_happypath(){
        String incomeCategoryName = "收入類別新增測試";
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isCreateNewIncomeCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isCreateNewIncomeCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewIncomeCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_expense_category_negativepath(){
        String expenseCategoryName = "支出類別新增測試取消";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(expenseCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // no save and return
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isCreateCancelExpenseCategorySuccess = true;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isCreateCancelExpenseCategorySuccess = false;
                break;
            }
        }
        assertTrue(isCreateCancelExpenseCategorySuccess);
    }

    @Test
    public void Test_add_income_category_negativepath(){
        String incomeCategoryName = "收入類別新增測試取消";
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

        // no save and return
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isCreateCancelIncomeCategorySuccess = true;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isCreateCancelIncomeCategorySuccess = false;
                break;
            }
        }
        assertTrue(isCreateCancelIncomeCategorySuccess);
    }

    @Test
    public void Test_add_expense_category_T1_byECC_Expected_add_category_success(){
        String expenseCategoryName = "支出類別新增測試我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(expenseCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // return first
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Navigate up").click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        advanceFunctionsPage.getExpenseCategoryButton().click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isCreateNewExpenseCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isCreateNewExpenseCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewExpenseCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_expense_category_T2_byECC_Expected_add_category_success(){
        String categoryName = "收入和支出類別新增測試";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(categoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_income_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // return first
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Navigate up").click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        advanceFunctionsPage.getExpenseCategoryButton().click();

        // expense assert
        int expenseCategoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("expenseCategoryListLength="+expenseCategoryListLength);
        boolean isCreateNewExpenseCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= expenseCategoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(categoryName)){
                isCreateNewExpenseCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewExpenseCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");

        // return first
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();

        // income assert
        int incomeCategoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("incomeCategoryListLength="+incomeCategoryListLength);
        boolean isCreateNewIncomeCategorySuccess = false;
        index = 1;
        for(index = 1; index <= incomeCategoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(categoryName)){
                isCreateNewIncomeCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewIncomeCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_expense_category_T3_byECC_Expected_add_category_success(){
        String expenseCategoryName = " ";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(expenseCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_income_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // return first
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isCreateNewExpenseCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryName)){
                isCreateNewExpenseCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewExpenseCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_expense_category_T4_byECC_Expected_get_warning(){
        String expenseCategoryName = "";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert
        assertEquals("名稱不能空白喔！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());

    }

    @Test
    public void Test_add_income_category_T1_byECC_Expected_add_category_success(){
        String incomeCategoryName = "收入類別新增測試";
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isCreateNewIncomeCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isCreateNewIncomeCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewIncomeCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_income_category_T2_byECC_Expected_add_category_success(){
        String incomeCategoryName = " ";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(incomeCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // return first
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength1="+categoryListLength);
        boolean isCreateNewIncomeCategorySuccess = false;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                isCreateNewIncomeCategorySuccess = true;
                break;
            }
        }
        assertTrue(isCreateNewIncomeCategorySuccess);

        // delete
        delete_category("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView");
    }

    @Test
    public void Test_add_income_category_T3_byECC_Expected_get_warning(){
        String incomeCategoryName = "收入類別新增測試我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(incomeCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert

        assertEquals("至少選擇一種類別！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());
    }

    @Test
    public void Test_add_income_category_T4_byECC_Expected_get_warning(){
        String incomeCategoryName = "";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(incomeCategoryName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_income_category").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert

        assertEquals("名稱不能空白喔！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());
    }


    private void delete_category(String deletePath){
        driver.findElementByXPath(deletePath).click();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el1.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el12.click();
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        if (driver != null){
            driver.closeApp();
            driver.quit();
        }
    }
}


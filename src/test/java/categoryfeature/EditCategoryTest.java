package categoryfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditCategoryTest extends AbstractTest {

    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
    }

    @Test
    public void Test_edit_expense_category_happypath(){
        // add new category first
        String expenseCategoryName = "支出類別編輯測試";
        String expenseCategoryEditName = "支出類別編輯測試edit";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Navigate up").click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup").click();

        // search name which need to edit
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

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(expenseCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();


        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditExpenseCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryEditName)){
                isEditExpenseCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditExpenseCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_income_category_happypath(){
        // add new category first
        String incomeCategoryName = "收入類別編輯測試";
        String incomeCategoryEditName = "收入類別編輯測試edit";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to edit
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(incomeCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditIncomeCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryEditName)){
                isEditIncomeCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditIncomeCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_expense_category_T1_byEcc_Expected_get_warning(){
        // add new category first
        String expenseCategoryName = "支出類別編輯測試";
        String expenseCategoryEditName = "";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Navigate up").click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup").click();

        // search name which need to edit
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

        // edit
        MobileElement el1 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el1.clear();
        el1.sendKeys(expenseCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // assert
        assertEquals("名稱不能空白喔！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());
    }

    @Test
    public void Test_edit_expense_category_T2_byEcc_Expected_edit_category_success(){
        // add new category first
        String expenseCategoryName = "支出類別編輯測試";
        String expenseCategoryEditName = " ";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup").click();

        // search name which need to edit
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

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(expenseCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();


        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditExpenseCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryEditName)){
                isEditExpenseCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditExpenseCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_expense_category_T3_byEcc_Expected_edit_category_success(){
        // add new category first
        String expenseCategoryName = "支出類別編輯測試";
        String expenseCategoryEditName = "支出類別編輯測試edit";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("Navigate up").click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup").click();

        // search name which need to edit
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

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(expenseCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();


        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditExpenseCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryEditName)){
                isEditExpenseCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditExpenseCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_expense_category_T4_byEcc_Expected_edit_category_success(){
        // add new category first
        String expenseCategoryName = "支出類別編輯測試";
        String expenseCategoryEditName = "支出類別編輯測試edit我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字";
        this.create_new_normal_expense_category(expenseCategoryName);

        // return first
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Navigate up").click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup").click();

        // search name which need to edit
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

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(expenseCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();


        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditExpenseCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(expenseCategoryEditName)){
                isEditExpenseCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditExpenseCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_income_category_T1_byEcc_Expected_get_warning(){
        // add new category first
        String incomeCategoryName = "收入類別編輯測試";
        String incomeCategoryEditName = "";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to edit
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(incomeCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();

        // assert
        assertEquals("名稱不能空白喔！",driver.findElementByXPath("/hierarchy/android.widget.Toast").getText());
    }

    @Test
    public void Test_edit_income_category_T2_byEcc_Expected_edit_category_success(){
        // add new category first
        String incomeCategoryName = "收入類別編輯測試";
        String incomeCategoryEditName = " ";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to edit
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(incomeCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditIncomeCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryEditName)){
                isEditIncomeCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditIncomeCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_income_category_T3_byEcc_Expected_edit_category_success(){
        // add new category first
        String incomeCategoryName = "收入類別編輯測試";
        String incomeCategoryEditName = "收入類別編輯測試edit";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to edit
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(incomeCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditIncomeCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryEditName)){
                isEditIncomeCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditIncomeCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }

    @Test
    public void Test_edit_income_category_T4_byEcc_Expected_edit_category_success(){
        // add new category first
        String incomeCategoryName = "收入類別編輯測試";
        String incomeCategoryEditName = "收入類別編輯測試edit我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字我要大於五十字";
        this.create_new_normal_income_category(incomeCategoryName);

        // search name which need to edit
        int categoryListLengthOrigin = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLengthOrigin="+categoryListLengthOrigin);
        for(int i = 1; i <= categoryListLengthOrigin; i++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryName)){
                driver.findElementByXPath(xpath).click();
                break;
            }
        }

        // edit
        MobileElement el10 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el10.clear();
        el10.sendKeys(incomeCategoryEditName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();

        // assert
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        System.out.println("categoryListLength="+categoryListLength);
        boolean isEditIncomeCategorySuccess = false;
        int index = 1;
        String deletePath = "";
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(driver.findElementByXPath(xpath).getText().equals(incomeCategoryEditName)){
                isEditIncomeCategorySuccess = true;
                deletePath = xpath;
                break;
            }
        }
        assertTrue(isEditIncomeCategorySuccess);

        // delete
        this.delete_category(deletePath);
    }



    private void create_new_normal_expense_category(String categoryName){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/iv_profile").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(categoryName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_expense_category").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void create_new_normal_income_category(String categoryName){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/iv_profile").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout[3]/android.view.ViewGroup").click();
        driver.findElementById("com.coceany.piggyaccounting:id/btn_create").click();
        MobileElement el = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_name");
        el.click();
        el.sendKeys(categoryName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/cb_income_category").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.coceany.piggyaccounting:id/btn_save").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void delete_category(String deletePath){
        driver.findElementByXPath(deletePath).click();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el1.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el12.click();
    }
}

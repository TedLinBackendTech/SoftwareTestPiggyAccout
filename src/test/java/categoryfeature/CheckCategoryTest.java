package categoryfeature;

import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testUtil.AbstractTest;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CheckCategoryTest extends AbstractTest {
    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for app opening
    }

    @Test
    public void Test_check_expense_category_happypath(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getExpenseCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert there has preset category
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        String[] expenseCategoryList = {"早餐", "午餐", "晚餐", "生活用品", "服飾", "交通", "飲料", "醫療", "投資", "娛樂", "進修", "其他"};
        boolean hasAllPresetCategory = true;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(!driver.findElementByXPath(xpath).getText().equals(expenseCategoryList[index-1])){
                hasAllPresetCategory = false;
                break;
            }
        }
        assertTrue(hasAllPresetCategory);
    }

    @Test
    public void Test_query_income_category_happypath(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonNavigationBar.getAdvanceFunctionsButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        advanceFunctionsPage.getIncomeCategoryButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // assert there has preset category
        int categoryListLength = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
        String[] incomeCategoryList = {"投資", "薪資", "其他"};
        boolean hasAllPresetCategory = true;
        int index = 1;
        for(index = 1; index <= categoryListLength; index++){
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]/android.widget.TextView";
            if(!driver.findElementByXPath(xpath).getText().equals(incomeCategoryList[index-1])){
                hasAllPresetCategory = false;
                break;
            }
        }
        assertTrue(hasAllPresetCategory);
    }

}

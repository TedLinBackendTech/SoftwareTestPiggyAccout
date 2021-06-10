package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExpenseUtil extends AbstractTest{
    private AndroidDriver driver;
    public ExpenseUtil(AndroidDriver driver) throws MalformedURLException {
        this.driver = driver;
        super.setUp();
    }

    public MobileElement getExpenseCategoryByText(String type) {
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.TextView[@text=" + "\"" + type +"\"" + "]";
        return (MobileElement) driver.findElementByXPath(xpath);
    }
    public MobileElement getExpenseAccountByText(String accountName) {
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.TextView[@text=" + "\"" + accountName +"\"" + "]";
        System.out.println(xpath);
        return (MobileElement) driver.findElementByXPath(xpath);
    }

    public void create_a_expense(String date ,String money,String category,String accountName, String comment) {
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
        for (char ch: money.toCharArray()) {
            calculator.getButton(ch).click();
        }
        calculator.getOk();


        MobileElement categoryButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_category");
        categoryButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+category+"\")").click();

        MobileElement accountButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/tv_account");
        accountButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+accountName+"\")").click();

        MobileElement commentButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/et_note");
        commentButton.click();
        commentButton.sendKeys(comment);

        MobileElement saveButton = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_save");
        saveButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public void  delete_a_expense(String date ,String money,String category,String accountName, String comment) {
        buttonNavigationBar.getRecordListButton().click();
        String EIxpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
        List<MobileElement> EILists = driver.findElementsByXPath(EIxpath);
        MobileElement preCreatedExpense = null;
        for (int i=1; i<=EILists.size();i++){
            String EIxpath_account = EIxpath + "[" + i +"]/android.widget.TextView[1]";
            String EIxpath_category = EIxpath + "[" + i +"]/android.widget.TextView[2]";
            String EIxpath_comment = EIxpath + "[" + i +"]/android.widget.TextView[3]";
            String EIxpath_amount = EIxpath + "[" + i +"]/android.widget.TextView[4]";
            try {
                MobileElement accountE = (MobileElement) driver.findElementByXPath(EIxpath_account);
                MobileElement categoryE = (MobileElement) driver.findElementByXPath(EIxpath_category);
                MobileElement commentE = (MobileElement) driver.findElementByXPath(EIxpath_comment);
                MobileElement amountE = (MobileElement) driver.findElementByXPath(EIxpath_amount);
                String amountEWithoutComma   =   amountE.getText().replace( ",","");

                if (accountE.getText().equals(accountName) &&
                        categoryE.getText().equals(category) &&
                        commentE.getText().equals(comment) &&
                        amountEWithoutComma.equals("$" + money)) {
                    preCreatedExpense = (MobileElement) driver.findElementByXPath(EIxpath + "[" + i +"]");
                    break;
                }
            } catch (Exception e) {
                // 沒抓到 那就是日期欄
            }
        }
        preCreatedExpense.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("刪除");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.coceany.piggyaccounting:id/btn_confirm");
        el3.click();

    }


}

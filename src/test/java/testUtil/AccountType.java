package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AccountType {
    private AndroidDriver driver;

    MobileElement normalType;
    MobileElement timeDepositType;
    MobileElement creditCardType;
    MobileElement depositInsuranceType;

    public AccountType(AndroidDriver driver) {
        this.driver = driver;
    }

    public MobileElement getNormalType() {
        try{
            normalType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");

        }catch (Exception e){
            normalType = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"一般"+"\")");
        }

        return normalType;
    }

    public MobileElement getTimeDepositType() {

        try{
            timeDepositType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");

        }catch (Exception e){
            timeDepositType = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"定期存款"+"\")");
        }

        return timeDepositType;
    }

    public MobileElement getCreditCardType() {
        try{
            creditCardType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");

        }catch (Exception e){
            creditCardType = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"信用卡"+"\")");
        }

       return creditCardType;
    }

    public MobileElement getDepositInsuranceType() {

        try{
            depositInsuranceType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[4]");

        }catch (Exception e){
            depositInsuranceType = (MobileElement)driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+"儲蓄保險"+"\")");
        }

        return depositInsuranceType;
    }

    public MobileElement getType(String type) {
        if(type.equals("一般")) {
            return this.getNormalType();
        }
        else if(type.equals("定期存款") ){
            return this.getTimeDepositType();
        }
        else if(type.equals("信用卡") ){
            return this.getCreditCardType();
        }
        else if(type.equals("儲蓄保險") ){
            return this.getDepositInsuranceType();
        }
        else
            return null;
    }
}

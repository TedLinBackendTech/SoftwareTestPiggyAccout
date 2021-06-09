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
        normalType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        return normalType;
    }

    public MobileElement getTimeDepositType() {
        timeDepositType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");
        return timeDepositType;
    }

    public MobileElement getCreditCardType() {
        creditCardType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]");
        return creditCardType;
    }

    public MobileElement getDepositInsuranceType() {
        depositInsuranceType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/f.x.a.b/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[4]");
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

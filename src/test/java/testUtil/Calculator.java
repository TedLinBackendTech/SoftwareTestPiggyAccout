package testUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {
    private AndroidDriver driver;
    MobileElement zero;
    MobileElement dblZero;
    MobileElement one;
    MobileElement two;
    MobileElement three;
    MobileElement four;
    MobileElement five;
    MobileElement six;
    MobileElement seven;
    MobileElement eight;
    MobileElement nine;
    MobileElement point; //小數點

    MobileElement add;
    MobileElement subtract;
    MobileElement multiply;
    MobileElement divide;
    MobileElement equal;

    MobileElement ok;
    MobileElement AC;

    public Calculator(AndroidDriver driver) {
        this.driver = driver;
    }

    public MobileElement getZero() {
        this.zero = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[17]/android.widget.TextView");
        return zero;
    }

    public MobileElement getDblZero() {
        this.dblZero = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[16]/android.widget.TextView");
        return dblZero;
    }

    public MobileElement getOne() {
        this.one = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[11]/android.widget.TextView");
        return one;
    }

    public MobileElement getTwo() {
        this.two = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[12]/android.widget.TextView");
        return two;
    }

    public MobileElement getThree() {
        this.three = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[13]/android.widget.TextView");
        return three;
    }

    public MobileElement getFour() {
        this.four = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[6]/android.widget.TextView");
        return four;
    }

    public MobileElement getFive() {
        this.five = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[7]/android.widget.TextView");
        return five;
    }

    public MobileElement getSix() {
        this.six = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[8]/android.widget.TextView");
        return six;
    }

    public MobileElement getSeven() {
        this.seven = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView");
        return seven;
    }

    public MobileElement getEight() {
        this.eight = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.TextView");
        return eight;
    }

    public MobileElement getNine() {
        this.nine = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.TextView");
        return nine;
    }

    public MobileElement getPoint() {
        this.point = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[18]/android.widget.TextView");
        return point;
    }

    public MobileElement getAdd() {
        this.add = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[10]/android.widget.TextView");
        return add;
    }

    public MobileElement getSubtract() {
        this.subtract = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[15]/android.widget.TextView");
        return subtract;
    }

    public MobileElement getMultiply() {
        this.multiply = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[9]/android.widget.TextView");
        return multiply;
    }

    public MobileElement getDivide() {
        this.divide = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[14]/android.widget.TextView");
        return divide;
    }

    public MobileElement getEqual() {
        this.equal = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[19]/android.widget.TextView");
        return equal;
    }

    public MobileElement getOk() {
        this.ok = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[20]/android.widget.TextView");
        return ok;
    }

    public MobileElement getAC() {
        this.AC = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.TextView");
        return AC;
    }
}

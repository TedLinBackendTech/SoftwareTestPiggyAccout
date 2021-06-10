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

    public MobileElement getButton(char buttonType) {
        MobileElement chosenButton = null;
        switch (buttonType) {
            case '0':
                chosenButton = this.getZero();
                break;
            case '1':
                chosenButton = this.getOne();
                break;
            case '2':
                chosenButton = this.getTwo();
                break;
            case '3':
                chosenButton = this.getThree();
                break;
            case '4':
                chosenButton = this.getFour();
                break;
            case '5':
                chosenButton = this.getFive();
                break;
            case '6':
                chosenButton = this.getSix();
                break;
            case '7':
                chosenButton = this.getSeven();
                break;
            case '8':
                chosenButton = this.getEight();
                break;
            case '9':
                chosenButton = this.getNine();
                break;
            case '.':
                chosenButton = this.getPoint();
                break;
            case '+':
                chosenButton = this.getAdd();
                break;
            case '-':
                chosenButton = this.getSubtract();
                break;
            case '*':
                chosenButton = this.getMultiply();
                break;
            case '/':
                chosenButton = this.getDivide();
                break;
            case '=':
                chosenButton = this.getEqual();
                break;
            default:
                break;
        }
        return chosenButton;

    }

    public MobileElement getZero() {
        try {
            this.zero = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[17]/android.widget.TextView");
        } catch (Exception e) {
            this.zero = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "0" + "\")");
        }
        return zero;
    }

    public MobileElement getDblZero() {
        try {
            this.dblZero = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[16]/android.widget.TextView");

        } catch (Exception e) {
            this.dblZero = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "00" + "\")");
        }
        return dblZero;
    }

    public MobileElement getOne() {
        try {
            this.one = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[11]/android.widget.TextView");

        } catch (Exception e) {
            this.one = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "1" + "\")");
        }
        return one;
    }

    public MobileElement getTwo() {
        try {
            this.two = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[12]/android.widget.TextView");

        } catch (Exception e) {
            this.two = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "2" + "\")");
        }
        return two;
    }

    public MobileElement getThree() {
        try {
            this.three = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[13]/android.widget.TextView");

        } catch (Exception e) {
            this.three = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "3" + "\")");
        }
        return three;
    }

    public MobileElement getFour() {
        try {
            this.four = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[6]/android.widget.TextView");

        } catch (Exception e) {
            this.four = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "4" + "\")");
        }
        return four;
    }

    public MobileElement getFive() {
        try {
            this.five = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[7]/android.widget.TextView");

        } catch (Exception e) {
            this.five = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "5" + "\")");
        }
        return five;
    }

    public MobileElement getSix() {
        try {
            this.six = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[8]/android.widget.TextView");

        } catch (Exception e) {
            this.six = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "6" + "\")");
        }
        return six;
    }

    public MobileElement getSeven() {
        try {
            this.seven = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView");

        } catch (Exception e) {
            this.seven = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "7" + "\")");
        }
        return seven;
    }

    public MobileElement getEight() {
        try {
            this.eight = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.TextView");

        } catch (Exception e) {
            this.eight = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "8" + "\")");
        }
        return eight;
    }

    public MobileElement getNine() {
        try {
            this.nine = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.TextView");
        } catch (Exception e) {
            this.nine = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "9" + "\")");
        }
        return nine;
    }

    public MobileElement getPoint() {
        try {
            this.point = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[18]/android.widget.TextView");
        } catch (Exception e) {
            this.point = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "." + "\")");
        }
        return point;
    }

    public MobileElement getAdd() {
        try {
            this.add = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[10]/android.widget.TextView");
        } catch (Exception e) {
            this.add = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "+" + "\")");
        }
        return add;
    }

    public MobileElement getSubtract() {
        try {
            this.subtract = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[15]/android.widget.TextView");
        } catch (Exception e) {
            this.subtract = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "-" + "\")");
        }
        return subtract;
    }

    public MobileElement getMultiply() {
        try {
            this.multiply = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[9]/android.widget.TextView");
        } catch (Exception e) {
            this.multiply = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "x" + "\")");
        }
        return multiply;
    }

    public MobileElement getDivide() {
        try {
            this.divide = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[14]/android.widget.TextView");
        } catch (Exception e) {
            this.divide = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "/" + "\")");
        }
        return divide;
    }

    public MobileElement getEqual() {
        try {
            this.equal = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[19]/android.widget.TextView");
        } catch (Exception e) {
            this.equal = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "=" + "\")");
        }

        return equal;
    }

    public MobileElement getOk() {
        try {
            this.ok = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[20]/android.widget.TextView");
        } catch (Exception e) {
            this.ok = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "OK" + "\")");
        }
        return ok;
    }

    public MobileElement getAC() {
        try {
            this.AC = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.TextView");

        } catch (Exception e) {
            this.AC = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + "AC" + "\")");
        }
        return AC;
    }
}

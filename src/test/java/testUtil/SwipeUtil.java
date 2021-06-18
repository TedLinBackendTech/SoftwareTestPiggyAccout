package testUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class SwipeUtil {
    private AndroidDriver driver;

    public SwipeUtil(AndroidDriver driver) {
        this.driver = driver;
    }

    public void SwipeUp() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).press(PointOption.point(width / 2, height/2))
                .moveTo(PointOption.point(width / 2, height/2 - 200)).release()
                .perform();
    }

    // 下滑
    public void SwipeDown() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height/2 - 200))
                .moveTo(PointOption.point(width / 2, height/2)).release().perform();
    }

    // 左滑
    public void SwipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    // 右滑
    public void SwipeRight() {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }

}

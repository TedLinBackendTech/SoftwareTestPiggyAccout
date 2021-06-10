package testUtil;

import io.appium.java_client.android.AndroidDriver;

public class ElementUtil {
    private AndroidDriver driver;

    public ElementUtil(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean CheckTextByXpath(String text, String xpath) {
        return driver.findElementByXPath(xpath).getText().equals(text);
    }

    public void ClickByXpath(String xpath) {
        driver.findElementByXPath(xpath).click();
    }

    public void SendKeysByXpath(String keys, String xpath) {
        driver.findElementByXPath(xpath).sendKeys(keys);
    }
}

package APP;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

public class ReusableMethods {
    private AndroidDriver<MobileElement> driver;
    public ReusableMethods(AndroidDriver<MobileElement> driver)
    {
        this.driver=driver;

    }
    public void scrollText(String visibleText){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+".scrollIntoView(new UiSelector().text(\""+visibleText+"\"))"));
    }
    public void scrollToProductWithIDFilter(String Text){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\""+Text+"\"))"));
    }
    public void selectText(String visibleText){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+visibleText+"\"))")).click();
    }
    public void longPress(WebElement element){
        TouchAction TA=new TouchAction(driver);
        TA.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))).release().perform();
    }

}

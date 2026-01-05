package Scripts;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static Scripts.TestBase.driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KeyEvents {

    public static void main(String[] args) throws MalformedURLException {
        TestBase base = new TestBase();
        base.launchApp();
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        System.out.println("View Button clicked");
// BACK key
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

// ENTER key
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

// HOME key
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

// VOLUME UP / DOWN
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));

// POWER (lock/unlock)
       // driver.pressKey(new KeyEvent(AndroidKey.POWER));

// TAB
        driver.pressKey(new KeyEvent(AndroidKey.TAB));
        System.out.println("Tab performed");
// KEYBOARD SEARCH
        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));

        //space
        driver.longPressKey(new KeyEvent(AndroidKey.SPACE));
    }
}

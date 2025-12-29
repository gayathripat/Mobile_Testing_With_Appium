import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredcapabilities=new DesiredCapabilities();
        desiredcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        desiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredcapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"16");
        desiredcapabilities.setCapability("appPackage","io.appium.android.apis");
        desiredcapabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        desiredcapabilities.setCapability("automationName","UiAutomator2");

        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver(url,desiredcapabilities);
        System.out.println("APP Launch successfully");
        Thread.sleep(5000);
        driver.quit();
        System.out.println("APP terminated successfully");
        //text field
        driver.findElement(By.xpath("//*[@text=\"Views\"]")).click();




    }
    public static  void scrollText(AndroidDriver<MobileElement>driver, String visibleText){

    }
}

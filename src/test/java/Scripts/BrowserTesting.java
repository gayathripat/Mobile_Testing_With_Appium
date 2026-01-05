package Scripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class BrowserTesting {
   public WebDriver driver;
    public static void main(String[]args) throws MalformedURLException {
//        public void launchMobileChrome () {
//            System.setProperty("webdriver.chrome.driver", "D:\\APPIUM\\chrome-win64\\chrome-win64\\chrome.exe");
//
//            String deviceId = "emulator-5554"; // replace from adb devices
//
//            ChromeOptions options = new ChromeOptions();
//            options.setExperimentalOption("androidPackage", "com.android.chrome");
//            options.setExperimentalOption("androidUseRunningApp", true);
//            options.setExperimentalOption("androidDeviceSerial", deviceId);
//
//            driver = new ChromeDriver(options);
//            driver.get("https://www.google.com");
//        }
        TestBase base=new TestBase();
        AndroidDriver<MobileElement> driver=base.launchMobileChrome();

    }

}

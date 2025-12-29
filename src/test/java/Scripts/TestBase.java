package Scripts;

import APP.Constants;
import APP.LocatorPropertiesReader;
import APP.configReader;
import Utility.Reusables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static AndroidDriver<MobileElement> driver;
    Properties prop;


    public void launchApp() throws MalformedURLException {
        try{
            prop= configReader.loadConfig();
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,prop.getProperty("platformName"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("deviceName"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("automationName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,prop.getProperty("platformVersion"));
            caps.setCapability("appPackage",prop.getProperty("appPackage"));
            caps.setCapability("appActivity",prop.getProperty("appActivity"));
//            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//            caps.setCapability("automationName","UiAutomator2");
//            caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
//            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//            caps.setCapability("appPackage","io.appium.android.apis");
//            caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
            //caps.setCapability("app", "D://APPIUM//ApiDemos-debug.apk");

            //driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            //        URL url=new URL("http://127.0.0.1:4723/wd/hub");
//        AndroidDriver driver=new AndroidDriver(url,desiredcapabilities);
            driver=new AndroidDriver<>(new URL(prop.getProperty("appium.server.url")),caps);

            Constants.driver=driver;
            Constants.key=new Reusables(driver);
            Constants.Login= LocatorPropertiesReader.LoadLocator("login");
            System.out.println("App launch successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  static AndroidDriver<MobileElement> browser() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        caps.setCapability("chromedriver_autodownload", true);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
//        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"16");
//        caps.setCapability("appPackage","io.appium.android.apis");
//        caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformName","Android");
        caps.setCapability("appium.chromedriverExecutable", "D:/APPIUM/chrome-win64/chrome-win64.exe");
        driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        System.out.println("App launch successfully");
        return driver;

    }
    public   static AndroidDriver<MobileElement> launchGeneralStoreApp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
       // File appDir=new File("src");
       // File app=new File(appDir,"General-Store.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
       // caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
       // caps.setCapability("app", "D://APPIUM//General-Store.apk");
       caps.setCapability("appPackage","com.androidsample.generalstore");
      caps.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
      //  caps.setCapability("appium.chromedriverExecutable", "D:/APPIUM/chrome-win64/chrome-win64.exe");
        driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("App launch successfully");
return driver;

    }

    public void closeApp()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}

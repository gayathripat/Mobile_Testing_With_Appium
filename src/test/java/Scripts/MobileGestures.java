package Scripts;

import APP.ReusableMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

import static Scripts.TestBase.driver;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class MobileGestures extends TestBase{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        TestBase base = new TestBase();
        AndroidDriver<MobileElement> driver=launchGeneralStoreApp();
        driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("All Good");
        System.out.println("Entered Text in TextBox");
        driver.findElement(By.id("android:id/text1")).click();
        ReusableMethods reusable=new ReusableMethods(driver);
        reusable.scrollText("Australia");
        driver.findElement(By.xpath("//*[@text='Australia']")).click();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElementByClassName("android.widget.Button").click();

       // int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
       // System.out.println(count);
        for(int i=0;i<1;i++)
        {
            String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            System.out.println(text);
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        System.out.println("Added product finally");
        //Mobile Gestures tapping
        TouchAction t=new TouchAction(driver);
        WebElement checkbox=driver.findElementByClassName("android.widget.CheckBox");
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        driver.findElement(By.xpath("//*[@text='Visit to the website to complete purchase']")).click();
//LONG PRESS
//        WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
//        t.longPress(LongPressOptions.longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
//
////context to web view
       Thread.sleep(7000);
        Set<String> contexts=driver.getContextHandles();
        for(String contextNames:contexts)
        {
            System.out.println(contextNames);

        }
        driver.context("WEBVIEW_stetho_com.google.android.apps.messaging");





    }
}


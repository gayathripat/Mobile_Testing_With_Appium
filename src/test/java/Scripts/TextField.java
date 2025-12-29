package Scripts;

import APP.ReusableMethods;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static Scripts.TestBase.driver;

public class TextField {
    public static void main(String[] args) throws MalformedURLException {
        TestBase base = new TestBase();
        base.launchApp();
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        System.out.println("View Button clicked");
        ReusableMethods reusable=new ReusableMethods(driver);
        reusable.scrollText("TextFields");
        driver.findElement(By.xpath("//*[@text='TextFields']")).click();
        System.out.println("Text fields Button clicked");
        driver.findElement(By.xpath("//*[@text='hint text']")).sendKeys("Entering Text");
        System.out.println("Entered the text in text field");
        String getText=driver.findElement(By.id("io.appium.android.apis:id/edit")).getText();
        System.out.println("Entered the text in text field" + getText);

//        driver.findElementByAccessibilityId("id value");
//        driver.findElementByAndroidUIAutomator("attribute(\"value\")");
//        driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize();
//        driver.findElementByClassName("classnameValue");
//        driver.findElementByXPath("//tag[@text='value']");

    }
}

package Scripts;

import APP.ReusableMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static Scripts.TestBase.driver;

public class RadioButton {
    public static void main(String[] args) throws MalformedURLException {
        TestBase base = new TestBase();
        base.launchApp();
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        System.out.println("View Button clicked");
        ReusableMethods reusable=new ReusableMethods(driver);
        reusable.scrollText("Radio Group");
        driver.findElement(By.xpath("//*[contains(@text,'Radio Group')]")).click();
        System.out.println("Radio Button clicked");
        driver.findElement(By.xpath("//*[@text='All of them']")).click();
        System.out.println("All of them Button clicked");

        driver.findElement(By.xpath("//*[@text='Dinner']")).click();
        System.out.println("Dinner Button clicked");



    }


}

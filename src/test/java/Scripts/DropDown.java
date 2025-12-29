package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Clock;
import java.util.Collections;
import java.util.List;

import static Scripts.TestBase.driver;

public class DropDown {
    public static void main(String[]args) throws MalformedURLException {
        TestBase base=new TestBase();
        base.launchApp();
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        System.out.println("View Button clicked");
        driver.findElement(By.xpath("//*[contains(@text,'Controls')]")).click();
        System.out.println("Controls Button clicked");
        driver.findElement(By.xpath("//*[contains(@text,'2. Dark Theme')]")).click();
        System.out.println("Dark mode Button clicked");

        driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
        System.out.println("dropdown  Button clicked");
        WebDriverWait wait=new WebDriverWait(driver,10);
        List<WebElement> items= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("android:id/text1")));

        for(WebElement item:items)
        {
            if(item.getText().equals("Jupiter"))
            {
                item.click();
                break;
            }
        }
        base.closeApp();
    }
}

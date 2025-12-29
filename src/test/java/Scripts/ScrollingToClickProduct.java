package Scripts;

import APP.ReusableMethods;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;

import static Scripts.TestBase.driver;

public class ScrollingToClickProduct extends TestBase {
    public static void main(String[] args) throws MalformedURLException {
        TestBase base = new TestBase();
        AndroidDriver<MobileElement>  driver=launchGeneralStoreApp();
        driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("All Good");
       System.out.println("Entered Text in TextBox");
//
       driver.findElement(By.id("android:id/text1")).click();
        ReusableMethods reusable=new ReusableMethods(driver);
        reusable.scrollText("Australia");
        driver.findElement(By.xpath("//*[@text='Australia']")).click();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElementByClassName("android.widget.Button").click();
        //handling erro mesg when not enter text in  text box
     //   String toastMesg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
      //  System.out.println(toastMesg);
      // Assert.assertEquals("Please enter your name",toastMesg);
    //scroll to the product as per resource id first ,then  filtering item as per productname
        //reusable.scrollToProductWithIDFilter("Jordan 6 Rings");
    int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
    System.out.println(count);
    for(int i=0;i<count;i++)
    {
    String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
    System.out.println(text);
    if(text.equalsIgnoreCase("Jordan 6 Rings"))
    {
        String text1=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).getText();
        System.out.println(text1);
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        break;
    }
}

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        System.out.println("Added product finally");
    //validating selected product nam displaying correctly on chckout page or not
       WebDriverWait wait = new WebDriverWait(driver,10);

      String LastPageProduct=wait.until(ExpectedConditions.presenceOfElementLocated(
               By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]")
        )).getText();
//        WebElement product =
//                driver.findElement(MobileBy.AndroidUIAutomator(
//                        "new UiScrollable(new UiSelector().scrollable(true))" +
//                                ".scrollIntoView(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\"))"
//                ));

        //String LastPageProuct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        System.out.println(LastPageProduct);
Assert.assertEquals("Jordan 6 Rings",LastPageProduct);




    }
}

package Utility;

import APP.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reusables {
    WebDriver driver;
    public Reusables(WebDriver driver) {
        this.driver=driver;

    }

    public String click(String objectPath)
    {
        try{
            Constants.driver.findElement(By.xpath(objectPath)).click();
            return Constants.KEYWORD_PASS;
        } catch (Exception e) {
            System.out.println("unable to click :" +e.getMessage());
            return Constants.KEYWORD_FAIL;
        }
    }
public WebElement FindElement(String  locator){

           return  Constants.driver.findElement(By.xpath(locator));
}

}

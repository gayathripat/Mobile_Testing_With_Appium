package StepDef;

import APP.Constants;
import APP.ReusableMethods;
import Scripts.TestBase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static Scripts.TestBase.driver;

public class RB_StepDefinition  {

    TestBase base=new TestBase();
    ReusableMethods reusable=new ReusableMethods(driver);

    @When("I press {string}")
    public void iPress(String keyName) {

       // String keyName = "";
        AndroidKey key = AndroidKey.valueOf(keyName.toUpperCase());
        reusable.pressKey(key);
        //reusable.goBack();
    }

    @And("I long press {string}")
    public void iLongPress(String menuKey) {
//        String PeopleName= Constants.Login.getProperty("PeopleName");
//        WebElement peopleName=Constants.key.FindElement(PeopleName);
//        reusable.longPress(peopleName);
        AndroidKey key = AndroidKey.valueOf(menuKey.toUpperCase());
        reusable.longPressKey(key);
    }

    @Then("Key actions should be executed successfully")
    public void keyActionsShouldBeExecutedSuccessfully() {

    }
}

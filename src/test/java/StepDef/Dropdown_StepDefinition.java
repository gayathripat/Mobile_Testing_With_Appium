package StepDef;

import APP.Constants;
import APP.ReusableMethods;
import Scripts.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;

import static Scripts.TestBase.driver;

public class Dropdown_StepDefinition extends TestBase {
    TestBase base=new TestBase();
    ReusableMethods reusable;
    @Given("User launches API Demo App")
    public void userLaunchesAPIDemoApp() throws MalformedURLException {
        base.launchApp();
//        AndroidDriver<MobileElement> driver= browser();
//        driver.get("https://google.com");
         reusable=new ReusableMethods(driver);
        System.out.println("App launch successfully");
    }
    @And("User click on views button")
    public void userClickOnViewsButton() {
        String Views=Constants.Login.getProperty("Views");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(Views));
//        driver.findElement(By.xpath("//*[@text='Views']")).click();
        System.out.println("View Button clicked");
    }
    @And("User click on Controls button")
    public void userClickOnControlsButton() {
        String Controls=Constants.Login.getProperty("Controls");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(Controls));
        //   driver.findElement(By.xpath("//*[contains(@text,'Controls')]")).click();
        System.out.println("Controls Button clicked");
    }

    @When("User navigates to Dark Theme dropdown section")
    public void userNavigatesToDarkThemeDropdownSection() {
        String DarkTheme=Constants.Login.getProperty("DarkTheme");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(DarkTheme));
      //  driver.findElement(By.xpath("//*[contains(@text,'2. Dark Theme')]")).click();
        System.out.println("Dark mode Button clicked");
    }

    @And("User selects {string}from dropdown")
    public void userSelectsFromDropdown(String option) {
        driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
        System.out.println("dropdown  Button clicked");
        WebDriverWait wait=new WebDriverWait(driver,20);
        List<WebElement> items=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("android:id/text1")));
        for(WebElement item:items)

        {
            System.out.println(item.getText());
            if(item.getText().equals(option))
            {
                System.out.println(item.getText());
                item.click();
                break;
            }
        }
    }

    @Then("Dropdown selection should be completed")
    public void dropdownSelectionShouldBEcompleted() {
System.out.println("Dropdown select validated successfully");
    }

    @When("User navigates to Radio Group section")
    public void userNavigatesToRadioGroupSection() {
        ReusableMethods reusable=new ReusableMethods(driver);
        reusable.scrollText("Radio Group");
        ReusableMethods ClickText=new ReusableMethods(driver);
        reusable.selectText("Radio Group");

       // driver.findElement(By.xpath("//*[contains(@text,'Radio Group')]")).click();
        System.out.println("Radio Button clicked");
    }
    @When("click on  All of them section")
    public void clickOnAllOfThemSection() {
        String AllOfThemOption=Constants.Login.getProperty("AllOfThem");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(AllOfThemOption));
//        driver.findElement(By.xpath("//*[@text='All of them']")).click();
        System.out.println("All of them Button clicked");
    }

    @And("User click on  {string} button")
    public void userClickOnButton(String arg0) {
        String DinnerBtn=Constants.Login.getProperty("Dinner");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(DinnerBtn));
       // driver.findElement(By.xpath("//*[@text='Dinner']")).click();
        System.out.println("Dinner Button clicked");

    }

    @And("^User click (Views|App) option from home page")
    public void userClickAppOptionFromHomePage(String value) {
      if(value.equalsIgnoreCase("Views"))
      {
          String Views=Constants.Login.getProperty("Views");
          Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(Views));
          System.out.println("View Button clicked");
      }if(value.equalsIgnoreCase("App"))
        {
          String App=Constants.Login.getProperty("App");
          Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(App));
          System.out.println("App Button clicked");
      }
    }

    @And("User click on Alert Dialogs")
    public void userClickOnAlertDialogs() {
        String AlertD=Constants.Login.getProperty("AlertDialog");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(AlertD));
        System.out.println("Alert dialog option selected");
    }

    @Then("^User click on (OK|CANCEL) button on alert message")
    public void userClickOnOKButtonOnAlertMessage(String value) {
        if(value.equalsIgnoreCase("OK")){
            String OK=Constants.Login.getProperty("OK");
            Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(OK));
            Alert alert=driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert dialog ok button clicked");
        }
        if(value.equalsIgnoreCase("CANCEL")){
            String cancel=Constants.Login.getProperty("CANCEL");
            Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(cancel));
            Alert alert=driver.switchTo().alert();
            alert.dismiss();
            System.out.println("Alert dialog cancel button clicked");
        }

    }


    @And("User click on Expandable Lists")
    public void userClickOnExpandableLists() {
        String ExpandableList=Constants.Login.getProperty("ExpandableList");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(ExpandableList));
        System.out.println("ExpandableList option selected");
    }

    @Then("User click on Custom Adapter")
    public void userClickOnCustomAdapter() {
        String CustomAdapter=Constants.Login.getProperty("CustomAdapter");
        Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.click(CustomAdapter));
        System.out.println("Custom adapter option selected");
    }

    @And("User Perform long press on people Names")
    public void userPerformLongPressOnPeopleNames() {
        String PeopleName=Constants.Login.getProperty("PeopleName");
    WebElement peopleName=Constants.key.FindElement(PeopleName);
    reusable.longPress(peopleName);
    }

    @Then("Verify context menu")
    public void verifyContextMenu() {
        String CMenu=Constants.Login.getProperty("SampleAction");
        WebElement ContextMenu=Constants.key.FindElement(CMenu);
        System.out.println(ContextMenu.getText());
    }
}

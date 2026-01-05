package Scripts;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import static APP.Constants.driver;


public class DragAndDrop {


        public  static void dragAndDrop(AppiumDriver driver, WebElement source, WebElement target) {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence dragAndDrop = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(source), 0, 0))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.fromElement(target), 0, 0))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        //    driver.perform(List.<Sequence>of(dragAndDrop));
        }
    public static void doubleTap(WebElement element) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence doubleTap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(element),
                        element.getSize().width/2, element.getSize().height/2))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

       // driver.perform(List.of(doubleTap));
    }

        public static void main(String[] args) {
            // Example usage
            WebElement src = driver.findElement(By.id("com.example:id/dragItem"));
            WebElement dest = driver.findElement(By.id("com.example:id/dropZone"));

            dragAndDrop(driver, src, dest);
        }

}

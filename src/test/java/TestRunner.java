import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/test/java/Features",glue = "StepDef",plugin = {"pretty","html:target/report.html"}, monochrome=true,tags="@T_02,@T_01")
public class TestRunner {


}

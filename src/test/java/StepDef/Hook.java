package StepDef;

import Utility.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;

import java.io.IOException;

public class Hook {



        public static ExtentReports extent;



    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

        @BeforeAll
        public static void startReport() throws IOException {
            extent = ExtentManager.getExtent();
        }
        @Before
        public void beforeScenario(Scenario scenario) {

            ExtentTest extentTest = extent.createTest(scenario.getName());
            test.set(extentTest);


        }


        @AfterStep


        public void afterstep(Scenario scenario) {


            if (scenario.isFailed()) {


                test.get().fail("step Failed");

            }


        }


        @After


        public void afterScenario(Scenario scenario) {


            if (scenario.isFailed()) {


                test.get().fail("Scenario Failed");


            } else {


                test.get().pass("Scenario Passed");


            }


        }


        @AfterAll


        public static void flushReport(){


            extent.flush();


        }
}

package RunnerClass;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static BaseMethod.Baseclass.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFile/makemytrip.feature",
        glue = "StepDefination"
)
public class runnerclass {

    @BeforeClass
    public static void start(){
        initializeBrowser();
        WebPageurl("https://www.makemytrip.com/");
        dismissAlert();

    }
    @AfterClass
    public static void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
        System.out.println("Browser closed successfully");
    }
}

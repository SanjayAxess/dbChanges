package Runner;

import Base.Baseclass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        glue = "Stepdefinition")

public class Runnerclass extends Baseclass {

    @BeforeClass
    public static void launchdriver() {
        web();
        maximize();
        impwait();
    }

    public static void closepage(){
        Back();
    }

}

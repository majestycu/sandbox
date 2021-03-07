package Sandbox;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/SandboxFeatures"},
        glue = {"Sandbox.Steps"}
)

public class RunnerClass {

}
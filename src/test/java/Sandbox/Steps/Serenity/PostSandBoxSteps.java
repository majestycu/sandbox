package Sandbox.Steps.Serenity;

import Sandbox.Steps.Serenity.Steps.*;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class PostSandBoxSteps extends ScenarioSteps {

    @Steps
    public PostSandboxSteps postSteps;


    @Given("I create a SandBox with name: {string}")
    public void postSandboxesWithName(String name) {
        postSteps.createNewSandboxWithGivenName(name); }

    @Given("I create a SandBox with random name")
    public void postSandboxesWithName() {
        postSteps.createNewSandbox(); }

}

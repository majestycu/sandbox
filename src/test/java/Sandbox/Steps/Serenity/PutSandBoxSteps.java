package Sandbox.Steps.Serenity;

import Sandbox.Steps.Serenity.Steps.PutSandboxSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import static Sandbox.Steps.Serenity.Steps.CommonSteps.GenerateName;

public class PutSandBoxSteps extends ScenarioSteps {

    @Steps
    public PutSandboxSteps putSandboxSteps;

    @When("I modify the previously created sandbox with name: {string}")
    public void modifyPreviouslyCreatedSandboxWithGivenName(String name){
        putSandboxSteps.updatePreviouslyCreatedSandboxWithName(name);
    }

    @When("I modify the previously created sandbox with random name")
    public void modifyPreviouslyCreatedSandboxWithRandomName(){
        String newName = GenerateName();
        Serenity.getCurrentSession().put("new name", newName);
        putSandboxSteps.updatePreviouslyCreatedSandboxWithName(newName);
    }

    @Then("I modify the previously created sandbox with description: {string}")
    public void updatePreviouslyCreatedSandboxWithCustomDescription(String customDescription){
        putSandboxSteps.updatePreviouslyCreatedSandboxWithCustomDescription(customDescription);
    }
}

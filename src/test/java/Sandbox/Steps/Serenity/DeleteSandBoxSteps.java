package Sandbox.Steps.Serenity;

import Sandbox.Steps.Serenity.Steps.DeleteSandboxSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class DeleteSandBoxSteps extends ScenarioSteps {

    @Steps
    public DeleteSandboxSteps deleteSandboxSteps;


    @When("I try to delete the previously created Sandbox")
    public void deletePreviouslyCreatedSandbox(){
        deleteSandboxSteps.deletePreviouslyCreatedSandbox();
    }

    @Given("I try to delete the sandbox name: {string}")
    @When("Sandbox name: {string} gets deleted")
    public void deletePreviouslyCreatedSandboxWithGivenName(String customName){
        deleteSandboxSteps.deleteSandboxByName(customName);
    }

    @Then("I try to delete the state on previously created Sandbox")
    public void stateDeletePreviouslyCreatedSandbox(){
        deleteSandboxSteps.deletePreviouslyCreatedSandboxState();
    }

}

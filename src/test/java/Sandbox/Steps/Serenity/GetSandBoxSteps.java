package Sandbox.Steps.Serenity;

import Sandbox.Steps.Serenity.Steps.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class GetSandBoxSteps extends ScenarioSteps {

    @Steps
    public GetSandboxSteps getSteps;

    @Given("I make a GET request on the previously created SandBox")
    public void getSandboxes() {
        getSteps.getPreviouslyCreatedSandbox();
    }

    @Given("I make a GET request on Search Activity with queryParam: {string} and value: {string}")
    public void getSearchActivity(String key, String value) {
        getSteps.getRequestActivityWithQueryParam(key, value);
    }

    @Given("I make a GET request on sandboxName: {string}")
    public void getSandboxByName(String sanboxName) {
        getSteps.getRequestWithSandboxName(sanboxName);
    }

    @Given("I make a GET request with auth key: {string}")
    public void getSandBoxWithSpecificAuthKeyHeader(String key) {
        getSteps.tryGetSandboxWithAuthKey(key);
    }

    @Then("I make a GET request on previously created Sandbox")
    public void getThePreviouslyCreatedSandbox() {
        getSteps.getPreviouslyCreatedSandbox();
    }

    @Then("I make a GET fork request on previously created Sandbox")
    public void getForkOfPrevioslyCreatedSandBox() {
        getSteps.forkPreviouslyCreatedSandbox();
    }

    @Then("I make a GET state request on previously created Sandbox")
    public void getStateOfPrevioslyCreatedSandBox() {
        getSteps.getPreviouslyCreatedSandboxState();
    }
}

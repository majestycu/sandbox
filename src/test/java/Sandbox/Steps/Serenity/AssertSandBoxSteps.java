package Sandbox.Steps.Serenity;

import Sandbox.Steps.Serenity.Steps.AssertionSteps;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class AssertSandBoxSteps extends ScenarioSteps {

    @Steps
    public AssertionSteps assertionSteps;

    @Then("the response status code is {string}")
    public void theResponseShouldContainHttpCode(String httpCodeInput) {
        assertionSteps.assertStatusCode(Integer.parseInt(httpCodeInput));
    }

    @Then("the response error message is {string}")
    public void assertSandboxMessage(String errorMessageInput) {
        assertionSteps.assertErrorMessage(errorMessageInput);
    }

    @Then("the response should contain the correct details for description: {string}")
    public void assertDescriptionForResponse(String description) {
        assertionSteps.assertSandBoxDescription(description);
    }

    @Then("the response should contain the newly updated sandbox name: {string}")
    public void assertNameForResponse(String name) {
        assertionSteps.assertSandBoxName(name);
    }

    @Then("the response should contain the newly updated sandbox name")
    public void assertNameForResponse() {
        String prevName = (String) Serenity.getCurrentSession().get("new name");
        assertionSteps.assertSandBoxName(prevName);
    }

    @Then("the response should contain the correct details for ownerOrganisation name: {string}")
    public void assertOwnerOrganisationNameResponse(String orgName) {
        assertionSteps.assertOwnerOrganisationName(orgName);
    }

    @Then("the response should contain the correct details for ownerOrganisation billingEmail: {string}")
    public void assertOwnerOrganisationBillingEmailResponse(String billingEmail) {
        assertionSteps.assertOwnerOrganisationBillingEmail(billingEmail);
    }

}

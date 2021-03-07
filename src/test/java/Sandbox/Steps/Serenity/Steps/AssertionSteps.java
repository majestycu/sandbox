package Sandbox.Steps.Serenity.Steps;

import Sandbox.Objects.ErrorMessageObj;
import Sandbox.Objects.ResponseSandboxObject;
import io.restassured.response.Response;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class AssertionSteps extends ScenarioSteps {

    public static void assertStatusCode(Integer statusCode) {
        Assert.assertEquals((int) statusCode, CommonSteps.getPreviousResponse().getStatusCode());
    }

    public static void assertErrorMessage(String error) {
        Response response = CommonSteps.getPreviousResponse();
        ErrorMessageObj errorMessage = response.as(ErrorMessageObj.class);
        Assert.assertEquals(error, errorMessage.errors.get(0).message);
    }

    public static void assertSandBoxDescription(String description){
        Response response = CommonSteps.getPreviousResponse();
        ResponseSandboxObject sandboxObject = response.as(ResponseSandboxObject.class);
        Assert.assertEquals(description, sandboxObject.getDescription());
    }

    public static void assertSandBoxName(String name){
        Response response = CommonSteps.getPreviousResponse();
        ResponseSandboxObject sandboxObject = response.as(ResponseSandboxObject.class);
        Assert.assertEquals(name, sandboxObject.getName());
    }

    public static void assertOwnerOrganisationName(String name){
        Response response = CommonSteps.getPreviousResponse();
        ResponseSandboxObject sandboxObject = response.as(ResponseSandboxObject.class);
        Assert.assertEquals(name, sandboxObject.getOwnerOrganisation().getName());
    }
    public static void assertOwnerOrganisationBillingEmail(String billingEmail){
        Response response = CommonSteps.getPreviousResponse();
        ResponseSandboxObject sandboxObject = response.as(ResponseSandboxObject.class);
        Assert.assertEquals(billingEmail, sandboxObject.getOwnerOrganisation().getBillingEmail());
    }
}


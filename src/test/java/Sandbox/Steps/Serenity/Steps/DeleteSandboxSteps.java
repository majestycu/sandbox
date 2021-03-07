package Sandbox.Steps.Serenity.Steps;

import Helpers.ApiHelper;
import Sandbox.Objects.ResponseSandboxObject;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;

import static Sandbox.Steps.Serenity.Steps.CommonSteps.getSandboxesPath;

public class DeleteSandboxSteps extends ScenarioSteps {

    public static void deletePreviouslyCreatedSandbox() {
        Response previousResponse = CommonSteps.getPreviousResponse();
        ResponseSandboxObject sandboxObject = previousResponse.as(ResponseSandboxObject.class);
        var response = new ApiHelper().Delete(getSandboxesPath + "/" + sandboxObject.getName());
        Serenity.getCurrentSession().put("response", response);
    }

    public static void deleteSandboxByName(String customName) {
        var response = new ApiHelper().Delete(getSandboxesPath + "/" + customName);
        Serenity.getCurrentSession().put("response", response);
    }

    public static void deletePreviouslyCreatedSandboxState() {
        Response previousResponse = CommonSteps.getPreviousResponse();
        ResponseSandboxObject sandboxObject = previousResponse.as(ResponseSandboxObject.class);
        var response = new ApiHelper().Delete(getSandboxesPath + "/" + sandboxObject.getName() +"/state");
        Serenity.getCurrentSession().put("response", response);
    }
}
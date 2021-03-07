package Sandbox.Steps.Serenity.Steps;

import Helpers.ApiHelper;
import io.restassured.http.Header;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;

import static Sandbox.Steps.Serenity.Steps.CommonSteps.getActivitySearch;
import static Sandbox.Steps.Serenity.Steps.CommonSteps.getSandboxesPath;

public class GetSandboxSteps extends ScenarioSteps {

    public void getRequestActivityWithQueryParam(String key, String value) {
        var response = new ApiHelper().Get(getActivitySearch, key, value);
        Serenity.getCurrentSession().put("response", response);
    }

    public void getRequestWithSandboxName(String sandBoxName) {
        var response = new ApiHelper().Get(getSandboxesPath + "/" + sandBoxName);
        Serenity.getCurrentSession().put("response", response);
    }

    public void tryGetSandboxWithAuthKey(String key) {
        var response = new ApiHelper().Get(getSandboxesPath, new Header("API-Key" ,key));
        Serenity.getCurrentSession().put("response", response);
    }

    public void getPreviouslyCreatedSandbox() {
        var response = new ApiHelper().Get(getSandboxesPath + "/" + CommonSteps.getPreviouslyCreatedSandBoxObj().name);
        Serenity.getCurrentSession().put("response", response);
    }

    public void forkPreviouslyCreatedSandbox() {
        var response = new ApiHelper().Get(getSandboxesPath + "/" + CommonSteps.getPreviouslyCreatedSandBoxRespObj().getName() + "/fork");
        Serenity.getCurrentSession().put("response", response);
    }

    public void getPreviouslyCreatedSandboxState() {
        var response = new ApiHelper().Get(getSandboxesPath + "/" + CommonSteps.getPreviouslyCreatedSandBoxRespObj().getName() + "/state");
        Serenity.getCurrentSession().put("response", response);
    }
}
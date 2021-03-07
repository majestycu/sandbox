package Sandbox.Steps.Serenity.Steps;

import Helpers.ApiHelper;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;

import static Sandbox.Steps.Serenity.Steps.CommonSteps.getSandboxesPath;

public class PostSandboxSteps extends ScenarioSteps {

    public static void createNewSandboxWithGivenName(String name) {
        var response = new ApiHelper().Post(getSandboxesPath, CommonSteps.generateSandBoxObject(name));
        Serenity.getCurrentSession().put("response", response);
    }
    public static void createNewSandbox() {
        var sandbox = CommonSteps.generateSandBoxObject();
        var response = new ApiHelper().Post(getSandboxesPath, sandbox);
        Serenity.getCurrentSession().put("response", response);
        Serenity.getCurrentSession().put("sandbox", sandbox);
    }
}
package Sandbox.Steps.Serenity.Steps;

import Helpers.ApiHelper;
import Sandbox.Objects.SandboxCreateObject;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;

import static Sandbox.Steps.Serenity.Steps.CommonSteps.getSandboxesPath;

public class PutSandboxSteps extends ScenarioSteps {

    public void updatePreviouslyCreatedSandboxWithName(String name) {
        SandboxCreateObject sandbox = CommonSteps.getPreviouslyCreatedSandBoxObj();
        String prevSandBoxName = sandbox.name;
        SandboxCreateObject body = new SandboxCreateObject(name, sandbox.description);
        var response = new ApiHelper().Put(getSandboxesPath + "/" + prevSandBoxName, body);
        Serenity.getCurrentSession().put("response", response);
    }


    public void updatePreviouslyCreatedSandboxWithCustomDescription(String description) {
        SandboxCreateObject sandbox = CommonSteps.getPreviouslyCreatedSandBoxObj();
        String prevSandBoxName = sandbox.name;
        SandboxCreateObject body = new SandboxCreateObject(sandbox.name, description);
        var response = new ApiHelper().Put(getSandboxesPath + "/" + prevSandBoxName, body);
        Serenity.getCurrentSession().put("response", response);
    }

}
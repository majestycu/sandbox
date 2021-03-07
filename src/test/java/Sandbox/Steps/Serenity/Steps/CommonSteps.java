package Sandbox.Steps.Serenity.Steps;

import Sandbox.Objects.ErrorMessageObj;
import Sandbox.Objects.ResponseSandboxObject;
import Sandbox.Objects.SandboxCreateObject;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class CommonSteps {

    public static final String getSandboxesPath = "https://getsandbox.com/api/1/sandboxes";
    public static final String getActivitySearch = "https://getsandbox.com/api/1/activity/search";
    public static final String gitUrl = "http://git.getsandbox.com/testbox.git";
    public static final String sandBoxUrl = "http://testbox.getsandbox.com";
    public static final String transport = "HTTP";
    public static final String stackType = "JavaScript";
    public static final String runtimeV = "VERSION_2";
    public static final String proxy = "STARTED";
    public static final String description = "this is a description";

    public static SandboxCreateObject getPreviouslyCreatedSandBoxObj(){
        return (SandboxCreateObject) Serenity.getCurrentSession().get("sandbox");
    }

    public static Response getPreviousResponse(){
        return (Response) Serenity.getCurrentSession().get("response");
    }

    public static ResponseSandboxObject getPreviouslyCreatedSandBoxRespObj(){
        Response response = (Response) Serenity.getCurrentSession().get("response");
        return response.as(ResponseSandboxObject.class);
    }

    public static SandboxCreateObject generateSandBoxObject(){
       return new SandboxCreateObject(GenerateName().toLowerCase(), description);
    }

    public static SandboxCreateObject generateSandBoxObject(String name){
       return new SandboxCreateObject(name.toLowerCase(), description);
    }

    public static String GenerateName(){
        return "testname" + (int) (Math.random() * 9999999);
    }

    public void saveErrorMessageFromResponse(Response response) {
        ErrorMessageObj errorMessage = response.as(ErrorMessageObj.class);
        Serenity.getCurrentSession().put("errorMessage", errorMessage);
    }
}

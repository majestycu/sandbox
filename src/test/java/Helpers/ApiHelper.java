package Helpers;

import Sandbox.Objects.SandboxCreateObject;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static final Header HEADER = new Header("API-Key", "api-5d705852-ad30-4098-ad23-cb73dafbfcca");


    public Response Post(String path, SandboxCreateObject body) {
        Response response = given().contentType("application/json")
                .header(HEADER)
                .body(body)
                .when().post(path)
                .then().extract().response();
        return response;
    }

    public Response Get(String path) {
        Response response = given().contentType("application/json")
                .given().header(HEADER)
                .get(path).then().extract().response();
        return response;
    }

    public Response Get(String path, Header header) {
        Response response = given().contentType("application/json")
                .given().header(header)
                .get(path).then().extract().response();
        return response;
    }

    public Response Get(String path, String key, String value) {
        Response response = given().contentType("application/json")
                .given()
                .header(HEADER)
                .queryParam(key,value)
                .get(path).then().extract().response();
        return response;
    }

    public Response Put(String path, SandboxCreateObject body) {
        Response response = given().contentType("application/json")
                .header(HEADER)
                .body(body)
                .when().put(path)
                .then().extract().response();
        return response;
    }

    public Response Delete(String path) {
        Response response = given().contentType("application/json")
                .header(HEADER)
                .when().delete(path)
                .then().extract().response();
        return response;
    }
}

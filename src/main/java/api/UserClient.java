package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {
    private static final String PATH = "api/auth";

    @Step("Log in user via API")
    public ValidatableResponse login(UserCredentials credentials) {
        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post(PATH + "/login")
                .then()
                ;
    }

    @Step("Delete user via API")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getSpec())
                .header("authorization", accessToken)
                .when()
                .delete(PATH + "/user")
                .then()
                ;
    }
}

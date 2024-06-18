package api;

import io.qameta.allure.Step;

import models.authorization.AuthRequestModel;

import static io.restassured.RestAssured.given;
import static specs.TestSpecifications.requestSpecification;
import static specs.TestSpecifications.responseSpecification;

public class AuthorizationApi {
    @Step("Авторизация пользователя")
    public AuthRequestModel authorize (AuthRequestModel authRequestModel) {
        return given()
                .spec(requestSpecification)
                .body(authRequestModel)
                .when()
                .post("https://accounts.pyrus.com/api/v4/auth")
                .then()
                .spec(responseSpecification(200))
                .extract().response().as(AuthRequestModel.class);
    }
}

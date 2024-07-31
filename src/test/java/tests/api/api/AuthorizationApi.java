package tests.api.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import tests.api.models.authorization.*;
import tests.api.specs.TestSpecifications;

import static io.restassured.RestAssured.given;
import static tests.api.specs.TestSpecifications.requestSpecification;

public class AuthorizationApi {
    @Step("Авторизация пользователя")
    public AuthResponseModel authorize(AuthRequestModel authRequestModel) {
        return given()
                .spec(requestSpecification)
                .body(authRequestModel)
                .contentType(ContentType.JSON)
                .when()
                .post("https://accounts.pyrus.com/api/v4/auth")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(AuthResponseModel.class);
    }
}

package api;

import io.qameta.allure.Step;

import io.restassured.http.ContentType;
import models.authorization.AuthRequestModel;
import models.authorization.AuthResponseModel;
import specs.TestSpecifications;

import static io.restassured.RestAssured.given;
import static specs.TestSpecifications.requestSpecification;
import static specs.TestSpecifications.responseSpecification;

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

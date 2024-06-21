package tests.api;

import api.AuthorizationApi;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.Getter;
import models.authorization.AuthRequestModel;
import models.authorization.AuthResponseModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.TestSpecifications.responseSpecification;

public class AuthTest{
    @Getter
    TestData testData = new TestData();

    @Test
    void apiTests() {
        AuthRequestModel authRequestModel = new AuthRequestModel(testData.USERNAME, testData.SECURITY_KEY);
        System.out.println("Авторизация пользователя: " + authRequestModel);

        AuthResponseModel authResponse = given()
                .body(authRequestModel)
                .contentType(ContentType.JSON)
                .when()
                .post("https://accounts.pyrus.com/api/v4/auth")
                .then()
                .spec(responseSpecification(200))
                .extract().as(AuthResponseModel.class);

        String accessToken = authResponse.getAccess_token();
        System.out.println("Токен доступа: " + accessToken);
    }
}
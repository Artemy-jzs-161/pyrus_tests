package tests.api;

import api.MemberApi;
import extensions.*;
import models.members.*;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import specs.TestSpecifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AuthParameterResolver.class)
public class MembersTests extends TestBase {
    private MemberApi memberApi;
    private String accessToken;

    @BeforeEach
    @Step("Получение токена")
    void setUp(@AuthToken String authToken) {
        this.accessToken = authToken;
        System.out.println("Токен доступа: " + accessToken);
    }

    @Test
    @Authorization
    @DisplayName("добавление пользователя")
    void postTest() {
        Member newMember = new Member("Иван", "Иванов", "ivan.ivanov@company.com",
                "Заболел", "+71234567890", "ivan.ivanov", "developer");
        Member createdMemberResponse = memberApi.createMember(newMember);

        assertEquals("ivan.ivanov@company.com", newMember.getEmail());

        // Выводим полученных пользователей
        System.out.println("Созданный пользователь: " + createdMemberResponse);
    }


    @Test
    @Authorization
    @DisplayName("Получение всех пользователей организации")
    void getAllMembersTest() {

        MembersResponseModel membersResponse = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("v4/members")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(MembersResponseModel.class);

        // Выводим полученных пользователей
        System.out.println("Список пользователей: " + membersResponse);
    }

    @Test
    @Authorization
    @DisplayName("Получение пользователя организации по id")
    void getIdMemberTest() {
        Member member = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("v4/members/1108384")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(Member.class);

        // Выводим полученных пользователей
        System.out.println("Список пользователей: " + member);
    }

    @Test
    @Authorization
    @DisplayName("Получение пользователя организации по id")
    void getIncorrectIdMemberTest() {
        Member member = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("v4/members/999999")
                .then()
                .spec(TestSpecifications.responseSpecification(403))
                .extract().as(Member.class);

        // Выводим полученных пользователей
        System.out.println("Список пользователей: " + member);
    }

    @Test
    @Authorization
    @DisplayName("Получение пользователя организации по id")
    void deleteIdMemberTest() {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete("v4/members/1112029")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .body("success", equalTo(true));
    }

    @Test
    @Authorization
    @DisplayName("Получение пользователя организации по id")
    void deleteIncorrectIdMemberTest() {
        Member member = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete("v4/members/999999")
                .then()
                .spec(TestSpecifications.responseSpecification(200))
                .extract().as(Member.class);

        // Выводим полученных пользователей
        System.out.println("Список пользователей: " + member);
    }


}
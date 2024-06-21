package tests.api;

import api.MemberApi;
import extensions.*;
import models.members.*;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import specs.TestSpecifications;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;


    /*
        Member newMember = new Member("Петр", "Петров", "petr.petrov@company.com", "здоров", false, "developer" , "skypePetrov", "+71234567895", 1235);
        */

@ExtendWith(AuthParameterResolver.class)
public class MembersTests extends TestBase {
    private MemberApi memberApi;
    private String accessToken;

    @BeforeEach
    @Step("Получение токена")
    void setUp(@AuthToken String authToken) {
        this.accessToken = authToken;
        System.out.println("Токен доступа: " + accessToken);
        this.memberApi = new MemberApi(accessToken);
    }

    @Test
    @Authorization
    @DisplayName("Получение всех пользователей")
    void getAllMembersTest() {
        MembersResponseModel membersResponse = memberApi.getAllMember();
        System.out.println("Созданный пользователь: " + membersResponse);

        step("Проверка, что список пользователей не пустой", () -> {
            assertNotNull(membersResponse, "Ответ не должен быть null");
            assertFalse(membersResponse.getMembers().isEmpty(), "Список пользователей не должен быть пустым");
        });
    }

    @Test
    @Authorization
    @DisplayName("Получение пользователя по id")
    void getIdMembersTest() {
        Member member = memberApi.getMember("1112147");
        System.out.println("Пользователь: " + member);

        step("Проверка, что список пользователей не пустой", () -> {
            assertNotNull(memberApi, "Ответ не должен быть null");
            assertEquals("Иванов", memberApi.getMember(String.valueOf(1112147)).getLastName());
        });
    }

    @Test
    @Authorization
    @DisplayName("Получение пользователя по несуществующему id")
    void getIncorrectIdMemberTest() {
        Member member = memberApi.getMember("999999999");
        System.out.println("Пользователь: " + member);

        step("Проверка, что список пользователей не пустой", () -> {
            assertNotNull(memberApi, "Ответ не должен быть null");
            assertEquals("999999999", memberApi.getMember(String.valueOf(999999999)).getId());
        });
    }



}

/*

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

*/

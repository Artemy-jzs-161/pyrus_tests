package tests.api;

import api.MemberApi;
import extensions.*;
import data.models.members.*;

import io.qameta.allure.Step;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;


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
    @Tag("api")
    @Authorization
    @DisplayName("Получение всех сотрудников")
    void getAllMembersTest() {
        MembersResponseModel membersResponse = memberApi.getAllMember();
        System.out.println("Созданный пользователь: " + membersResponse);

        step("Проверка, что список сотрудников не пустой", () -> {
            assertNotNull(membersResponse, "Ответ не должен быть null");
            assertFalse(membersResponse.getMembers().isEmpty(), "Список пользователей не должен быть пустым");
        });
    }




    @Test
    @Tag("api")
    @Authorization
    @DisplayName("Получение сотрудника по id")
    void getIdMembersTest() {
        Member member = memberApi.getMember("1120425");
        System.out.println("Пользователь: " + member);

        step("Проверка, что список сотрудников не пустой", () -> {
            assertNotNull(memberApi, "Ответ не должен быть null");
            assertEquals("Иванов", memberApi.getMember(String.valueOf(1120425)).getLastName());
        });
    }

    @Test
    @Authorization
    @DisplayName("Получение сотрудника по несуществующему id")
    void getIncorrectIdMemberTest() {
        Member member = memberApi.getMember("999999999");
        System.out.println("сотрудник: " + member);

        step("Проверка, что список сотрудников не пустой", () -> {
            assertNotNull(memberApi, "Ответ не должен быть null");
            assertEquals("999999999", memberApi.getMember(String.valueOf(999999999)).getId());
        });
    }

    @Test
    @Authorization
    @DisplayName("Добавление нового сотрудника")
    void addNewMemberTest() {
        MembersRequestModel PETROV = new MembersRequestModel(
                "vasya", "vasyaa", "vasya.vasya@company.com",
                "developer", 123, "vasya.vasya", "71234562222", "Бродяга");

        MembersRequestModel member = memberApi.createMember(PETROV);
        System.out.println("Пользователь: " + member);

        step("Проверка создания пользователя", () -> {
            assertNotNull(memberApi, "Ответ не должен быть null");
            assertEquals(PETROV.getFirstName(), member.getFirstName(), "Имя пользователя не совпадает");
        });
    }

    @Test
    @Authorization
    @DisplayName("Изменение данных пользователя по ID")
    void changeMemberTest() {
        MembersRequestModel PETROV = new MembersRequestModel(
                "vasya", "vasyaa", "vasya.vasya@company.com",
                "developer", 123, "vasya.vasya", "71234562222", "Бродяга");

        MembersRequestModel KATYA = new MembersRequestModel(
                "KATYA", "KATYA", "KATYA.vasya@company.com",
                "model", 123, "KATYA.vasya", "71234562222", "blond");

        MembersRequestModel member = memberApi.createMember(PETROV);

        MembersRequestModel member1 = memberApi.updateMember(member.getId(), KATYA);
        assertEquals(KATYA.getFirstName(), member1.getFirstName(), "Имя пользователя не совпадает");
    }

    @Test
    @Authorization
    @DisplayName("Удаление пользователя по ID")
    void deleteMemberTest() {
        MembersRequestModel PETROV = new MembersRequestModel(
                "vasya", "vasyaa", "vasya.vasya@company.com",
                "developer", 123, "vasya.vasya", "71234562222", "Бродяга");

        MembersRequestModel member = memberApi.createMember(PETROV);
        Member member1 = memberApi.deleteMember(member.getId());
        System.out.println(member1);

        step("Проверка изменения пользователя", () -> {
            assertTrue(member1.isBanned(), "Пользователь должен быть забанен");
        });
    }


}

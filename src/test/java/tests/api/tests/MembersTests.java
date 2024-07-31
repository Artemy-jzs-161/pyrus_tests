package tests.api.tests;

import tests.api.api.MemberApi;
import tests.api.extensions.AuthParameterResolver;
import tests.api.extensions.AuthToken;
import tests.api.extensions.Authorization;
import tests.api.models.members.ErrorMemberResponseModel;
import tests.api.models.members.MemberModel;
import tests.api.models.members.MembersRequestModel;
import tests.api.models.members.MembersResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.junit.jupiter.api.Assertions.*;

@Tag("API")
@Epic("API Тесты для работы с сотрудниками")
@Story("Получение информации и управление сотрудниками")
@Feature("API Members")
@DisplayName("Проверка методов Members")
@ExtendWith(AuthParameterResolver.class)
public class MembersTests extends APITestBase {
    private MemberApi memberApi;

    @BeforeEach
    @Step("Получение токена")
    void setUp(@AuthToken String authToken) {
        System.out.println("Токен доступа: " + authToken);
        this.memberApi = new MemberApi(authToken);
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Проверка получения всех сотрудников")
    void getAllMembersTest() {
        MembersResponseModel membersResponse = step("Отправка запроса на получение всех пользователей", () ->
                memberApi.getAllMember());

        step("Проверка, что список сотрудников не пустой", () ->
                assertFalse(membersResponse.getMemberModels().isEmpty(),
                        "Список пользователей не должен быть пустым"));
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Проверка получения сотрудника по id")
    void getIdMembersTest() {
        MemberModel memberModel = step("Отправка запроса на получение пользователя по id", () ->
                memberApi.getMember(String.valueOf(data.BorovikA().getId())));

        step("Проверить, что запрос выдал нужного пользователя", () ->
                assertEquals(data.BorovikA().getLastName(), memberModel.getLastName(),
                        "Фамилии пользователей совпадают"));
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Получение сотрудника по несуществующему id")
    void getIncorrectIdMemberTest() {
        ErrorMemberResponseModel errorResponse = step("Отправка запроса на получение пользователя по id", () ->
                memberApi.getMemberError(String.valueOf(data.randomId)));

        step("Проверка, названия и кода ошибки", () -> {
            assertEquals("Произошла непредвиденная ошибка.", errorResponse.getError());
            assertEquals("access_denied", errorResponse.getErrorCode(),
                    "Проверить, что \"error_code\" равен \"access_denied\"");
        });
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Добавление нового сотрудника")
    void addNewMemberTest() {
        MembersRequestModel newMember = step("Сохраняем нового пользователя в переменную", () ->
                data.memberFirst());

        MembersRequestModel member = step("Отправка запроса на создание нового пользователя", () ->
                memberApi.createMember(newMember));

        step("Проверка создания пользователя", () ->
                assertEquals(newMember.getFirstName(), member.getFirstName(), "Проверить, что имя созданного пользователя совпадает с введенным"));
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Изменение данных пользователя по ID")
    void changeMemberTest() {
        MembersRequestModel createMember = step("Создание пользователя", () ->
                memberApi.createMember(data.memberFirst()));

        step("Обновление пользователя", () ->
                memberApi.updateMember(createMember.getId(), data.memberSecond()));

        step("Проверка изменения пользователя", () ->
                assertNotEquals(data.memberSecond().getFirstName(), createMember.getFirstName(),
                        "Проверить, что имена пользователей не совпадают"));
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Блокировка пользователя по ID")
    void bannedMemberTest() {
        MembersRequestModel member = step("Создание пользователя", () ->
                memberApi.createMember(data.memberFirst()));

        MemberModel memberModel1 = step("Блокировка пользователя", () ->
                memberApi.deleteMember(member.getId()));

        step("Проверить, что пользователь забанен", () ->
                assertTrue(memberModel1.isBanned(), "Пользователь в статусе забанен"));
    }
}
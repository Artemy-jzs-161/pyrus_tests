package tests.api;

import api.MemberApi;
import extensions.*;
import data.models.members.*;
import tests.TestData;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
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
    TestData data = new TestData();
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
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Проверка получения всех сотрудников")
    void getAllMembersTest() {
        step("Отправка запроса на получение всех пользователей");
        MembersResponseModel membersResponse = memberApi.getAllMember();
        step("Проверка, что список сотрудников не пустой");
        assertNotNull(membersResponse, "Ответ не должен быть null");
        assertFalse(membersResponse.getMemberModels().isEmpty(), "Список пользователей не должен быть пустым");
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Проверка получения сотрудника по id")
    void getIdMembersTest() {
        step("Отправка запроса на получение пользователя по id");
        memberApi.getMember(String.valueOf(data.BorovikA.getId()));
        step("Проверка, что ответ не пустой");
        assertNotNull(memberApi, "Ответ не должен быть null");
        step("Проверить, что запрос выдал нужного пользователя");
        assertEquals(
                data.BorovikA.getLastName(),
                memberApi.getMember(String.valueOf(data.BorovikA.getId())).getLastName(),
                "Фамилии пользователей совпадают");
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Получение сотрудника по несуществующему id")
    void getIncorrectIdMemberTest() {
        step("Отправка запроса на получение пользователя по id");
        memberApi.getMemberError(String.valueOf(data.randomId));
        step("Проверка, что ответ не пустой");
        assertNotNull(memberApi, "Ответ не должен быть null");
        step("Проверка, названия и кода ошибки");
        assertEquals("Произошла непредвиденная ошибка.", memberApi.getMemberError(String.valueOf(0)).getError());
        assertEquals("access_denied", memberApi.getMemberError(String.valueOf(0)).getErrorCode());
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Добавление нового сотрудника")
    void addNewMemberTest() {
        step("Отправка запроса на создание нового пользователя");
        MembersRequestModel member = memberApi.createMember(data.memberFirst);
        step("Проверка создания пользователя");
        assertNotNull(memberApi, "Ответ не должен быть null");
        assertEquals(data.memberFirst.getFirstName(), member.getFirstName(), "Имя пользователей совпадают");
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Изменение данных пользователя по ID")
    void changeMemberTest() {
        step("Создание пользователя");
        MembersRequestModel createMember = memberApi.createMember(data.memberFirst);
        step("Обновление пользователя");
        memberApi.updateMember(createMember.getId(), data.memberSecond);
        step("Проверка изменения пользователя");
        assertNotEquals(data.memberSecond.getFirstName(), createMember.getFirstName(), "Имена пользователя не совпадает");
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @Authorization
    @DisplayName("Блокировка пользователя по ID")
    void bannedMemberTest() {
        step("Создание пользователя");
        MembersRequestModel member = memberApi.createMember(data.memberFirst);
        step("Блокировка пользователя");
        MemberModel memberModel1 = memberApi.deleteMember(member.getId());
        step("Проверить, что пользователь забанен");
        assertTrue(memberModel1.isBanned(), "Пользователь в статусе забанен");
    }
}

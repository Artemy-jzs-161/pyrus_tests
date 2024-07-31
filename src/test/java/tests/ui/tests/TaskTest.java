package tests.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static tests.ui.enums.Language.ru;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("UI")
@Epic("Управление задачами")
@Story("Создайние задачи")
@Feature("Создание простой задачи без шаблона")
@DisplayName("Проверка создания задачи")
public class TaskTest extends UITestBase {
    @Test
    @Owner("borovikaa")
    @Severity(CRITICAL)
    @DisplayName("Проверить, успешное создание задачи")
    void checkCreateTaskTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Войти\"", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.email));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.password));
        step("Нажать на кнопку \"Новая задача\"", () -> mainPage.pressNewTask());
        step("Ввести заголовок", () -> mainPage.setTaskName(data.taskName));
        step("Ввести описание задачи", () -> mainPage.setTaskDescription(data.taskDescription));
        step("Нажать кнопку \"Отправить\"", () -> mainPage.creatTask());
        step("Проверить заголовок задачи", () -> mainPage.checkTaskName(data.taskName));
    }
}
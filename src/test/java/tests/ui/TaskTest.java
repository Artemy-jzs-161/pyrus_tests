package tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("UI")
@Epic("Управление задачами")
@Story("Создайние задачи")
@Feature("Создание простой задачи без шаблона")
@DisplayName("Проверка создания задачи")
public class TaskTest extends TestBase {
    @Test
    @Owner("borovikaa")
    @Severity(CRITICAL)
    @DisplayName("Проверить, успешное создание задачи")
    void checkCreateTaskTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Войти\"", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Нажать на кнопку \"Новая задача\"", () -> mainPage.pressNewTask());
        step("Ввести заголовок", () -> mainPage.setTaskName(data.TASK_NAME));
        step("Ввести описание задачи", () -> mainPage.setTaskDescription(data.Task_Description));
        step("Нажать кнопку \"Отправить\"", () -> mainPage.creatTask());
        step("Проверить заголовок задачи", () -> mainPage.checkTaskName(data.TASK_NAME));
    }
}
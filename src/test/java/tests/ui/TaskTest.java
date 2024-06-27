package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;

@Tag("ui")
public class TaskTest extends TestBase {
    @Test
    void checkCreateTaskTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Нажать на кнопку Новая задача", () -> mainPage.pressNewTask());
        step("Ввести заголовок", () -> mainPage.setTaskName("Задача номер 1"));
        step("Ввести описание задачи", () -> mainPage.setTaskDescription("Описание задачи 1"));
        step("Нажать кнопку Отправить", () -> mainPage.creatTask());
        step("Проверить заголовок задачи", () -> mainPage.checkTaskName("Задача номер 1"));
    }
}
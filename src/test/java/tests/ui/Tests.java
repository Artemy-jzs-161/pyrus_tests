package tests.ui;

import data.enums.Language;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import data.pages.AccountsWebPage;
import data.pages.GreetingWebPage;
import data.pages.MainWebPage;
import data.pages.PreferencesWebPage;
import tests.TestData;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;

@Tag("ui")
public class Tests extends TestBase {

    @Test
    void checkLoginTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Проверить имя компании на главной страницу", () -> mainPage.checkCompanyName(data.NAME_COMPANY));
    }

    @Test
    void checkIncorrectPasswordTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.INCORRECT_INPASSWORD));
        step("Проверить имя компании на главной страницу", () -> accountsPage.checkingIncorrectPassword(data.INCORRECT_INPASSWORD));
    }

    @Test
    void checkNameCompanyTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Проверить имя компании на главной страницу", () -> mainPage.checkCompanyName(data.NAME_COMPANY));
    }


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

    @Test
    void checkBlackThemeInstallationTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Нажать кнопку Настройки", () ->   mainPage.clickSettingButton());
        step("Нажать кнопку Предпочтения", () -> mainPage.clickPreferencesButton());
        step("Нажать кнопку Предпочтения", () -> preferencesPage.selectBlackTheme());
        step("Проверить, что тема изменилась на темную", () -> preferencesPage.checkBackgroundColor(data.backgroundColorBlackTheme));
    }
}
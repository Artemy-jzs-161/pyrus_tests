package tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Tag("UI")
@Epic("Управление пользователями")
@Story("Проверка авторизации")
@Feature("Стандартный вход по логину и паролю")
@DisplayName("Проверка авторизации пользователей")
public class LoginTests extends UITestBase {
    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка успешной авторизации при вводе логина и пароля")
    void successfulCheckLoginTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Войти\"", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.email));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.password));
        step("Проверить имя компании на главной страницу", () ->
                mainPage.checkCompanyName(data.nameCompany));
    }

    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка попытки авторизации, при вводе некорректного пароля")
    void checkIncorrectPasswordTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Войти\"", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.email));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.incorrectPassword));
        step("Проверить, что высветилось оповещение о неправильном пароле", () ->
                accountsPage.checkingIncorrectPassword(data.incorrectPasswordMessage));
    }

    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка попытки авторизации, при вводе некорректного логина")
    void checkIncorrectLoginTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Войти\"", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.incorrectEmail));
        step("Проверить, что появилось окно создания новой компании", () ->
                accountsPage.checkingIncorrectLogin(data.titleCreateCompany));
    }
}
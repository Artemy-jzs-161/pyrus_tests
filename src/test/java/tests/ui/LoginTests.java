package tests.ui;

import org.junit.jupiter.api.*;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;


public class LoginTests extends TestBase {

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
        step("Ввести пароль", () -> accountsPage.enterPassword(data.INCORRECTPASSWORD));
        step("Проверить имя компании на главной страницу", () -> accountsPage.checkingIncorrectPassword(data.INCORRECTPASSWORD));
    }

    @Test
    void checkNameCompanyTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));  // TODO переделать на некорректный логин
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Проверить имя компании на главной страницу", () -> mainPage.checkCompanyName(data.NAME_COMPANY));
    }
}
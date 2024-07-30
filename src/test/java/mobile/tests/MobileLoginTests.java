package mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Tag("Mobile")
@Epic("Управление пользователями")
@Story("Авторизация пользователей")
@Feature("Мобильная авторизация")
@DisplayName("Тесты на мобильную авторизацию")
public class MobileLoginTests extends MobileTestBase {


    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Успешная авторизация при вводе логина и пароля в мобильном приложении")
    void mobileSuccessfulRegistrationTest() throws InterruptedException {
        step("Нажать на кнопку Log in", () -> {
            mobilePage.clickLogin();
        });
        step("Ввести Email address", () -> {
            mobilePage.setEmail(data.email);
        });
        step("Нажать на кнопку Next", () -> {
            mobilePage.clickNext();
        });
        step("Нажать на кнопку Type password", () -> {
            mobilePage.clickTypePassword();
        });
        step("Ввести password", () -> {
            mobilePage.setPassword(data.password);
        });
        step("Нажать на кнопку Next", () -> {
            mobilePage.clickNext2();
        });
        step("Нажать на кнопку Next", () -> {
            mobilePage.clickNext3();
        });
        step("Проверить, что на странице присутствует кнопка Knowledge B", () -> {
            mobilePage.checkThePageHasKnowledgeButton();
        });
    }

    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка авторизации при вводе неверного пароля")
    void mobileIncorrectPasswordTest() {
        step("Нажать на кнопку Log in", () -> {
            mobilePage.clickLogin();
        });
        step("Ввести Email address", () -> {
            mobilePage.setEmail(data.email);
        });
        step("Нажать на кнопку Next", () -> {
            mobilePage.clickNext();
        });
        step("Нажать на кнопку Type password", () -> {
            mobilePage.clickTypePassword();
        });
        step("Ввести password", () -> {
            mobilePage.setPassword(data.incorrectPassword);
        });
        step("Нажать на кнопку Next", () -> {
            mobilePage.clickNext2();
        });
        step("Проверить, что появилось уведомление о неверном пароле", () -> {
            mobilePage.checkPasswordIncorrectMessage(data.incorrectPasswordMessageMobile);
        });
    }

    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка авторизации при вводе неверного Email адреса")
    void mobileIncorrectEmailTest() {
        step("Нажать на кнопку Log in", () -> {
            mobilePage.clickLogin();
        });
        step("Ввести Email address", () -> {
            mobilePage.setEmail(data.invalidEmail);
        });
        step("Нажать на кнопку Next", () -> {
            mobilePage.clickNext();
        });
        step("Проверить, что появилось уведомление о неверном логине", () -> {
            mobilePage.checkLoginIncorrectMessage(data.invalidEmail);
        });
    }
}
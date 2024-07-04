package tests.mobile;

import data.pages.MobilePage;
import io.qameta.allure.*;
import tests.TestData;

import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Epic("...")
@Story("...")
@Feature("...")
@DisplayName("...")
public class MobileTests extends TestBase {
    MobilePage mobilePage = new MobilePage();
    TestData data = new TestData();

    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка успешной авторизации при вводе логина и пароля в мобильном приложении")
    @Tag("Mobile")
    void mobileSuccessfulRegistrationTest() {
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
    @DisplayName("Проверка успешной авторизации при вводе логина и пароля в мобильном приложении")
    void mobileLogoutFromAccountTest() {
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
        step("Нажать на кнопку More", () -> {
            mobilePage.clickMore();
        });
        step("Нажать на кнопку Log out", () -> {
            mobilePage.clickLogOut();
        });
        step("Нажать на кнопку Yes", () -> {
            mobilePage.clickYes();
        });
        step("Проверить, что на странице присутствует кнопка Log in", () -> {
            mobilePage.checkThePageHasLogInButton();
        });
        step("Проверить, наличие текста \"Pyrus is the best way to collaborate with your team.\"", () -> {
            mobilePage.checkInfoText(data.infoText);
        });
    }

    @Test
    @Owner("borovikaa")
    @Severity(BLOCKER)
    @DisplayName("Проверка успешной авторизации при вводе логина и пароля в мобильном приложении")
    void mobileCreateTaskTest() {
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
        step("Нажать \"+\"", () -> {
            mobilePage.clickPlusButton();
        });
        step("Нажать New task", () -> {
            mobilePage.clickNewTask();
        });
        step("Ввести имя задачи", () -> {
            mobilePage.setTaskName(data.taskName);
        });
        step("Ввести описание задачи", () -> {
            mobilePage.setTaskDescription(data.taskDescription);
        });
        step("Нажать SEND", () -> {
            mobilePage.clickSend();
        });
        step("Проверить что задача создалась", () -> {
            mobilePage.checkCreationTask(data.taskName);
        });
    }
}

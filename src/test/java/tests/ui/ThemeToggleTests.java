package tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("UI")
@Epic("Управление предпочтениями")
@Story("Тема оформления")
@Feature("Включение темной темы")
@DisplayName("Тестирование переключения тем")
public class ThemeToggleTests extends UITestBase {
    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @DisplayName("Проверка, установки темной темы")
    void checkBlackThemeInstallationTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Войти\"", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.email));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.password));
        step("Нажать кнопку \"Настройки\"", () -> mainPage.clickSettingButton());
        step("Нажать кнопку \"Предпочтения\"", () -> mainPage.clickPreferencesButton());
        step("Кликнуть на чекбокс \"Темная\"", () -> preferencesPage.selectBlackTheme());
        step("Проверить, что тема изменилась на темную", () ->
                preferencesPage.checkBackgroundColor(data.backgroundColorBlackTheme));
    }
}
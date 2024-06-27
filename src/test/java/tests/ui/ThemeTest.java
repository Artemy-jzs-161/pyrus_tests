package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;

@Tag("ui")
public class ThemeTest extends TestBase {
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
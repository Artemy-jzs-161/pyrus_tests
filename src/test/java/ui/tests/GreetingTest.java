package ui.tests;

import ui.enums.Language;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("UI")
@Epic("Тестирование ссылок на сайте Pyrus")
@Story("Проверка доступности основных страниц")
@Feature("Проверка ссылок")
@DisplayName("Проверки на странице приветствия")
public class GreetingTest extends UITestBase {
    static Stream<Arguments> checkLinkOnGreetingPageTests() {
        return Stream.of(
                Arguments.of(
                        Language.en,
                        List.of("Products", "Pricing", "Blog", "Contact", "Go to Pyrus")
                ),
                Arguments.of(
                        Language.ru,
                        List.of("Возможности", "Решения", "Цены", "Кейсы", "Контакты", "Войти")
                ));
    }

    @Owner("borovikaa")
    @Severity(CRITICAL)
    @MethodSource
    @ParameterizedTest(name = "Проверка соответствия ссылок на {0} языке")
    @DisplayName("Проверить ссылки при переключнии языка")
    void checkLinkOnGreetingPageTests(Language language, List<String> expectedButtons) {
        step("Открыть страницу", () -> greetingPages.openPage(language.name()));
        step("Проверить ссылки", () -> greetingPages.checkHeader(expectedButtons));
    }
}


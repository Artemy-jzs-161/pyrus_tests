package tests.ui;

import data.enums.Language;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class ParamLanguageTest extends TestBase {

    static Stream<Arguments> selenideSiteShouldDisplayCorrectButtons() {
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

    @MethodSource
    @ParameterizedTest
    void selenideSiteShouldDisplayCorrectButtons(Language language, List<String> expectedButtons) {
        open(language.name());
        greetingPages.checkHeader(expectedButtons);
    }


}


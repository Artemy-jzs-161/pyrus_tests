package tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;

@Tag("UI")
@Epic("Поиск по блогу Pyrus")
@Story("Поиск по ключевому слову")
@Feature("Поиск по заголовкам статей")
@DisplayName("Проверка работы поиска на странице \"Блог\"")
public class BlogTests extends TestBase {
    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @DisplayName("Проверить поиск по названию статьи")
    void checkSuccessSearchInBlogTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Кейсы\"", () -> greetingPages.pressBlogPage());
        step("Ввести информацию", () -> blogWebPage.searchInfo(data.BLOG));
        step("Проверить работу поиска", () -> blogWebPage.checkSearchInfo(data.BLOG));
    }

    @Test
    @Owner("borovikaa")
    @Severity(NORMAL)
    @DisplayName("Проверить, что при поиске несуществующей статьи, результат \"Ничего не найдено\"")
    void checkSearchDoesNotExistBlogTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку \"Кейсы\"", () -> greetingPages.pressBlogPage());
        step("Ввести информацию", () -> blogWebPage.searchInfo(data.NULL_BLOG));
        step("Проверить, что в блоге ничего не найдено", () ->
                blogWebPage.checkNulLResultMessage(data.RESULT_SEARCH));
    }
}
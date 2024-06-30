package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.enums.Language.ru;
import static io.qameta.allure.Allure.step;

@Tag("ui")
public class BlogTest extends TestBase {

    @Test
    void checkSuccessSearchInBlogTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Кейсы", () -> greetingPages.pressBlogPage());
        step("Ввести информацию", () -> blogWebPage.searchInfo(data.BLOG));
        step("Проверить работу поиска", () -> blogWebPage.checkSearchInfo(data.BLOG));
    }

    @Test
    void checkAnSuccessSearchInBlogTest() {
        step("Открыть страницу", () -> greetingPages.openPage(String.valueOf(ru)));
        step("Нажать кнопку Кейсы", () -> greetingPages.pressBlogPage());
        step("Ввести информацию", () -> blogWebPage.searchInfo(data.NULL_BLOG));
        step("Проверить, что в блоге ничего не найдено", () -> blogWebPage.checkNulLResultMessage("Ничего не найдено"));
    }
}
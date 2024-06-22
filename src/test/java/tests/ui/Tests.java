package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AccountsWebPage;
import pages.GreetingWebPage;
import pages.MainWebPage;
import tests.TestData;

import static io.qameta.allure.Allure.step;
@Tag("ui")
public class Tests extends TestBase {
    TestData data = new TestData();
    GreetingWebPage greetingPages = new GreetingWebPage();
    AccountsWebPage accountsPage = new AccountsWebPage();
    MainWebPage mainPage = new MainWebPage();

    @Test
    void checkNameCompanyTest() {
        step("Открыть страницу", () -> greetingPages.openPage("/ru"));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Проверить имя компании на главной страницу", () -> mainPage.checkCompanyName(data.NAME_COMPANY));
    }

    
/*
    @Test
    void checkCreateTaskTest(){
        step("Открыть страницу", () -> greetingPages.openPage("/ru"));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
    }

 */

}

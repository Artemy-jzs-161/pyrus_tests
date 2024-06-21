package tests.ui;

import org.junit.jupiter.api.Test;
import pages.AccountsPage;
import pages.GreetingPage;
import pages.MainPage;
import tests.TestData;

import static io.qameta.allure.Allure.step;

public class Tests extends TestBase {
    TestData data = new TestData();
    GreetingPage greetingPages = new GreetingPage();
    AccountsPage accountsPage = new AccountsPage();
    MainPage mainPage = new MainPage();

    @Test
    void checkNameCompanyTest() {
        step("Открыть страницу", () -> greetingPages.openPage("/ru"));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));
        step("Проверить имя компании на главной страницу", () -> mainPage.checkCompanyName(data.NAME_COMPANY));
    }

    @Test
    void checkCreateTaskTest(){
        step("Открыть страницу", () -> greetingPages.openPage("/ru"));
        step("Нажать кнопку Войти", () -> greetingPages.pressLoginButton());
        step("Ввести логин", () -> accountsPage.enterLogin(data.USERNAME));
        step("Ввести пароль", () -> accountsPage.enterPassword(data.PASSWORD));



    }

}

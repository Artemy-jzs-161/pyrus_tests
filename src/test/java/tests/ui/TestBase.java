package tests.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import data.pages.*;
import drivers.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import tests.TestData;

public class TestBase {
    TestData data = new TestData();
    GreetingWebPage greetingPages = new GreetingWebPage();
    AccountsWebPage accountsPage = new AccountsWebPage();
    MainWebPage mainPage = new MainWebPage();
    PreferencesWebPage preferencesPage = new PreferencesWebPage();
    BlogWebPage blogWebPage = new BlogWebPage();

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
    }

    @BeforeEach
    void selenideListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Последний скриншот");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();

    }
}
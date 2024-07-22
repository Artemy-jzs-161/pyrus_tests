package tests.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import pages.*;
import helpers.Attach;
import tests.TestData;

import drivers.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;

public class UITestBase {
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
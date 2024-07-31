package tests.ui.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import helpers.Attach;
import data.TestData;

import drivers.WebDriver;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import tests.ui.pages.*;

public class UITestBase {
    TestData data = new TestData();
    GreetingWebPage greetingPages = new GreetingWebPage();
    AccountsWebPage accountsPage = new AccountsWebPage();
    MainWebPage mainPage = new MainWebPage();
    PreferencesWebPage preferencesPage = new PreferencesWebPage();
    BlogWebPage blogWebPage = new BlogWebPage();

    @BeforeAll
    static void beforeAll() {
        WebDriver.config();
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
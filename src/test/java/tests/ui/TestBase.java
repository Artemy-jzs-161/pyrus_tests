package tests.ui;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.WebDriverProvider;
import data.pages.*;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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

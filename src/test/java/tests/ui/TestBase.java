package tests.ui;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import data.pages.*;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.remote.DesiredCapabilities;
import tests.TestData;

import java.util.Map;


public class TestBase {
    TestData data = new TestData();
    GreetingWebPage greetingPages = new GreetingWebPage();
    AccountsWebPage accountsPage = new AccountsWebPage();
    MainWebPage mainPage = new MainWebPage();
    PreferencesWebPage preferencesPage = new PreferencesWebPage();
    BlogWebPage blogWebPage = new BlogWebPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = "https://pyrus.com/";
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.browserVersion = System.getProperty("browser_version", "122.0");
        Configuration.pageLoadStrategy = "eager";

        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 100000;

                Configuration.remote = "https://user1:1234@" +
                System.getProperty("remote_url", "selenoid.autotests.cloud") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();

    }
}

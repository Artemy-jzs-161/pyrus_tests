package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import drivers.*;
import helpers.Attach;

import org.junit.jupiter.api.*;
import pages.mobile.MobilePage;
import tests.TestData;

import static com.codeborne.selenide.Selenide.*;

public class MobileTestBase {
    MobilePage mobilePage = new MobilePage();
    TestData data = new TestData();
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {
        switch (deviceHost) {
            case "browserstack" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "emulation" -> Configuration.browser = EmulatorDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.pageSource();
        if ("browserstack".equals(deviceHost)) {
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}

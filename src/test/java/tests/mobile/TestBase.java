package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import drivers.BrowserstackDriver;
import drivers.AndroidEmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;



import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() throws Exception {
        switch (deviceHost) {
            case "browserstack" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "emulation" -> Configuration.browser = AndroidEmulatorDriver.class.getName();
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
        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }

        closeWebDriver();
    }
}

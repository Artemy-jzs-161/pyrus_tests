package tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import tests.TestData;

public class APITestBase {
    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
        WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        RestAssured.baseURI = "https://api.pyrus.com/";
        Configuration.baseUrl = "https://pyrus.com/";
        RestAssured.basePath = "v4/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = webConfig.getRemoteUrl();
    }

    @BeforeEach
    void selenideListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}

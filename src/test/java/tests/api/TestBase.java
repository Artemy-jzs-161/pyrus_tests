package tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        RestAssured.baseURI = "https://api.pyrus.com/";
        Configuration.baseUrl = "https://pyrus.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = webConfig.getRemoteUrl();
    }


}

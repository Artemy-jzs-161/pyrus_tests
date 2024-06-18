package drivers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

import drivers.AuthSelenoidConfig;

public class WebDriversProvider {
    static config.WebDriverConfig webDriverConfig = ConfigFactory.create(config.WebDriverConfig.class, System.getProperties());
    static AuthSelenoidConfig authSelenoidConfig = ConfigFactory.create(AuthSelenoidConfig.class, System.getProperties());

    public static String url;

    public static void config() {
        Configuration.browser = WebDriversProvider.webDriverConfig.getBrowser();
        Configuration.browserVersion = WebDriversProvider.webDriverConfig.getBrowserVersion();
        Configuration.browserSize = WebDriversProvider.webDriverConfig.getBrowserSize();
        Configuration.baseUrl = WebDriversProvider.webDriverConfig.getBaseUrl();
        Configuration.pageLoadStrategy = "eager";

        RestAssured.baseURI = WebDriversProvider.webDriverConfig.getBaseUri();

        url = WebDriversProvider.webDriverConfig.getRemoteUrl();
        if (url != null) {
            Configuration.remote = "https://"
                    + WebDriversProvider.authSelenoidConfig.getRemoteUsername() + ":"
                    + WebDriversProvider.authSelenoidConfig.getRemotePassword() + "@"
                    + url + "/wd/hub";
        }


    }
}
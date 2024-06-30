package drivers;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverProvider {
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void config() {
        Configuration.browser = WebDriverProvider.webDriverConfig.getBrowser();
        Configuration.browserVersion = WebDriverProvider.webDriverConfig.getBrowserVersion();
        Configuration.browserSize = WebDriverProvider.webDriverConfig.getBrowserSize();
        Configuration.baseUrl = WebDriverProvider.webDriverConfig.getBaseUrl();
        Configuration.pageLoadStrategy = "eager";

        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 100000;
    }
}
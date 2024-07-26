package drivers;

import com.codeborne.selenide.Configuration;
import config.AuthSelenoidConfig;
import config.WebDriverConfig;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriver {
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static AuthSelenoidConfig authSelenoidConfig = ConfigFactory.create(AuthSelenoidConfig.class, System.getProperties());

    public static void config() {
        ChromeDriverManager.getInstance().setup();

        Configuration.browser = WebDriver.webDriverConfig.getBrowser();
        Configuration.browserVersion = WebDriver.webDriverConfig.getBrowserVersion();
        Configuration.browserSize = WebDriver.webDriverConfig.getBrowserSize();
        Configuration.baseUrl = WebDriver.webDriverConfig.getBaseUrl();
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 100000;

        String url = WebDriver.webDriverConfig.getRemoteUrl();
        if (url != null) {
            Configuration.remote = "https://"
                    + WebDriver.authSelenoidConfig.getRemoteUsername() + ":"
                    + WebDriver.authSelenoidConfig.getRemotePassword() + "@"
                    + url + "/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options",
                    Map.<String, Object>of(
                            "enableVNC", true,
                            "enableVideo", true
                    ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
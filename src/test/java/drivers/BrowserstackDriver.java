package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserstackConfig.userName());
        caps.setCapability("browserstack.key", browserstackConfig.accessKey());
        caps.setCapability("app", browserstackConfig.appUrl());
        caps.setCapability("device", browserstackConfig.deviceModel());
        caps.setCapability("os_version", browserstackConfig.deviceVersion());
        caps.setCapability("project", browserstackConfig.project());
        caps.setCapability("build", browserstackConfig.build());
        caps.setCapability("name", browserstackConfig.name());
        caps.setCapability("autoGrantPermissions", "true");

        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.URL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

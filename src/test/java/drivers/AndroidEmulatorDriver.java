package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidEmulatorConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class AndroidEmulatorDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        AndroidEmulatorConfig emulatorConfig = ConfigFactory.create(AndroidEmulatorConfig.class);
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(emulatorConfig.platformVersion())
                .setDeviceName(emulatorConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage(emulatorConfig.appPackage())
                .setAppActivity(emulatorConfig.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        AndroidEmulatorConfig emulatorConfig = ConfigFactory.create(AndroidEmulatorConfig.class);
        try {
            return new URL(emulatorConfig.appiumServer());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        AndroidEmulatorConfig emulatorConfig = ConfigFactory.create(AndroidEmulatorConfig.class);

        File app = new File(emulatorConfig.appPath());
        if (!app.exists()) {
            try (InputStream in = new URL(emulatorConfig.appURL()).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}

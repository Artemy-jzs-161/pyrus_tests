package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthSelenoidConfig {
    @Config.Key("username.selenoid")
    String getRemoteUsername();

    @Config.Key("password.selenoid")
    String getRemotePassword();
}
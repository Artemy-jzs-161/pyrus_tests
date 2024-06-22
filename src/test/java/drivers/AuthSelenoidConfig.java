package drivers;

import org.aeonbits.owner.Config;


@Config.Sources({"classpath:selenoid.properties"})
public interface AuthSelenoidConfig extends Config {
    @Key("username.selenoid")
    String getRemoteUsername();

    @Key("password.selenoid")
    String getRemotePassword();
}
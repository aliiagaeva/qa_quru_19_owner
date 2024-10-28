package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

import java.net.URL;

@Sources({
        "classpath:${env}.properties",
        "file:~/${env}.properties",
        "file:./${env}.properties"
})

public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    URL remoteUrl();
}

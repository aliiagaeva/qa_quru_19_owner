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
//    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

//    @Key("remoteUrl")
//    @DefaultValue("http://localhost:4444")
//    URL getRemoteUrl();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

//    @Key("baseUrl")
//    String baseUrl();
    @Key("isRemote")
    boolean isRemote();
    @Key("remoteUrl")
    String remoteUrl();
}

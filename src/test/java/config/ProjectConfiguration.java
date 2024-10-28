package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser().toString();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.timeout = 30000;
        Configuration.pageLoadStrategy = "eager";
        if (webConfig.isRemote()) {
            Configuration.remote = String.valueOf(webConfig.remoteUrl());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}

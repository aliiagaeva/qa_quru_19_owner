package config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebProvider implements Supplier<WebDriver> {

    private final WebConfig config;

    public WebProvider(){
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get(){
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver(){
         switch (config.getBrowser()) {
             case CHROME: {
                 //WebDriverManager.chromedriver().setup();
                 return new ChromeDriver();
             }
            case FIREFOX: {
               // WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
             default: { throw new RuntimeException("No such driver");}
        }
    }
}

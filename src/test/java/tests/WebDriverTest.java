package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import config.WebProvider;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest extends TestBase{
    WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebProvider().get();
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

    @Test
    public void WDtest() {
        String title = driver.getTitle();
        assertEquals("GitHub · Build and ship software on a single, collaborative platform · GitHub", title);
        driver.quit();
    }
}

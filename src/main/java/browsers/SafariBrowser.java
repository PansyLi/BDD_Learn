package browsers;

import config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class SafariBrowser extends SafariDriver {
    public static WebDriver configuredSafariBrowser() throws IOException {
        System.setProperty("webdriver.safari.driver",TestConfig.valueFor("SafariDriverPath"));
        SafariBrowser browser = new SafariBrowser();
        browser.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        WebDriver driver = new SafariDriver();
        return driver;
    }
}

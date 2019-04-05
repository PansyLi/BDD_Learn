package browsers;

import config.TestConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.System.setProperty;
public class ChromeBrowser extends ChromeDriver {
    public ChromeBrowser(DesiredCapabilities caps) {

        super(caps);
    }

    public static ChromeBrowser configuredChromeBrowser() throws Throwable {
        setProperty("webdriver.chrome.driver", TestConfig.valueFor("chromeDriverPath"));
        ChromeOptions options = new ChromeOptions();

        if (TestConfig.hasProperty("WebDriverChromeBrowserbinary")) {
            options.setBinary(TestConfig.valueFor("WebDriverChromeDriverPath"));
        }
        options.addArguments("-disable-cache");

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeBrowser browser = new ChromeBrowser(caps);

        System.out.println("-----starting chrome driver-----");
        browser.manage().window().maximize();
        return browser;
    }
}


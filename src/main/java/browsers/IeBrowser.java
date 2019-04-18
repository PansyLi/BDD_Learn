package browsers;

import config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class IeBrowser extends InternetExplorerDriver{
    public static WebDriver configuredIeBrowser() throws Throwable{
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("ignoreZoomSetting",true);
        System.setProperty("webdriver.ie.driver",TestConfig.valueFor("IeDriverPath"));
        IeBrowser browser = new IeBrowser(capabilities);
        browser.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        return browser;
    }
    private IeBrowser(final DesiredCapabilities capabilities){
        super(capabilities);
    }
}

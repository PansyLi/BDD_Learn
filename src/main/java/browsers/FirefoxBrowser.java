package browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class FirefoxBrowser extends FirefoxDriver {
    public static FirefoxBrowser configuredFirefoxBrowser() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);

        FirefoxBrowser driver = new FirefoxBrowser(profile);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
    }

    private FirefoxBrowser(final FirefoxProfile profile){
        super(profile);
    }
}

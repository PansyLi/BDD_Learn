package browsers;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.LogEventListener;

import static browsers.BrowserFactory.configuredBrowser;

public class ShareDriver extends EventFiringWebDriver {

    private static WebDriver REAL_DRIVER;
    private static final Logger log = LoggerFactory.getLogger(ShareDriver.class);

    static{
        try{
            REAL_DRIVER = configuredBrowser();

            REAL_DRIVER = new EventFiringWebDriver(REAL_DRIVER).register(new LogEventListener());

        }catch (Throwable throwable){
            throwable.printStackTrace();
            throw new Error();
        }
    }
    //EventFiringWebDriver no default constructor
    public ShareDriver(){
        super(ShareDriver.REAL_DRIVER);
        log.info("\n****initialzing Sharedriver****");
    }
    @Before
    public void Setup(){
        log.info("delete cookie\n");
        manage().deleteAllCookies();
    }

    @After
    public static void closeDriver(){
        ShareDriver.REAL_DRIVER.quit();
    }

}

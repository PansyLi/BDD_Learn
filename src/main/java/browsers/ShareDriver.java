package browsers;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.GetCurrentTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static browsers.BrowserFactory.configuredBrowser;
import static java.lang.System.out;

public class ShareDriver extends EventFiringWebDriver {

    private static WebDriver REAL_DRIVER;
    private static final Logger log = LoggerFactory.getLogger(ShareDriver.class);

    static{
        try{
            REAL_DRIVER = configuredBrowser();
        }catch (Throwable throwable){
            throwable.printStackTrace();
            throw new Error();
        }
    }
    //EventFiringWebDriver no default constructor
    public ShareDriver(){
        super(ShareDriver.REAL_DRIVER);
        System.out.println("\n****initialzing Sharedriver");
    }

    @Before
    public void testSetup(){
        ShareDriver.log.info("delete cookie");
        manage().deleteAllCookies();
    }

    @After
    public void embedScreenshit(final Scenario scenario)throws IOException {
        if (scenario.isFailed()){
            takeScreenshot(scenario,(TakesScreenshot)REAL_DRIVER);
            try{
                out.println("\n=======Exception occurs with page text==========\n"+REAL_DRIVER.getTitle());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void takeScreenshot(Scenario result, TakesScreenshot driver) throws IOException {
        String scenarioName = result.getName();
        new File("target/failure-reports/").mkdirs();
        try{
            log.info("######### Scenario Failed - SCREENSHOT HAS TAKE #########");
            byte[]myScreenshot = driver.getScreenshotAs(OutputType.BYTES);
            FileOutputStream out =
                    new FileOutputStream("target/failure-reports/-"+scenarioName+"_"+ GetCurrentTime.currentTime()+".png");
            out.write(myScreenshot);
            result.embed(myScreenshot, "image/png");
            out.close();

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @After
    public static void closeDriver(){
        ShareDriver.REAL_DRIVER.quit();
    }

}

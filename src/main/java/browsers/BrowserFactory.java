package browsers;

import config.TestConfig;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    public static WebDriver configuredBrowser() throws Throwable{
        String desiredBrowser = null;
        String op_env = System.getProperty("os.name","Mac OS X");
        System.out.println("op_env = "+op_env+"\n");
        if (op_env.equals("Mac OS X")){

            desiredBrowser = TestConfig.valueFor("BrowserType");
        }
        else {
            desiredBrowser = System.getProperty("browser","");

        }
        WebDriver selectedDriver = null;
        switch (desiredBrowser){
            case "ie":
                selectedDriver = IeBrowser.configuredIeBrowser();
                break;
            case "chrome":
                selectedDriver = ChromeBrowser.configuredChromeBrowser();
                break;
            case "firefox":
                selectedDriver = FirefoxBrowser.configuredFirefoxBrowser();
                break;
            case "safari":
                selectedDriver = SafariBrowser.configuredSafariBrowser();
                break;
            default:
                selectedDriver = SafariBrowser.configuredSafariBrowser();
                break;
        }
        return selectedDriver;
    }
    }

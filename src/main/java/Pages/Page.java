package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page {
    protected WebDriver driver;
    private WebDriverWait wait;
    private static String pageUrl;

    private static final Logger log = LoggerFactory.getLogger(Page.class);
    public Page(final WebDriver REAL_DRIVER){

        driver = REAL_DRIVER;
        wait = new WebDriverWait(REAL_DRIVER,100);
        log.debug("Save local driver reference");
        PageFactory.initElements(REAL_DRIVER,this);
        log.debug("Initialized page element");
    }

}

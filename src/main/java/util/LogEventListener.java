package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class LogEventListener implements WebDriverEventListener {
    private static final Logger log = LoggerFactory.getLogger(LogEventListener.class);

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("beforeNavigateTo by driver: "+driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("afterNavigateTo by driver: "+driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            File screenshot = new File("target/failure-reports/" + this.getClass().getName()+File.separator + GetCurrentTime.currentTime() + ".png");
            FileUtils.copyFile(srcFile, screenshot);
        }catch(IOException e){
            e.printStackTrace();
        }
        log.error("Exception occurs with page text "+driver.getTitle()+"\n");
        log.info("Screenshout in path /target/failure-reports/"+this.getClass().getName()+File.separator + GetCurrentTime.currentTime() + ".png\n");

    }
}

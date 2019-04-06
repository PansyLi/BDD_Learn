package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteLetter extends Page {
    public WriteLetter(WebDriver REAL_DRIVER) {
        super(REAL_DRIVER);
    }

    private static final Logger log = LoggerFactory.getLogger(WriteLetter.class);
    @FindBy(xpath = ".//*[@id='dvContainer']/div[2]/div/section/header/div/div/div/div[2]")
    private WebElement receiver;


}

package Pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ThreadSleep;

import java.io.IOException;

public class LoginPage extends Page{

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(xpath = ".//input[@name='email']")
    private WebElement username;

    @FindBy(xpath = ".//input[2][@name='password']")
    private WebElement password;

    @FindBy(id="dologin")
    private WebElement login_button;

    @FindBy(xpath = ".//*[@id='dvNavTop']/ul/li[1]/span[2]")
    private WebElement writeLetter;

    @FindBy(xpath = "html/body/div[1]/h1/div")
    private WebElement logo;

    private WebDriverWait wait = new WebDriverWait(driver, 15);

    //public LoginPage page = Page.initElements(driver, LoginPage.class);

    public LoginPage(WebDriver shareDriver) {
        super(shareDriver);
    }
    public void login163Mail() throws IOException, InterruptedException {
        driver.get(TestConfig.valueFor("app.url"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        ThreadSleep.threadSleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='loginDiv']/iframe")));
        username.clear();
        username.sendKeys(TestConfig.valueFor("username"));
        password.sendKeys(TestConfig.valueFor("password"));
        login_button.click();
        ThreadSleep.threadSleep(2000);
    }
    public void loginAssert(){
        if (writeLetter.isDisplayed()){
            log.info("login 163 mail successfully!\n");
        } else {
            log.error("Login Failed :-(\n");
        }
    }
}
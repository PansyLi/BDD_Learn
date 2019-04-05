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

import java.io.IOException;

public class LoginPage extends Page{
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(xpath = ".//form[@id='login-form']/div/div/div[2]/input")
    private WebElement username;

    @FindBy(xpath = ".//form[@id='login-form']/div/div[3]/div[2]/input[2]")
    private WebElement password;

    @FindBy(id="dologin")
    private WebElement login_button;

    @FindBy(id = "spnUid")
    private WebElement userid;

    @FindBy(xpath = ".//*[@id='_mail_component_32_32']/span[2]")
    private WebElement inbox;

    private WebDriverWait wait = new WebDriverWait(driver, 15);

    public LoginPage(WebDriver shareDriver) {
        super(shareDriver);
    }
    public void login163Mail() throws IOException, InterruptedException {
        driver.get(TestConfig.valueFor("app.url"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".header-163logo")));
        username.sendKeys(TestConfig.valueFor("username"));
        wait(3000);
        password.sendKeys(TestConfig.valueFor("password"));
        wait(3000);
        login_button.click();
    }
    public void loginAssert(){
        if (inbox.isDisplayed()==true){
            log.info("login 163 mail successfully!\n");
        } else {
            log.error("Login Failed :-(\n");
        }
    }
}
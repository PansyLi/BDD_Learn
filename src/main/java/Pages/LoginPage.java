package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends Page{
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(xpath = ".//form[@id='login-form']/div/div/div[2]/input")
    private WebElement username;

    @FindBy(xpath = ".//form[@id='login-form']/div/div[3]/div[2]/input[2]")
    private WebElement password;

    @FindBy(id="dologin")
    private WebElement login_button;

    private WebDriverWait wait = new WebDriverWait(driver, 15);

    public LoginPage(WebDriver shareDriver) {
        super(shareDriver);
    }

    public void test(){
        driver.get("https://mail.163.com/");

    }


}
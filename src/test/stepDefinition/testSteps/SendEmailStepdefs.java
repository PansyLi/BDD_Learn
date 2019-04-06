package testSteps;

import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SendEmailStepdefs {
    public LoginPage loginPage;
    public SendEmailStepdefs(LoginPage commonloginPage){
        this.loginPage = commonloginPage;
    }
    @Given("^Customer login (\\d+) mail successfully$")
    public void customer_login_mail_successfully(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        loginPage.login163Mail();
        loginPage.loginAssert();
    }
    @When("^Customer write an email and click send button$")
    public void customer_write_an_email_and_click_send_button() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("^Email send successfully$")
    public void email_send_successfully() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }
}

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/myreport.html"}
        ,features = "src/test/resources/features/Send_email.feature"
        ,glue={ "src/test/stepDefinition/testSteps/SendEmailStepdefs.java","src/main/java/browsers"})
public class RunCucumberTest {
    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}


import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
//@RunWith(Cucumber.class)
@ContextConfiguration("classpath:cucumber.xml")
@CucumberOptions(
        plugin={"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/extent-report/report.html"}
        ,format = {"json:target/cucumber-report.json","pretty"}
        ,features = "src/test/resources/features"
        ,glue={ "src/test/stepDefinition/testSteps","src/main/java/browsers"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OS X");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ResourceCDN;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/extent-report/report.html"}
        ,format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
        ,features = "src/test/resources/features"
        ,glue={ "src/test/stepDefinition/testSteps","src/main/java/browsers"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setup() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent-report/report.html");
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
    }
    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OS X");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
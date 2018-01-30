package Runner;

import Setup.Environment_Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static Setup.Environment_Setup.driver;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "html:target/chrome-html-report",
        "json:target/cucumber_Chrome.json", "pretty:target/cucumber-pretty.txt",
        "junit:target/chrome-results.xml"
},
        features = "src/test/java/Features/MCSS_Basic.feature",
        glue = {"Steps"},
        tags = {"@Chrome"}



)



public class ChromeTestRunner {
    static Environment_Setup env = new Environment_Setup();
    @BeforeClass
    public static void setup() {
        driver = env.driver("chrome");
        driver.navigate().to("https://petselfservice.astro.com.my/mcssclient/mcss/web/");
        System.out.println("Ran the before");
    }


    @AfterClass
    public static void teardown() {
        driver.close();
        System.out.println("Ran the after");
    }


}

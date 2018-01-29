package Runner;

import Setup.Common;
import Setup.Environment_Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static Setup.Environment_Setup.driver;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber_Firefox.json", "pretty:target/cucumber-pretty.txt",
        "junit:target/cucumber-results.xml"
},
        features =  "src/test/java/Features/MCSS_Basic.feature",
        glue = {"Steps"},
        tags = {"@Firefox"}


)

public class FirefoxTestRunner {
    static Environment_Setup env = new Environment_Setup();
    @BeforeClass
    public static void setup() {
        driver = env.driver("firefox");
        driver.get("https://petselfservice.astro.com.my/mcssclient/mcss/web/");
        System.out.println("Ran the before");
    }


    @AfterClass
    public static void teardown() {
        driver.close();
        System.out.println("Ran the after");
    }

}

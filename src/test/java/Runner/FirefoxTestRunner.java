package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

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

}

package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber_Mozilla.json", "pretty:target/cucumber-pretty.txt",
        "junit:target/cucumber-results.xml"
},
        features =  "src/test/java/Features/Login1.feature",
        glue = {"Steps"},
        tags = {"@Mozilla"}


)

public class MozillaTestRunner {
}

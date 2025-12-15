package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdefinition",
        tags = "@regression",
        plugin = {
                "pretty", // pentru output în consolă
                "html:target/cucumber-report.html", // raport HTML
                "json:target/cucumber-report.json" // raport JSON, util pentru alte tool-uri
        },
        snippets = CAMELCASE
)
public class RunCucumberTest {
}

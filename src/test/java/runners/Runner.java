package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        dryRun = false,
        tags = "@wip"
)

public class Runner {

}

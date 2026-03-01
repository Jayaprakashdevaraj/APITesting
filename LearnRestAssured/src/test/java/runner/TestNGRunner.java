package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/java/feature/LearnScenarioOutline.feature:24"},
		glue = {"stepdefinations"},
		dryRun = false,
		plugin = {
      		  "pretty",
      		  "html:cucumber-report/result.html"
        }
		)

public class TestNGRunner extends AbstractTestNGCucumberTests{

}

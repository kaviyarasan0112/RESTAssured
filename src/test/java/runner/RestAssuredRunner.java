package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features= "./src/test/java/feature/CreateIncident.feature",
				glue="steps",
				monochrome = true,
				snippets = SnippetType.CAMELCASE,
				dryRun = true
				)
public class RestAssuredRunner extends AbstractTestNGCucumberTests {

}

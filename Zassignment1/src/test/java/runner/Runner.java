package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Login.feature",
		glue = "steps",
		tags = "",
		dryRun = false,
		monochrome = true,
		plugin = {
				"pretty",
				"html:targrt/reports/cucumber.html",
				"json:targrt/reports/cucumber.json"
		}

		)



public class Runner {
	
	

}

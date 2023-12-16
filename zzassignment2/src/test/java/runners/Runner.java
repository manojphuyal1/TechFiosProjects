package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/features/CodeFiosLogin.feature",
		//features = "classpath:features",
		glue = "steps",
		tags = "@smoke",
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

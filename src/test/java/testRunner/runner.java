package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//hakim//IdeaProjects//SDET_comcast//features//select.feature",
        glue = "stepDefinitions",
        dryRun = false, // when true you will get all steps in console so make sure you covered all steps
        monochrome = true,
        plugin = {"pretty","html:test-output"}




)
public class runner {
}

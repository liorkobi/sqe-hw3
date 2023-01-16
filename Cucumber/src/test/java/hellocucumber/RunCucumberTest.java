package hellocucumber;
//
//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;
//
//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
//
//public class RunCucumberTest {
//}
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\features"
)
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("hellocucumber")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

public class RunCucumberTest {

}
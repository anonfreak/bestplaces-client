package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * Created by kolbm on 15.06.2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features",
        glue = "cucumber.steps",
        format = "pretty" )
public class CucumberRun {

}

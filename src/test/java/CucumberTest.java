
import com.mesaj.app.conf.DriverConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber",
                   "com.mesaj.app.util.driver.reporting.JListener"}

  )
public class CucumberTest {
}

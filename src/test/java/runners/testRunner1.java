package runners;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = "src/test/resources/parallel/Feature02.feature", 
glue = { "parallel" },
		/*
		 * tags= "@Smoke and @Regression", tags= "@Smoke and @Regression",
		 */
		// tags= "@ALL",
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
plugin={ "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		/*
		 * "json:target json/cucumber-reports/Cucumber.json",
		 * "html:target html/cucumber-reports", "timeline:test-output-thread"
		 */ },
		monochrome = true

)

 public class testRunner1 extends AbstractTestNGCucumberTests {} 



/*
 * public class testRunner1 extends AbstractTestNGCucumberTests {
 * 
 * 
 * @Override
 * 
 * @DataProvider(parallel = true) public Object[][] sceanrio(){ return
 * super.scenarios(); }
 * 
 * 
 * 
 * 
 * }
 */
 
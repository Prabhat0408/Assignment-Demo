package parallel;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import helpers.ConfigFileReader;
import helpers.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;

public class BeforeAfterHook {
	TestContext testContext;
	private WebDriver driver;

	public BeforeAfterHook(TestContext context) {
		testContext = context;
	}

	@Before
	public void beforeScenario() throws IOException {
		System.out.println("Clear cookies -- start");
		testContext.getWebDriverManager().getDriver().manage().deleteAllCookies();
		testContext.getWebDriverManager().getDriver().manage().window().maximize();
		System.out.println("Clear cookies -- end");
	}
	
	
	
	  @After(order =0) public void tearDown() {
	  testContext.getWebDriverManager().quit();
	  
	  }
	 
	 

	@After(order =1)
	public void afterScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			driver = testContext.getWebDriverManager().getDriver();
			// take screenshot
			String screenShotName = scenario.getName().replaceAll(" ", "_").concat(".png");
			String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			scenario.attach(screenshot, "image/png",screenShotName);

		}
	}

	

}

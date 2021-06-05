package parallel;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import helpers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CountDownPage;
import pages.HomePage;



public class Feature01{

	SoftAssert sa;
	TestContext testContext;
	HomePage homePage;
	CountDownPage countPage;
	private int expectedTime;
	
	public Feature01(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		countPage = testContext.getPageObjectManager().getCountPage();
		
		sa = new SoftAssert();
	}
	
	
	
	@Given("Eggmeter timer site is opened and page is loaded")
	public void eggmeter_timer_site_is_opened_and_page_is_loaded() {
	   homePage.launchEggHomePage();
	   System.out.println(homePage.isEggTimerHomePageLoaded());
	   Assert.assertEquals(true, homePage.isEggTimerHomePageLoaded());
	}
	
	@When("^User enters \"([^\"]*)\" and click Go button$")
	public void user_enters_and_click_Go_button(String time) throws Throwable {
		expectedTime=Integer.parseInt(time);
	    homePage.startTimer(time);
	}
	
	@Then("^countdown starts on next page-CountdownPage$")
	public void countdown_starts_on_next_page_CountdownPage() throws Throwable {
		Assert.assertEquals(true, countPage.isCountdownTimerPageLoaded());
	    
	}

	@Then("^Remaining time decreases in one-sec increments$")
	public void remaining_time_decreases_in_one_sec_increments() throws Throwable {
		 int count =countPage.validationCounter();
		  Assert.assertEquals(count,expectedTime,"Validation of count timer start successful");
		
	}
	
	@Then("^validate counter starts as per given time in above step$")
	public void validate_counter_starts_as_per_given_time_in_above_step() throws Throwable {
		 int time=Integer.parseInt(countPage.getCountDownTime().split(" ")[0]);
		  Assert.assertEquals(time,expectedTime,"Validation of count timer start successful");
	}
	
	
	
}

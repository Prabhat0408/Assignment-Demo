package parallel;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import apiUtils.RestProcessor;
import apiUtils.SpaceXApi;
import enums.Context;
import helpers.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Feature02 {
	SoftAssert sa;
	TestContext testContext;
	SpaceXApi spacexapi;
	Response response;
	private String LaunchID;

	
	
	
	public Feature02(TestContext context) {
		testContext = context;
		sa = new SoftAssert();
		spacexapi = testContext.getApiManager().getSapcexApi();
	}
	
	@Given("Make a get call to fetch latest launch data")
	public void make_a_get_call_to_fetch_latest_launch_data() {
		response=spacexapi.latestLaunch("/v4/launches/latest");
	}
	
	@Then("Verify the status code {int}")
	public void verify_the_status_code(Integer statusCde) {
		Assert.assertEquals(spacexapi.isSuccessful(response,statusCde), true);
		
	}
	
	@And("Verify if the response contains the following info")
    public void verifyItTheResponseContainsTheFollowingInfo(DataTable datatable) {
        Map<String, String> resultMap = datatable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : resultMap.entrySet())
            Assert.assertEquals(response.jsonPath().getString(entry.getKey()), entry.getValue(), entry.getKey() + "doesnt match the expected value");
    }
	
	@Given("Make a get call to fetch latest launch data with wrong context path")
	public void make_a_get_call_to_fetch_latest_launch_data_with_wrong_context_path() {
		response=spacexapi.latestLaunch("/v4/launches/latest12s");
	}
	
	@Then("Retrieve only one LaunchID")
	public void retrieve_only_one_LaunchID() {
		LaunchID= spacexapi.getlatestLaunchid(response);
		
		//testContext.getScenarioContext().setContext(Context.ID, response);
	}
	
	@Then("Make a get call to Retrieve One LaunchID Data")
	public void make_a_get_call_to_Retrieve_One_LaunchID_Data() {
	   //String LaunchID= (String) testContext.getScenarioContext().getContext(Context.ID);
		LaunchID= spacexapi.getlatestLaunchid(response);
	   spacexapi.retriveOneLaunch("/v4/launches/", LaunchID);
	}
	
	

}

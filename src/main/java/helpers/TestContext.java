package helpers;

import java.io.IOException;

import enums.Context;
import managers.ApiManager;
import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
	
	
	
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	private ApiManager apiManager;
	private ScenarioContext scenarioContext;
	
	public TestContext() throws IOException {
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
		apiManager= new ApiManager();
		scenarioContext = new ScenarioContext();
		//scenarioContext.setContext(Context.LAUNCHID, LAUNCHID); why commned > bcoz scenario context can set value from  here
	}
	
	public DriverManager getWebDriverManager() {
		return driverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	
	//FOR API
	
	public ApiManager getApiManager() {
		return apiManager;
	}
	
	public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }

}

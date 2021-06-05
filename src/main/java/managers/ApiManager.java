package managers;



import apiUtils.SpaceXApi;
import helpers.ConfigFileReader;



public class ApiManager {
	private SpaceXApi spacexapi;
	
	
	public SpaceXApi getSapcexApi() {
		return (spacexapi == null) ? spacexapi = new SpaceXApi(ConfigFileReader.get("spacexURL")) : spacexapi;
	}
	

}

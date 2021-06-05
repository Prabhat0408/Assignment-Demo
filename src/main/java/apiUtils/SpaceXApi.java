package apiUtils;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SpaceXApi {
		//private static final String BASE_URL = "https://bookstore.toolsqa.com";
		

	    private final RequestSpecification request;

	/* This method will be used for authentication
	 * public static Response authenticateUser(AuthorizationRequest authRequest) {
	 * RestAssured.baseURI = BASE_URL; RequestSpecification request =
	 * RestAssured.given();
	 * 
	 * request.header("Content-Type", "application/json"); Response response =
	 * request.body(authRequest).post("/Account/v1/GenerateToken"); return response;
	 * }
	 */
		
		public SpaceXApi(String baseUrl) {
	        RestAssured.baseURI = baseUrl;
	        request = RestAssured.given();
		}
		//This is for interviewer to explain approach
	/*
	 * public IRestResponse<Launch> latestLaunch(String path) {
	 * //request.header("Content-Type", "application/json"); Response response =
	 * request.get(path); //Note for interviewer this data will be read by external
	 * source return new RestResponse(Launch.class, response); }
	 * 
	 * 
	 * public IRestResponse<Launch> nextLaunch(String path,String id) {
	 * //request.header("Content-Type", "application/json"); Response response =
	 * request.get(path+id); //Note for interviewer this data will be read by
	 * external source return new RestResponse(Launch.class, response); }
	 */
		
		public Response latestLaunch(String path) {
			//request.header("Content-Type", "application/json");
	        Response response = request.get(path); //Note for interviewer this data will be read by external source
	        return response;
	    }
		
		
		public Response retriveOneLaunch(String path,String id) {
			//request.header("Content-Type", "application/json");
	        Response response = request.get(path+id); //Note for interviewer this data will be read by external source
	        return response;
	    }
		
		
		
		public boolean isSuccessful(Response response,int statusCode) {
			int code = response.getStatusCode();
			
			
			if (code == statusCode || code == statusCode || code == statusCode || code == statusCode || code == statusCode || code == statusCode) {
				return true;
			}else {
			return false;
			}
		}
		
		
		public String getStatusDescription(Response response) {
			return response.getStatusLine();
		}
		
		
		public String getContent(Response response) {
			return response.getBody().asString();
		}
		
		
		public String getlatestLaunchid(Response response) {
			JsonPath json= new JsonPath(getContent(response));
			return json.get("id");
		}
		
		
			
		

	   

	    


	

}

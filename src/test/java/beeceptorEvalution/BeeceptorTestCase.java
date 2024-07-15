package beeceptorEvalution;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BeeceptorTestCase {
	
	String url = "https://posthook-api.mock.beeceptor.com"; 
	
	@Test(enabled = false)
	public void GetHooks() {
		RestAssured.baseURI=url; //any request made after the initial request will use the same base URL
		given().get("/v1/hooks").then().log().all();
		
	}
	
	
	@Test(enabled = false)
	public void ScheduleHook() { // this is used to create a new using post
		RestAssured.baseURI=url;
		given().contentType(ContentType.JSON).when().post("/v1/hooks").then().log().all();
	}
	
	@Test(enabled = false)
	public void GetHook() {
		RestAssured.baseURI=url;
		given().get("/v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db").then().log().all();
	}
	
	@Test(enabled = false)
	public void deleteHook() {
		RestAssured.baseURI=url;
		given().delete("/v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db").then().log().all(); // this is used to delete  hook using delete method
		
	}
	
	@Test (enabled = true)
	public void PutHook() {  //update data using put method
		                    // content type helps the server and clint to understand the format of the data being transmitted how o process accordndly
		RestAssured.baseURI=url;
		JSONObject js = new JSONObject();
		js.put("name", "updated-project");
		js.put("domain", "api.example.com");
		js.put("headerAuthorization", "");
		js.put("minRetries", 1);
		js.put("retryDelaySecs", 5);
		
		given().contentType("application/json").body(js.toJSONString()).when().put("/v1/projects/").then().log().all(); // this is used to update data using put method
		//given define the request body as a JSON object with specified key value pairs.When().put()sends a put request to api/
        //order endpoint with request body then()expected response statement verifies that the response status code is 200 log()All()
	}
	
	

}

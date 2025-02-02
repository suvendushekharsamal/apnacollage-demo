package session15;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonObjectUsingJavaMapDemo {

	@Test
	public void createAuthToken() {
		
		Map<String, String> data=new HashMap();
		data.put("username", "admin");
		data.put("password", "password123");
		
//		curl -X POST \
//		  https://restful-booker.herokuapp.com/auth \
//		  -H 'Content-Type: application/json' \
//		  -d '{
//		    "username" : "admin",
//		    "password" : "password123"
//		}'
		
		RequestSpecification reqs= RestAssured.given();
		reqs.baseUri("https://restful-booker.herokuapp.com/auth");
		reqs.header("Content-Type","application/json");
		Response res= reqs.body(data).post();
		
		JsonPath path=res.jsonPath();
		System.out.println(path.get("token"));
		
	}
	
}

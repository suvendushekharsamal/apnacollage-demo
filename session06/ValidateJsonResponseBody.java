package session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	
	
	@Test
	public void UserListResponseBody() {
		
//		Response res = RestAssured.get("https://reqres.in/api/users/2");
//		System.out.println(res.getBody().asString());
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RequestSpecification resp = RestAssured.given();
		Response res = resp.when().get();
		String str= res.getBody().asString();
		System.out.println(str);
		
		//check for presence of George in response body
		
		Assert.assertEquals(str.contains("Janet"),true,"check the details properly");
		
		
		
	}
	
	@Test
	public void UserListResponseBody01() {
		
//		Response res = RestAssured.get("https://reqres.in/api/users/2");
//		System.out.println(res.getBody().asString());
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RequestSpecification resp = RestAssured.given();
		Response res = resp.when().get();
		ResponseBody body = res.getBody();
		
		JsonPath path =  res.jsonPath();
	
		 System.out.println(path.get("data.first_name"));
		
	}
	
         
}

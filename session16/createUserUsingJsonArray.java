package session16;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONArray;

public class createUserUsingJsonArray {

	@Test
	public void JSONArray() {
		
		JSONObject user1=new JSONObject();
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 20000);
		
		JSONObject user2=new JSONObject();
		user1.put("firstName", "pragyan");
		user1.put("lastName", "Gupta");
		user1.put("age", 32);
		user1.put("salary", 28800);
		
		JSONObject user3=new JSONObject();
		user1.put("firstName", "Raman");
		user1.put("lastName", "sahoo");
		user1.put("age", 20);
		user1.put("salary", 35000);
		
		JSONArray arr =new JSONArray();
		arr.add(user1);
		arr.add(user3);
		arr.add(user2);
		
		RequestSpecification reqsp=RestAssured.given();
		reqsp.baseUri("https://reqres.in/api/users");
		reqsp.contentType(ContentType.JSON);
		reqsp.body(arr);
		Response res = reqsp.post();
		res.prettyPrint();

 
		
	}
	
}

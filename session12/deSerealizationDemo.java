package session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class deSerealizationDemo {

	@Test
	public void createUser() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "suvendu");
		jsonData.put("job", "Test");
		
		RestAssured.baseURI="https://reqres.in/api/users/";
		RequestSpecification reqsp=RestAssured.given();
		Response res = reqsp.contentType(ContentType.JSON).body(jsonData.toJSONString()).when().post();
		ResponseBody Resbody=  res.getBody();
//		RequestSpecification reqsp=RestAssured.given();
//		reqsp.baseUri("https://reqres.in/api/users/");
//		Response res = reqsp.body(jsonData.toJSONString()).contentType(ContentType.JSON).post();
//		ResponseBody Resbody=  res.getBody();
		 
		JSONPostRequestResponse respClass= Resbody.as(JSONPostRequestResponse.class);
		
		Assert.assertEquals(respClass.name, "suvendu");
		Assert.assertEquals(respClass.job, "Test");
		System.out.println(respClass.createdAt);
		
	}
	
}

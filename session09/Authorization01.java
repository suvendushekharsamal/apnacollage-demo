package session09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization01 {

	
	@Test
	public void BearerToken() {
		
	RequestSpecification reqspe=RestAssured.given();
	 reqspe.baseUri("https://gorest.co.in");
	 reqspe.basePath("/public/v2/users");
	 
	 JSONObject obj=new JSONObject();
	 obj.put("name", "pragaya");
	 obj.put("gender", "female");
	 obj.put("email", "suv123@gmail.com");
	 obj.put("status", "done");
	 
	 reqspe.header("Authorization", "Bearer e9806e13f96d6c4a03aa093d9f6e79b82f6cf29081a8f16040e90d5d92fc429f").
	 contentType(ContentType.JSON).
	 body(obj.toJSONString());
	 
	 Response res= reqspe.post();
	 
	Assert.assertEquals(res.getStatusCode(), 200);		
			
	
	
}
	}

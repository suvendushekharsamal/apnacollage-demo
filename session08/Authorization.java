package session08;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {

	//without authorization
	@Test
	public void BasicAuth() {
	RequestSpecification reqsp= RestAssured.given();
	 reqsp.baseUri("https://postman-echo.com");
	 reqsp.basePath("/basic-auth");
	 
	 Response res=reqsp.auth().basic("postman", "password").get();
	 
	 System.out.println(res.getBody().asString());
	 System.out.println(res.getStatusLine());
	
	}	
	
	@Test
	public void BasicAuth01() {
	RequestSpecification reqsp= RestAssured.given();
	 reqsp.baseUri("https://postman-echo.com");
	 reqsp.basePath("/basic-auth");
	 
	 Response res=reqsp.auth().basic("postman", "password").get();
	 
	 System.out.println(res.getBody().asString());
	 System.out.println(res.getStatusLine());
	
	}	
	
	
	@Test
	public void BasicAuth02() {
	RequestSpecification reqsp= RestAssured.given();
	 reqsp.baseUri("https://httpbin.org");
	 reqsp.basePath("digest-auth/undefined/suvendu/samal");
	 
	 Response res=reqsp.auth().digest("suvendu", "samal").get();
	 
	 System.out.println(res.getBody().asString());
	 System.out.println(res.getStatusLine());
	
	}
	
	
}

package session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Curd_Operation {
    
	@Test
	public void test01() {
		Response res= get("https://reqres.in/api/users/2");
		
		   System.out.println(res.getStatusCode());
		   System.out.println(res.getBody().asString());
		   
		   int expectedStatuscode = 200;
		   
		   int ActualStatuscode = res.getStatusCode();
		
		   Assert.assertEquals(expectedStatuscode, ActualStatuscode);
		   
	}
	
	@Test
	public void test02() {
		baseURI="https://reqres.in/api/users";
		given().queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
	}
	
	
	@Test
	public void test03() {
		//baseURI="https://reqres.in/api/users";
		given().baseUri("https://reqres.in/api/users").queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
	}
	
}

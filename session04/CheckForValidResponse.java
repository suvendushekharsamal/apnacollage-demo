package session04;

import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {

     @Test(enabled=false)
	public void GetSingleUser() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		   RequestSpecification respes = RestAssured.given();
		   Response res=respes.get();
		   System.out.println(res.asString());
		   int actual=res.getStatusCode();
		   Assert.assertEquals(actual, 200,"Correct status code not received");
		   
		   String statusLine = res.getStatusLine();
		   
		   Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect Status Line");
		   
	}
	
     @Test
 	public void GetSingleUser01() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		   RequestSpecification respes = RestAssured.given();
		   Response res=respes.get();
		  
		    ValidatableResponse validatRes = res.then();
		    
		    validatRes.statusCode(200);
		    
		    System.out.println("STATUS CODE VALIDATION");
		    
		    validatRes.statusLine("HTTP/1.1 200 OK");
		    
		   
		   
		   
	}
	
}

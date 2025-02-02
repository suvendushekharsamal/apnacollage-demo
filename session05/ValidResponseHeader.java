package session05;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidResponseHeader {

	@Test
	public void GetSingleUser() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().when().get();
		String str=res.getHeader("Content-Type");
		
		System.out.println(str);
		
		res.then().header("Content-Type", str);
		
		System.out.println("successful");
		}
	}

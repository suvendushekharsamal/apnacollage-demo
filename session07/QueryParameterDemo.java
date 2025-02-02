package session07;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {

	@Test
	public void demo1() {
		
		RestAssured.baseURI="https://reqres.in/api/users/";
        RequestSpecification resp= RestAssured.given();
        resp.queryParam("page", 1).queryParam("id", 1);
        Response ser = resp.get();
        System.out.println(ser.getBody().asString());
       
        JsonPath path=ser.jsonPath();
        System.out.println(path.get("data.first_name"));
        
          
	}
}

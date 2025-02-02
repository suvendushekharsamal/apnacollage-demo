package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_DeleteMethod {

	@Test
	public void test06() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "sipu");
		jsonData.put("job", "Tester");
		
		RestAssured.baseURI = "https://reqres.in/api/users/29";
		RestAssured.given().
		when().delete().
		then().statusCode(204).log().all();

	}
}

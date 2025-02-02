  package session13;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {

	@Test
	public void createUser() {

		// create JsonData
		JSONObject obj = new JSONObject();
		obj.put("name", "sipu");
		obj.put("job", "QA");

		// create Request specification
		RequestSpecification reqs = RestAssured.given();

		// specify URL
		reqs.baseUri("https://reqres.in").basePath("/api/users").contentType(ContentType.JSON).header("headername", "value").body(obj.toJSONString());

		// query detatils from request specification
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqs);

		// get Base uri
		String RetriveBaseUri = queryRequest.getBaseUri();
		System.out.println("Base uri :" + RetriveBaseUri);

		// get BasePath
		String RetriveBasePath = queryRequest.getBasePath();
		System.out.println("Base path :" + RetriveBasePath);

		// get BasePath
		String RetriveBody = queryRequest.getBody();
		System.out.println("Retrive Body :" + RetriveBody);
		
		//get all headers
		 Headers allHeader= queryRequest.getHeaders();
		 for(Header data:allHeader) {
			 System.out.println("HeaderKey :" + data.getName() + "   Header value : " + data.getValue());
		 }

	}

}

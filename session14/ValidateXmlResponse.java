package session14;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateXmlResponse {
	
	@Test
	public void AddPet() {
		
		//xml data
		String xmlRequestBody="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>"; 
		
		
		//JSON data
		String jsonData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		
		// create Request specification
				RequestSpecification reqs = RestAssured.given();

				// specify URL
				//'https://petstore.swagger.io/v2/pet'
				reqs.baseUri("https://petstore.swagger.io")
				.basePath("/v2/pet")
				.contentType(ContentType.JSON)
				.header("accept", "application/xml");
				reqs.header("Content-Type", "application/json");
				reqs.body(jsonData);
                Response resp=reqs.post();
                
                resp.prettyPrint();
                ResponseBody body= resp.getBody();
                XmlPath path = body.xmlPath();
                // XmlPath path=resp.xmlPath();
               System.out.println( path.get("Pet.name"));
              

	}

}

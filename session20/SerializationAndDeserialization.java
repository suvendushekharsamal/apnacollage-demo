package session20;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {

	
	@Test
	public void CreateJSONObjectFromEmployeeClassObject() throws JsonProcessingException {
		Employee emp=new Employee();
		emp.setFirstName("Suresh");
		emp.setLastName("samal");
		emp.setGender("male");
		emp.setSalary(10000);
		emp.setAge(22);
		
		//convert employee class object to json payload as string
		ObjectMapper om=new ObjectMapper();
		String employeeJson= om.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(employeeJson);
		
		RequestSpecification reqs=RestAssured.given();
		
		reqs.baseUri("http://httpbin.org/post");
		reqs.contentType(ContentType.JSON);
		reqs.body(employeeJson);
		Response res= reqs.post();
		
		res.prettyPrint();
		
		//create json string(employeeJson) to class object
		Employee emp2 = om.readValue(employeeJson, Employee.class);
		System.out.println(emp);
		
		
	}
		
}

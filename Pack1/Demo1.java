package Pack1;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

 
public class Demo1 {

	@Test
    void Test1(){
  
	Response res= RestAssured.get("https://reqres.in/api/users/2");
	// print the body
   System.out.println(res.asString());
   
   //or
   System.out.println(res.getBody().asString());
   System.out.println(res.getStatusCode());
   
    
	}

}

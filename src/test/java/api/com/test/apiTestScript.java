package api.com.test;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiTestScript {
	
	 @Test(description = "validate the status code for GET user Endpoints")
	    public void validateStatusCodeGetusers() {
	        // Use RestAssured.given() to set up the request specification
	        Response resp = RestAssured.given().queryParam("page", 2).
	        								when().
	        									get("https://reqres.in/api/users"); //restassured
	
	
	    int actualStatusCode =resp.statusCode();	//restassured
	    
	   assertEquals(actualStatusCode, 200); //testng
	 }
	   
	   @Test(description = "validate the status code for GET user Endpoints")
	    public void validateStatusCodeGetuser() {
	  
	        // Use RestAssured.given() to set up the request specification
	        Response resp = RestAssured.given().when().
	        									get("https://reqres.in/api/users?page=2"); //restassured
	    int actualStatusCode =resp.statusCode();	//restassured
	    
	   assertEquals(actualStatusCode, 200); //testng
	 }
	   
	   @Test(description = "validate the status code for GET user Endpoints")
	    public void validateResponseBodyGetusers() {
	        Response resp = RestAssured.given().queryParam("page", 2).when().
	        									get("https://reqres.in/api/users"); //restassure
	    int actualStatusCode =resp.statusCode();	//restassured
	   assertEquals(actualStatusCode, 200); //testng
	   System.out.println(resp.body().asString());
	   		String	actualValue=resp.path("data[0].email");
	   		assertEquals(actualValue,"michael.lawson@reqres.in");
	 }
	   
	   
	   
	 
	   @Test(description = "validate the status code for GET user Endpoints")
	    public void validateResponseBodyGetusersHeaders() {
	        Response resp = RestAssured.given().
	        		headers("Content-Type","application/json")
	        		.when().
	        		get("https://gorest.co.in/public-api/users"); //restassure
	    int actualStatusCode =resp.statusCode();	//restassured
	   assertEquals(actualStatusCode, 200); //testng
	   System.out.println(resp.body().asString());
	   
	 }
	   //we can add multiple headers aftwr puuting .header or we can crete a separate class store all in it and call it same for the 
	   //Query paratnter as well
	   



}

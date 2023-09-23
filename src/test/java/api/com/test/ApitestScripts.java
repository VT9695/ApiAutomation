package api.com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.testng.annotations.Test;

import api.com.pojo.cityModel;
import api.com.pojo.pojoClass;
import api.com.pojo.pojoComplex;
import api.com.util.Helper;
import api.com.util.ReadTestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApitestScripts extends Helper {
	private String accessToken ;
	
	
	
	@Test(description= "validate the status code for the get user endpoints")
	public void valdiateStatusCodeGetusers() throws JSONException, IOException ,org.json.simple.parser.ParseException{
		System.out.println("**********"+ ReadTestData.getTestData("uriGetUsers"));
		Response res =RestAssured
						.given()
						.when()
						.get(ReadTestData.getTestData("uriGetUsers"));//?page=2 query params
						int ActualStatusCode =res.statusCode();
						assertEquals(ActualStatusCode, 200);
}	
@Test(description= "validate the Response Body for the get user endpoints")
	public void valdiateResponseBodyGetuser() throws IOException, org.json.simple.parser.ParseException {	        
		Response res =				RestAssured
									.given()
									.queryParam("page", 2)
									.when()
									.get("https://reqres.in/api/users");//?page=2 query params
		
									int ActualStatusCode =res.statusCode();
									assertEquals(ActualStatusCode, 200);
		
									System.out.println(res.body().asString());
									String actValue=res.path("support.url"); //json path provided by rest assured to perform the validation
									assertEquals(actValue, ReadTestData.getTestData("url"));			
}

@Test(description= "validate the Response Body for the get user endpoints property reader")
public void valdiateResponseBodyGetuserss() throws IOException, org.json.simple.parser.ParseException  {	     
	
	System.out.println("*********"+ Helper.propertyReader("qaBaseUrl"));
	//fetch baseurl from property
	String baseUrl =Helper.propertyReader("qaBaseUrl");
	
	//fetch endpoint
	String endpoint =ReadTestData.getTestData("endPointUrl");
	
	//fetch uri
	String uri =baseUrl+endpoint;
	System.out.println("the URI is "+uri);
	
	Response res =				RestAssured
								.given()
								.queryParam("page", 2)
								.when().get(getUri());
								//.get(Helper.propertyReader("qaBaseUrl"));//?page=2 query params
	
								int ActualStatusCode =res.statusCode();
							assertEquals(ActualStatusCode, 200);		
							System.out.println(getUri());
}
//3rd approch adding headers
@Test(description= "validate the Response Body for the get user endpoints")
public void valdiateResponseBodyGetHeader() {        
	Response res =RestAssured
								.given()
								.header("Content-Type","application/json")
								.when()
								.get("https://gorest.co.in/public-api/users");
								int ActualStatusCode =res.statusCode();
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());		
}
//4th getpathparams
@Test(description= "validate the Response Body for the get user endpoints")
public void valdiateResponseBodyGetPathParams() {
	
								String raceSeasonValue ="2017";
								Response res =RestAssured
								.given()
								.pathParams("raceSeason",raceSeasonValue)
								.when()
								.get("https://ergast.com/api/f1/{raceSeason}/circuits.json");
	
								int ActualStatusCode =res.statusCode();
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());		
}
//authetication
//basis authentication
@Test(description= "validate the Response Body for the get user endpoints")

public void valdiateResponseBodyGetBasicAuth() {
	
	Response res =RestAssured.given()
								.auth()
								.basic("postman", "password")
								.when()
								.get("https://postman-echo.com/basic-auth");//RestAssured
	
								int ActualStatusCode =res.statusCode();//restAssured
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());	
								//accessToken=res.path("token"); 
	}
//digest auth
@Test(description= "validate the Response Body for the get user endpoints")

public void valdiateResponseBodyGetDigestAuth() {
	
	Response res =RestAssured.given()
								.auth()
								.digest("postman", "password")
								.when()
								.get("https://postman-echo.com/basic-auth");//RestAssured
	
								int ActualStatusCode =res.statusCode();//restAssured
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());	
	}
//OAuth1.0 authentication type
@Test(description= "validate the Response Body for the get user endpoints")

public void valdiateResponseBodyGetOAuth1() {
	
	Response res =RestAssured.given()
								.auth()
								.oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
								.when()
								.get("https://reqres.in/api/users?page=2");//RestAssured
	
								int ActualStatusCode =res.statusCode();//restAssured
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());	
}
//OAuth2.0
@Test(description= "validate the Response Body for the get user endpoints")

public void valdiateResponseBodyGetOAuth2Auth() {
	
	Response res =RestAssured
								.given()
								.auth()
								.oauth2(accessToken)//bearer secretToken >>100line refer 
								.when()
								.get("https://reqres.in/api/users?page=2");//RestAssured
	
								int ActualStatusCode =res.statusCode();//restAssured
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());
}

//oauth whn u knw the Authorization type is oauth 2 then always use and simple use is below
@Test(description= "validate the Response Body for the get user endpoints")

public void valdiateResponseBodyGetOAuth2Authknw() {
	
	Response res =RestAssured
								.given()
								.header("Authorization",accessToken)// 
								.when()
								.get("https://reqres.in/api/users?page=2");//RestAssured
	
								int ActualStatusCode =res.statusCode();//restAssured
								assertEquals(ActualStatusCode, 200);
								System.out.println(res.body().asString());
}
//depends on the project how they are using to generate auth token
//if we declred it inside the method so we cant accesss if i want to access in class so we have to define at private variable that then reasson we have define at class level as a privte string accesstoken


//Authomate post method for users by uisng json file


@Test(description= "Automate post method for the users")
public void postAutoExtFile() throws IOException, org.json.simple.parser.ParseException {
    File Filerb = new File("V:\\naveen automation labs\\tet\\Resources\\TestData\\postmethodrequestbody.json");
    FileInputStream file = new FileInputStream(Filerb);

    Response res = RestAssured
        .given().header("Content-Type", "application/json")
        .body(IOUtils.toString(file,"UTF-8"))
        .when().post("https://reqres.in/api/users");

    assertEquals(res.getStatusCode(),201);

    System.out.println("the status code for the post method is "+res.getStatusCode());
    System.out.println("The response body of the post method is "+ res.getBody().asString());
}



////Authomate post method for users by uisng pojo class
@Test(description= "Automate post method for the users")
public void postAutoExtFilebypojoclass() throws IOException, org.json.simple.parser.ParseException {
    File Filerb = new File("V:\\naveen automation labs\\tet\\Resources\\TestData\\postmethodrequestbody.json");
    FileInputStream file = new FileInputStream(Filerb);
    pojoClass pojorb = new pojoClass();
    pojorb.setName("morpheus");
    pojorb.setJob("leader");
    Response res = RestAssured
        .given().header("Content-Type", "application/json")
        .body(pojorb)
        .when().post("https://reqres.in/api/users");

    assertEquals(res.getStatusCode(),201);

    System.out.println("the status code for the post method is "+res.getStatusCode());
    System.out.println("The response body of the post method is "+ res.getBody().asString());

}



//managing complex pojos

@Test(description= "Automate post method for the users")
public void postAutoExtFilebycomplexpojoclass() throws IOException, org.json.simple.parser.ParseException {
    File Filerb = new File("V:\\naveen automation labs\\tet\\Resources\\TestData\\postmethodrequestbody.json");
    FileInputStream file = new FileInputStream(Filerb);
    
    List<String>jobss = new ArrayList<String>();
    jobss.add("tester");
    jobss.add("developer");
    jobss.add("support");
    
    pojoClass pojorb = new pojoClass();
    pojorb.setName("morpheus");
    pojorb.setJob("leader");
    pojorb.setJobs(jobss);
    Response res = RestAssured
        .given().header("Content-Type", "application/json")
        .body(pojorb)
        .when().post("https://reqres.in/api/users");

    assertEquals(res.getStatusCode(),201);

    System.out.println("the status code for the post method is "+res.getStatusCode());
    System.out.println("The response body of the post method is "+ res.getBody().asString());

}


///day-11
@Test(description= "Automate post method for the users")
public void validatePostBodyComplexPojo()  throws IOException, org.json.simple.parser.ParseException {

		pojoComplex pojo= new pojoComplex();
		//created a list of string to have all the values define as per the json
		List<String>job= new ArrayList<>();
		job.add("tester");
		job.add("developer");
		job.add("support");
		
		cityModel cities = new cityModel();
		cities.setName("bangalore");
		cities.setTemprature("30");
		
		cityModel cities2 = new cityModel();
		cities.setName("delhi");
		cities.setTemprature("40");
		
		List<cityModel>lst= new ArrayList<>();''
		lst.add(cities);
		lst.add(cities2);
		
		pojo.setName("morpheus");
		pojo.setJobs(job);
		pojo.setCityModels(lst);
		Response res = RestAssured
    	.given()
    	.header("Content-Type", "application/json")
    	.body(pojo)
    	.when().post("https://reqres.in/api/users");
		assertEquals(res.getStatusCode(),201);

}}




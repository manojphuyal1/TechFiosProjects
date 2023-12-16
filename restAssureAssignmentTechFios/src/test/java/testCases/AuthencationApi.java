package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

//import io.restassured.RestAssured; 
//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import java.io.File;


public class AuthencationApi {
	
	private static final String Response = null;
	String baseURI;
	String authFilepath;
	
	public AuthencationApi() {
		
		baseURI = "https://qa.codefios.com/api";
		authFilepath ="/restAssure/src/main/java/data";
	}
	
	
	@Test
	public void authencationApi() {
		
		/*
		given: all input details (baseURI, Headers, Authorization, Payload/Body, QueryParameters) 
		when: submit api requests (Http method, Endpoint/Resource)
		then: validate response (status code, Headers, responseTime, Payload/Body)
		*/
		io.restassured.response.Response response = 
		
		given()
			.baseUri(baseURI)
			.header("Content-Type", "application/json")
			.body(new File(authFilepath))
			.log().all().
		when()
			.post("/user/login").
		then()
			.log().all()
			//.statusCode(201)
			//.header("Content-Type", "application/json");
			.extract().response();
		
		
		int responseCode = response.getStatusCode();
		System.out.println("Response Code:" + responseCode);
		Assert.assertEquals(responseCode, 201);
		
		String responseHeader = response.getHeader("Content-Type");
		System.out.println ("Response Header:" + responseHeader);
		Assert.assertEquals(responseHeader, "application/json");
			
	
	String responseBody = response.getBody().asString();
	System.out.println ("Response Body:" + responseBody);
	Assert.assertEquals(responseBody, "");
	
	JsonPath jp = new JsonPath(responseBody);
	String BearerToken = jp.getString("access_token");
	System.out.println("Berarer Token " + BearerToken);
	}
}

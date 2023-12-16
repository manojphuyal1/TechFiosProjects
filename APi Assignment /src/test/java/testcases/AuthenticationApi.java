
  package testcases; import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.consumer.RecordedStackTrace;

import org.testng.Assert;
import
  org.testng.annotations.Test; import static io.restassured.RestAssured.*;
  
  import java.io.File;
  
  public class AuthenticationApi { 
	  String baseURI; 
	  String authFilePath;
	  String bearerToken;
	
	  public  AuthenticationApi() {
		  baseURI="https://qa.codefios.com/api/";
          authFilePath="src\\main\\java\\data\\accCreated.json"; 
  }
  
  @Test (priority=1)
  public void authenticationApi() {
  
 Response response= given() .baseUri(baseURI) .header("Content-Type", "application/json")
  .body(new File(authFilePath)) .log().all()
  
  .when()
  .post("user/login")
  
  .then() .log().all() .statusCode(201).extract().response(); 
 
 int responseCode=response.getStatusCode();
 System.out.println(responseCode);
 Assert.assertEquals(responseCode, 201,"Response code doesnt match");
 
 String responseHeader=response.header("Content-Type");
 System.out.println(responseHeader);
 Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
 
 String responseBody=response.getBody().asString();
 JsonPath jp=new JsonPath(responseBody);
 bearerToken=jp.getString("access_token");
 System.out.println("Bearer Token is:"+ bearerToken);
 
 }
  @Test(priority=2)
  public void readAll() {
	  Response response=given().baseUri(baseURI).header("Content-Type","application/json").header("Authorization","Bearer "+bearerToken).log().all()
	  .when().get("/account/getAll").then().statusCode(200).log().all().extract().response();
	  
	  int responseCode=response.getStatusCode();
	  System.out.println(responseCode);
	  Assert.assertEquals(responseCode, 200,"Response code doesnt match");
	  
	  String responseHeader=response.header("Content-Type");
	  System.out.println(responseHeader);
	  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
	  
	  String responseBody=response.getBody().asString();
	  JsonPath jp=new JsonPath(responseBody);
	  
	  int count=jp.getInt("records.size()");
	  System.out.println("The number of records is:"+count);
		
		  String firstAccountId=jp.getString("records[0].account_id");
		  System.out.println("Fist account Id: "+firstAccountId);
		  
		  if(firstAccountId!=null) {
			  System.out.println("First account is not null");
		  }else {
			  System.out.println("First account is null");
		  }
		 
  }
  }
 
package testCases;
 import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
	  
public class DeleteOneAccount extends GenerateBearerToken {

		  String baseURI; 
		  String accountId;
		 
		  
		
public DeleteOneAccount() {
			  baseURI="https://qa.codefios.com/api/";
			  accountId="162";
	  }
	  
	
	  @Test(priority=1)
	  public void deleteOneAccount() {
		  Response response=given()
				  .baseUri(baseURI)
				  .header("Content-Type","application/json")
				  .header("Authorization","Bearer "+ bearerToken)
				  .queryParam("account_id", accountId).log().all()
		  .when().delete("/account/deleteOne").then().log().all().extract().response();
		  
		  int responseCode=response.getStatusCode();
		  System.out.println(responseCode);
		  Assert.assertEquals(responseCode, 200,"Response code doesnt match");
		  
		  String responseHeader=response.header("Content-Type");
		  System.out.println(responseHeader);
		  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
		  
		  String responseBody=response.getBody().asString();
		  JsonPath jp=new JsonPath(responseBody);
		  
			String accountMessage=jp.getString("message");
			Assert.assertEquals(accountMessage,"Account deleted successfully.","Account not deleted");
			
			
			
	  }
	
	  @Test(priority=2)
	  public void readOneAccount() {
		  Response response=given().baseUri(baseURI).header("Content-Type","application/json").auth().preemptive().basic("demo1@codefios.com", "abc123").queryParam("account_id",accountId).log().all()
		  .when().get("/account/getOne").then().log().all().extract().response();
		  
		  int responseCode=response.getStatusCode();
		  System.out.println(responseCode);
		  Assert.assertEquals(responseCode, 404,"Response code doesnt match");
		  
		  String responseHeader=response.header("Content-Type");
		  System.out.println(responseHeader);
		  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
		  
		 
	  }
			 
	  }
	 


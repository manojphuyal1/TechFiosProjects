package testCases;
 import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
	  
public class CreateOneAccount extends GenerateBearerToken {

		  String baseURI; 
		  String firstAccountId;
		  //String authFilePath;
		  
		
public CreateOneAccount() {
			  baseURI="https://qa.codefios.com/api/";
	         // authFilePath="src\main\java\data\accCreated.json"; 
	  }
	  
	 
	 
	  @Test(priority=1)
	  public void createOneAccount() {
		  Response response=given()
				  .baseUri(baseURI)
				  .header("Content-Type","application/json")
				  .header("Authorization","Bearer "+ bearerToken)
				  .body(CreateAccountPayload.createAccountPayload())
				  
				  .log().all()
		  .when().post("/account/create").then().statusCode(201).log().all().extract().response();
		  
		  int responseCode=response.getStatusCode();
		  System.out.println(responseCode);
		  Assert.assertEquals(responseCode, 201,"Response code doesnt match");
		  
		  String responseHeader=response.header("Content-Type");
		  System.out.println(responseHeader);
		  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
		  
		  String responseBody=response.getBody().asString();
		  JsonPath jp=new JsonPath(responseBody);
		  
			String accountMessage=jp.getString("message");
			Assert.assertEquals(accountMessage,"Account created successfully.","Account not created");
			
			
			
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
			
			  firstAccountId=jp.getString("records[0].account_id");
			  System.out.println("Fist account Id: "+firstAccountId);
			  
	  }
	  @Test(priority=3)
	  public void readOneAccount() {
		  Response response=given().baseUri(baseURI).header("Content-Type","application/json").auth().preemptive().basic("demo1@codefios.com", "abc123").queryParam("account_id",firstAccountId).log().all()
		  .when().get("/account/getOne").then().statusCode(200).log().all().extract().response();
		  
		  int responseCode=response.getStatusCode();
		  System.out.println(responseCode);
		  Assert.assertEquals(responseCode, 200,"Response code doesnt match");
		  
		  String responseHeader=response.header("Content-Type");
		  System.out.println(responseHeader);
		  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
		  
		  String responseBody=response.getBody().asString();
		  JsonPath jp=new JsonPath(responseBody);
		  
			String ActualAccountName=jp.getString("account_name");
			System.out.println("The account name is:"+ActualAccountName);
			
			String ActualAccountNumber=jp.getString("account_number");
			System.out.println("The account number is:"+ActualAccountNumber);
			
			String AcutalDescription=jp.getString("description");
			System.out.println("The description is:"+AcutalDescription);
			 
			String ActualBalance=jp.getString("balance");
			System.out.println("The balance is:"+ActualBalance);
			
			String ActualContactPerson=jp.getString("contact_person");
			System.out.println("The contact person is:"+ActualContactPerson);
			
			String payloadBody=CreateAccountPayload.createAccountPayload();
			JsonPath js=new JsonPath(payloadBody);
			
			String ExpectedAccountName=js.getString("account_name");
			System.out.println("The account name is:"+ExpectedAccountName);
			
			String ExpectedAccountNumber=js.getString("account_number");
			System.out.println("The account number is:"+ExpectedAccountNumber);
			
			String ExpectedDescription=js.getString("description");
			System.out.println("The description is:"+ExpectedDescription);
			 
			String ExpectedBalance=js.getString("balance");
			System.out.println("The balance is:"+ExpectedBalance);
			
			String ExpectedContactPerson=js.getString("contact_person");
			System.out.println("The contact person is:"+ExpectedContactPerson);
			
			long responseTime=response.getTimeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time:"+responseTime);
			
			if(responseTime<2000) {
				System.out.println("Response is within range");
			}else {
				System.out.println("Response is out of range");
			}
			Assert.assertEquals(ActualAccountName,ExpectedAccountName,"Ac no doesnt match");
			Assert.assertEquals(ActualAccountNumber,ExpectedAccountNumber,"Ac no doesnt match");
			Assert.assertEquals(AcutalDescription,ExpectedDescription,"data doesnt match");
			Assert.assertEquals(ActualBalance,ExpectedBalance,"Balance doesnt match");
			Assert.assertEquals(ActualContactPerson,ExpectedContactPerson,"contactPerson doesnt match");
	  }
			 
	  }
	 


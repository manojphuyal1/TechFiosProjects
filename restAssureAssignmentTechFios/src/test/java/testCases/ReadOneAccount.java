package testCases;
 import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;

	import org.testng.Assert;
	import
	  org.testng.annotations.Test; import static io.restassured.RestAssured.*;
	  
	  import java.io.File;
import java.util.concurrent.TimeUnit;
	  
public class ReadOneAccount {

		  String baseURI; 
		  String authFilePath;
		  String bearerToken;
		
		  public  ReadOneAccount() {
			  baseURI="https://qa.codefios.com/api/";
	          authFilePath="src\\main\\java\\data\\authPayload.json"; 
	  }
	  
	  @Test (priority=1)
	  public void getBeareToken() {
	  
	 Response response= given() .baseUri(baseURI) .header("Content-Type", "application/json")
	  .body("{\r\n"
	  		+ "\"username\": \"admin\",\r\n"
	  		+ "\"password\": \"123456\"\r\n"
	  		+ "}") .log().all()
	  
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
	// return bearerToken; 
	 
	 }
	  @Test(priority=2)
	  public void readOneAccount() {
		  Response response=given().baseUri(baseURI).header("Content-Type","application/json").auth().preemptive().basic("demo1@codefios.com", "abc123").queryParam("account_id","46").log().all()
		  .when().get("/account/getOne").then().statusCode(200).log().all().extract().response();
		  
		  int responseCode=response.getStatusCode();
		  System.out.println(responseCode);
		  Assert.assertEquals(responseCode, 200,"Response code doesnt match");
		  
		  String responseHeader=response.header("Content-Type");
		  System.out.println(responseHeader);
		  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
		  
		  String responseBody=response.getBody().asString();
		  JsonPath jp=new JsonPath(responseBody);
		  
			String accountName=jp.getString("account_name");
			Assert.assertEquals(accountName,"account 1","Account Name doesnt match");
			
			String accountNumber=jp.getString("account_number");
			Assert.assertEquals(accountNumber,"654321","Account Number doesnt match");
			
			String description=jp.getString("description");
			Assert.assertEquals(description,"Test description","Test description doesnt match");
			 
			String balance=jp.getString("balance");
			Assert.assertEquals(balance,"99.99","Balance doesnt match");
			
			String contactPerson=jp.getString("contact_person");
			Assert.assertEquals(contactPerson,"Sihab Suleman","contactPerson doesnt match");
			 
			long responseTime=response.getTimeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time:"+responseTime);
			
			if(responseTime<2000) {
				System.out.println("Response is within range");
			}else {
				System.out.println("Response is out of range");
			}
			
			
	  }
	  }
	 


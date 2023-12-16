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
	  
public class UpdateOneAccount extends GenerateBearerToken {

		  String baseURI; 
		  HashMap<String,String> updateAccountMap;
		 
		  
		
public UpdateOneAccount() {
			  baseURI="https://qa.codefios.com/api/";
			  updateAccountMap=new HashMap<String,String>();
	  }
	  
	public Map<String,String> updateHashMapAccount() {
		updateAccountMap.put("account_id","164");
		updateAccountMap.put("account_name", "jyotee");
		updateAccountMap.put("account_number", "332211");
		updateAccountMap.put("description", "updated");
		updateAccountMap.put("balance", "9999999");
		updateAccountMap.put("contact_person", "basyal");
		return updateAccountMap;
		
	} 
	 
	  @Test(priority=1)
	  public void updateOneAccount() {
		  Response response=given()
				  .baseUri(baseURI)
				  .header("Content-Type","application/json")
				  .header("Authorization","Bearer "+ bearerToken)
				  .body(updateHashMapAccount()).log().all()
		  .when().put("/account/update").then().log().all().extract().response();
		  
		  int responseCode=response.getStatusCode();
		  System.out.println(responseCode);
		  Assert.assertEquals(responseCode, 200,"Response code doesnt match");
		  
		  String responseHeader=response.header("Content-Type");
		  System.out.println(responseHeader);
		  Assert.assertEquals(responseHeader, "application/json","Response header doesnt match");
		  
		  String responseBody=response.getBody().asString();
		  JsonPath jp=new JsonPath(responseBody);
		  
			String accountMessage=jp.getString("message");
			Assert.assertEquals(accountMessage,"Account updated successfully.","Account not updated");
			
			
			
	  }
	
	  @Test(priority=2)
	  public void readOneAccount() {
		  Response response=given().baseUri(baseURI).header("Content-Type","application/json").auth().preemptive().basic("demo1@codefios.com", "abc123").queryParam("account_id",updateHashMapAccount().get("account_id")).log().all()
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
			
			System.out.println("");
			System.out.println("--------------");
			System.out.println("");
			
			String ExpectedAccountName=updateHashMapAccount().get("account_name");
			System.out.println("The account name is:"+ExpectedAccountName);
			
			String ExpectedAccountNumber=updateHashMapAccount().get("account_number");
			System.out.println("The account number is:"+ExpectedAccountNumber);
			
			String ExpectedDescription=updateHashMapAccount().get("description");
			System.out.println("The description is:"+ExpectedDescription);
			 
			String ExpectedBalance=updateHashMapAccount().get("balance");
			System.out.println("The balance is:"+ExpectedBalance);
			
			String ExpectedContactPerson=updateHashMapAccount().get("contact_person");
			System.out.println("The contact person is:"+ExpectedContactPerson);
			
			long responseTime=response.getTimeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time:"+responseTime);
			
			if(responseTime<2000) {
				System.out.println("Response is within range");
			}else {
				System.out.println("Response is out of range");
			}
			Assert.assertEquals(ActualAccountName,ExpectedAccountName,"Account Name doesnt match");
			Assert.assertEquals(ActualAccountNumber,ExpectedAccountNumber,"Account Number doesnt match");
			Assert.assertEquals(AcutalDescription,ExpectedDescription,"Test description doesnt match");
			Assert.assertEquals(ActualBalance,ExpectedBalance,"Balance doesnt match");
			Assert.assertEquals(ActualContactPerson,ExpectedContactPerson,"contactPerson doesnt match");
	  }
			 
	  }
	 


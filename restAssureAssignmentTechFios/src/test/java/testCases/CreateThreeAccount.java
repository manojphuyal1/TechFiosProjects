package testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateThreeAccount extends GenerateBearerToken {

	  String baseURI; 
	 // String firstAccountId;
	 // String authFilePath;
	  
	
public CreateThreeAccount() {
		  baseURI="https://qa.codefios.com/api/";
       // authFilePath="src\\main\\java\\data\\authPayload.json"; 
}



@Test(dataProvider="MultiAccount")
public void createThreeAccount(String account_name,String account_number,String description,String balance,String contact_person) {
	  Response response=given()
			  .baseUri(baseURI)
			  .header("Content-Type","application/json")
			  .header("Authorization","Bearer "+ bearerToken)
			  .body(CreateAccountPayload.createAccount(account_name,account_number,description,balance,contact_person)).log().all()
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

@DataProvider(name="MultiAccount")
public Object getAccount() {
	return new Object[][] {{"joyte","332211","Acount 1","90000","basyal"},
		{"manoj","55645665","Account 2","90000","basyal"},
		{"phuyal","564454","Account 3","30000","basyal"}};
}
		
}



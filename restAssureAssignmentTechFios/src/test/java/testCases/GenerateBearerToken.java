
package testCases; 

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
 import java.io.File;
  
  public class GenerateBearerToken { 
	  String baseURI; 
	 // String authFilePath;
	 public static String bearerToken;
	
	  public  GenerateBearerToken() {
		  baseURI="https://qa.codefios.com/api/";
          //authFilePath="src\main\java\data\accCreated.json"; 
          generateBearerToken();
  }
  
  
  public void generateBearerToken() {
  
 Response response= given()
		 .baseUri(baseURI)
		 .header("Content-Type", "application/json")
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
 
 }
   
  }
 
package util;

import java.io.FileReader;

import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadDataGSON {
	
	JsonElement jsonEleObj = null;
	JsonParser parserObj;
	JsonObject jsonObj;


	@Test
	public void readData() {
		
		String json = "{\r\n" + 
				"  \"TestData\": \"testDataGSON\",\r\n" + 
				"	\"LoginInfo\":\r\n" + 
				"			{\r\n" + 
				"				\"UserName\": \"demo@techfios.com\",\r\n" + 
				"				\"Password\" : \"abc123\",\r\n" + 
				"				\"ValidationText\" : \"Dashboard\"\r\n" + 
				"			},\r\n" + 
				"	\r\n" + 
				"	\"AddContact\": \r\n" + 
				"		\r\n" + 
				"			{\r\n" + 
				"				\"FullName\": \"Json Project\",  \r\n" + 
				"				\"Company\": \"Techfios\",\r\n" + 
				"				\"Email\": \"msexcell@gmail.com\",\r\n" + 
				"				\"Phone\": \"File\",  \r\n" + 
				"				\"Address\":\r\n" + 
				"						[\r\n" + 
				"							{ \r\n" + 
				"								\"Street\": \"File\",\r\n" + 
				"								\"City\": \"File\",\r\n" + 
				"								\"State\": \"File\",\r\n" + 
				"								\"Zip\": \"File\",\r\n" + 
				"								\"Country\": \"File\"\r\n" + 
				"							},\r\n" + 
				"							{ \r\n" + 
				"								\"Street\": \"File\",\r\n" + 
				"								\"City\": \"File\",\r\n" + 
				"								\"State\": \"File\",\r\n" + 
				"								\"Zip\": \"File\",\r\n" + 
				"								\"Country\": \"File\"\r\n" + 
				"							}\r\n" + 
				"						],\r\n" + 
				"					\r\n" + 
				"				\"Group\": \"File\",\r\n" + 
				"				\"ValidationText\" : \"AddCustomer\"\r\n" + 
				"			}\r\n" + 
				"}  ";
		
		parserObj = new JsonParser();
//		JsonElement jsonEleObj = parserObj.parse(json);
		try {
			FileReader reader = new FileReader("testData\\TF_TestData.json");
			jsonEleObj = parserObj.parse(reader);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonEleObj.isJsonObject());
		
		jsonObj = jsonEleObj.getAsJsonObject();
//		System.out.println(jsonObj.get("TestData"));
		System.out.println(jsonObj.get("TestData").getAsString());
		
/*		System.out.println(jsonObj.get("LoginInfo").isJsonObject());
//		jsonObj.get("LoginInfo").getAsJsonObject().get("UserName");
		System.out.println(jsonObj.get("LoginInfo").getAsJsonObject().get("UserName"));
		String str = jsonObj.get("LoginInfo").getAsJsonObject().get("UserName").getAsString();
		System.out.println(str);*/
	}

}

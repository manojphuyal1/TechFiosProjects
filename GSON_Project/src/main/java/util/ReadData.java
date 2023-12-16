package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadData {
	
	@Test
	public void readJsonData() throws IOException, ParseException{
		
		JSONParser jsonparser = new JSONParser();
		
		try {
			
			FileReader reader = new FileReader("testData\\TF_TestData.json");
			
			Object obj = jsonparser.parse(reader);
			JSONObject jsonObj = (JSONObject) obj;
			
			String Login = (String) jsonObj.get("TestData");
//			String Login = jsonObj.get("UserName").toString();
			System.out.println(Login);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

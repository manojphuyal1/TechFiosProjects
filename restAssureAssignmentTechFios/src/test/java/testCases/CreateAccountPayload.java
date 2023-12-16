package testCases;

public class CreateAccountPayload {
	
	public static String createAccount(String accountName,String accountNumber,String description,String balance,String contactPerson) {
		return "{\r\n"
				  		+ "\"account_name\": \""+accountName+"\",\r\n"
				  		+ "\"description\": \""+description+"\",\r\n"
				  		+ "\"balance\": "+balance+",\r\n"
				  		+ "\"account_number\": "+accountNumber+",\r\n"
				  		+ "\"contact_person\": \""+contactPerson+"\"\r\n"
				  		+ "}";
		
	}

	public static String createAccountPayload() {
		return "{\r\n"
				+ "\"account_name\": \"Manoj\",\r\n"
				+ "\"description\": \"Test description 1\",\r\n"
				+ "\"balance\": 99999.99,\r\n"
				+ "\"account_number\": 333333333,\r\n"
				+ "\"contact_person\": \"phuyal\"\r\n"
				+ "}";
		
	}
}




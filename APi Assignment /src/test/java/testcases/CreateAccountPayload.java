package testcases;

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

	public static String createAccount() {
		return "{\r\n"
				+ "\"account_name\": \"Rohini\",\r\n"
				+ "\"description\": \"Test description 1\",\r\n"
				+ "\"balance\": 100.22,\r\n"
				+ "\"account_number\": 993498856789,\r\n"
				+ "\"contact_person\": \"Rathina\"\r\n"
				+ "}";
		
	}
}




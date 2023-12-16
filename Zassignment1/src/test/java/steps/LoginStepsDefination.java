package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepsDefination extends TestBase{
	LoginPage loginpage;
	
	@Before
	public void beforeRun() {
		initDriver();	
		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
	}
	
@Given("User is on the techfios login page")
public void user_is_on_the_techfios_login_page() {
	driver.get("https://techfios.com/billing/?ng=admin/");
   
}

@When("User enters the {string} in the {string} field")
public void user_enters_userNamePassword_in_theuserNamePassword_field(String username, String password) {
   loginpage.enterUserName(username);
   loginpage.enterPassword(password);
}


@When("User clicks on {string}")
public void user_clicks_on_login(String login) {
	loginpage.clickSignInButton();
    
}

@Then("User should land on Dashboard page")
public void user_should_land_on_Dashboard_page() {
 
}

@Then("User clicks on {string}")
public void user_clicks_on_bankcashNewAccount(String link) {
    
}


@Then("User enters {string} in the {string} field in accounts page")
public void user_enters_text_in_accountsField_in_accounts_page(String Text, String field) {
}

@Then("User clicks on {string}")
public void user_clicks_on_submit(String submit) {
   
}

@Then("User should be able to validate account created successfully")
public void user_should_be_able_to_validate_account_created_successfully() {
   
}


	
@After
public void tearDown() {
	driver.close();
	driver.quit();
}	
	

}

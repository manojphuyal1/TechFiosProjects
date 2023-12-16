package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;


public class LoginStepsDefination extends TestBase{
	LoginPage loginpage;
	DatabasePage databasePage;
	
	@Before
	public void beforeRun() {
		initDriver();	
		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
	  databasePage = new DatabasePage();
	}
	
	@Given("User is on codefios login page")
	public void user_is_on_codefios_login_page() {
		driver.get("https://qa.codefios.com/");
			
	}

	@When("User enters username as {string}") 
	public void user_enters_username_as(String username) {
		
		loginpage.enterUserName(username);
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		loginpage.enterPassword(password);
	}

	@When("User enters {string} form mysql database")
	public void user_enters_from_mysql_database(String loginData) {
	if (loginData.equalsIgnoreCase("username")) {
	loginpage.enterUserName(databasePage.getDataFromDb("username"));
	System.out.println("Username from mysql DB: " + databasePage.getDataFromDb("username"));
	} else if (loginData.equalsIgnoreCase("password")) {
	loginpage.enterPassword(databasePage.getDataFromDb("password"));
	System.out.println("Password from mysql DB: " + databasePage.getDataFromDb("password"));
	} else {
	System.out.println("Unable to pull data from MySql DB for: '" + loginData + "'");
	}

	// switch () {
	// case
	// }
		
	}
	
	@When("User clicks on signin button")
	public void user_clicks_on_signin_button() {
		loginpage.clickSignInButton();
	}

	@Then("User should land on dashboard page")
	public void user_should_land_on_dashboard_page() {
		
		takeScreenshot(driver);
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	// login data
	String userName = "demo@techfios.com";
	String password = "abc123";
	
	//TestData
	String dashboard = "Dashboard";
	String addCustomer = "Add Contact";
	String fullName = "Selenium";
	String company = "Techfios";
	String email = "demo1@techfios.com";
	String phone = "123456";
	String country = "Albania";

	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.performLogin(userName, password);
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage(dashboard);
		dashboardPage.clickOnCustomerMenuButton();
		dashboardPage.clickOnAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddCustomerPage(addCustomer);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompany(company);
		addCustomerPage.insertEmail(email);

	}

}

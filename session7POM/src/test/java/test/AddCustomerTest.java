package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src/main/java/testdata/testdata.xlsx");
	// login data
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardHeader = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
		
		//TestData
		String addCustomerHeader = exlRead.getCellData("AddContactInfo", "AddContactValidationText", 2);
		String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
		String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
		String email = exlRead.getCellData("AddContactInfo", "Email", 2);
		String phone =exlRead.getCellData("AddContactInfo", "Phone", 2);
		String country = exlRead.getCellData("AddContactInfo", "Country", 2);
		String city = exlRead.getCellData("AddContactInfo", "City", 2);
		String address =  "unit 8 st georg st hurstville";
		String Zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
		
		@Test
		public void addValidCustomer() throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
		loginpage.insertUsername(userName);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.verifyDashboardPage(dashboardHeader);
		dashboardpage.clickCustomerMenu();
		dashboardpage.clickAddNewCostomer();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.verifyAddCustomerPage(addCustomerHeader);
		addcustomerpage.insertFullNameField(fullName);
		addcustomerpage.selectCompanyDropdown(company);
		addcustomerpage.insertEmailField(email);
		addcustomerpage.insertPhoneField(phone);
		addcustomerpage.insertAddressField(address);
		addcustomerpage.saveField();
		
		dashboardpage.clickOnListCustomerMenuButton();
		
		addcustomerpage.validateInsertedNameAndDelete();
		
		BrowserFactory.tearDown();
		
		
		
		}
}
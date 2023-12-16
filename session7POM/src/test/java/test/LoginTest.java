package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	
	//login data
	ExcelReader exl = new ExcelReader("src/main/java/testdata/testdata.xlsx");
	
		String userName = exl.getCellData("LoginInfo", "UserName", 2);
		String password = exl.getCellData("LoginInfo", "Password", 2);
		String dashboardHeader = exl.getCellData("DashboardInfo", "DashboardHeader", 2);
		@Test
		public void validUserShoulsBeAbleToLogin() throws InterruptedException {
			
			driver = BrowserFactory.init();
			
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			
			loginPage.insertUsername(userName);
			loginPage.insertPassword(password);
			loginPage.clickSigninButton();
			
			DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardpage.verifyDashboardPage(dashboardHeader);
			
			BrowserFactory.tearDown();
		}
		
	
	

}

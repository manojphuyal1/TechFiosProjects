package test;

import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;



public class LoginTest {
	
	WebDriver driver;
	JsonParser parserObj;
	JsonElement jsonEleObj;

	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void readJson() {
		
		try {
			FileReader reader = new FileReader("testData\\TF_TestData.json");
			parserObj = new JsonParser();
			jsonEleObj = parserObj.parse(reader);
			jsonEleObj.isJsonObject();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(groups= {"smoke", "regression"})
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.insertPassword(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString());
		System.out.println("===============passed");
		BrowserFactory.tearDown();
		
	}
	
	@Test(groups= {"smoke"})
	public void smoke() {
		System.out.println("smoke");
	}
	
	@Test(groups= {"regression"})
	public void regression() {
		System.out.println("regression");
	}
}

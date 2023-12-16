package session5testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EdgeAndChrome {

	WebDriver driver;
	String browser = "edge";

	// WEB ELEMENT STORE FOR LOGIN TEST
	By USERNAME_FIELD = By.xpath("//input[@type ='text']");
	By PASSWORD_FIELD = By.xpath("//input[@type='password']");
	By SIGN_IN_FIELD = By.xpath("//button[@name='login']");
	By TITLE_FIELD = By.xpath("//h2[text() = ' Dashboard ']");

	@BeforeMethod
	public void init() {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver");
			driver = new EdgeDriver();
			
		}else {
			System.out.println("please use valid browser.");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void LoginTestNG() {

		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_FIELD).click();
		Assert.assertTrue(driver.findElement(TITLE_FIELD).isDisplayed());
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}

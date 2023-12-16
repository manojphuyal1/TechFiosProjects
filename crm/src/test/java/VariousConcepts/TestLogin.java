package VariousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
	static WebDriver driver;
@Before
	public  void launchChrome() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		// Chrome object
		driver = new ChromeDriver();
		// deletecookies
		driver.manage().deleteAllCookies();
		// managetime
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing");
		
	}

@After
	public void CloseBrowser() throws InterruptedException {

		Thread.sleep(3000);

		driver.close();
		driver.quit();
	}
@Test
	public void positiveLoginTest()  throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
		WebElement bankAndCash = driver.findElement (By. linkText ("Bank & Cash"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript ("arguments [0].click();", bankAndCash);
		
		WebElement newAccount = driver.findElement (By. linkText ("New Account"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript ("arguments [0].click ();", newAccount);
		
		driver.findElement(By.id("account")).sendKeys("MP-AUTOMATION");
		driver.findElement(By.id("description")).sendKeys("AUTOMATE DONE BY MP");
		driver.findElement(By.id("balance")).sendKeys("111111");		driver.findElement(By.id("account_number")).sendKeys("7777777");
		driver.findElement(By.id("contact_person")).sendKeys("MANOJ PHUYAL");
		driver.findElement(By.id("contact_phone")).sendKeys("682-375-8443");
		driver.findElement(By.id("ib_url")).sendKeys("www.internetbanking.com");
		driver.findElement (By.xpath("//button[@class='btn btn-primary']")).click();
		
}
@Test		
public  void negativetiveLoginTest() {
	driver.findElement(By.id("username123")).sendKeys("demo@techfios.com");
	driver.findElement(By.id("password")).sendKeys("abc123");
	driver.findElement(By.name("login")).click();
	
}
}


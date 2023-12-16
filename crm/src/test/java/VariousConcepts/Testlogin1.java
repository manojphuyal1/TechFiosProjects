package VariousConcepts;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testlogin1 {
	static WebDriver driver;

	@Before
	public void launchChrome() {

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

	public void positiveLoginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")).click();

		driver.findElement(By.id("account")).sendKeys("MP-AUTOMATION");
		driver.findElement(By.id("description")).sendKeys("AUTOMATE DONE BY MP");
		driver.findElement(By.id("balance")).sendKeys("111111");
		driver.findElement(By.id("account_number")).sendKeys("7777777");
		driver.findElement(By.id("contact_person")).sendKeys("MANOJ PHUYAL");
		driver.findElement(By.id("contact_phone")).sendKeys("682-375-8443");
		driver.findElement(By.id("ib_url")).sendKeys("www.internetbanking.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")).click();

	}

	@Test
	public void negativetiveLoginTest() {
		driver.findElement(By.id("username123")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		
	}

}

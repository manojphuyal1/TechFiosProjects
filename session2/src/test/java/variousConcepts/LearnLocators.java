package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {
	static WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		// Implicitly wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testLocator() throws InterruptedException {

		driver.findElement(By.name("firstname")).sendKeys("selenium");
		driver.findElement(By.id("sex-1")).click();

		// Upload files
		driver.findElement(By.id("photo")).sendKeys("/Users/manojphuyal/Downloads/2023-06-04--Session 1 (1).pptx");
		driver.findElement(By.linkText("API Documentations")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		//driver.findElement(By.partialLinkText("product")).click();
		driver.findElement(By.cssSelector("Input[name='lastname']")).sendKeys("ANONOMUS");
		
	}
	
	@After
public void AfterTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
}
	
}


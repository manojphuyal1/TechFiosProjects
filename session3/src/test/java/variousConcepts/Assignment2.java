package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	WebDriver driver;
	By USERNAME_FIELD = By.xpath("//input[@type ='text']");
	By PASSWORD_FIELD = By.xpath("//input[@type='password']");
	By SIGN_IN_FIELD = By.xpath("//button[@name='login']");
	By TRANSACTION_FIELD = By.xpath("//span[text()='Transactions']");
	By NEW_DEPOSIT_FIELD = By.xpath("//a[text()='New Deposit']");
	By SELECT_ACCOUNT_FIELD = By.xpath("//span[@class='select2-selection__arrow']");
	By SAVING_ACCOUNT_FIELD = By.xpath("//li[text()='Saving Account']");
	By DESCRIPTION_FIELD = By.xpath("//input[@id='description']");
	By AMOUNT_FEILD = By.xpath("//input[@id='amount']");
	By SUBMIT_FEILD = By.xpath("//button[@id='submit']");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void logintest() throws InterruptedException {

		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_FIELD).click();

		Thread.sleep(1000);
		driver.findElement(TRANSACTION_FIELD).click();
		driver.findElement(NEW_DEPOSIT_FIELD).click();

		Thread.sleep(1000);
		driver.findElement(SELECT_ACCOUNT_FIELD).click();
		driver.findElement(SAVING_ACCOUNT_FIELD).click();
		driver.findElement(DESCRIPTION_FIELD).sendKeys("Amount posted by manoj");
		driver.findElement(AMOUNT_FEILD).sendKeys("125000");
		driver.findElement(SUBMIT_FEILD).click();

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}

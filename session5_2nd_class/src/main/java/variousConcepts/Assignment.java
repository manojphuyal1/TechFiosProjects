package variousConcepts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment{
	WebDriver driver;

// WEB ELEMENT STORE FOR LOGIN TEST
By USERNAME_FIELD = By.xpath("//input[@type ='text']");
By PASSWORD_FIELD = By.xpath("//input[@type='password']");
By SIGN_IN_FIELD = By.xpath("//button[@name='login']");
By TITLE_FIELD = By.xpath("//h2[text() = ' Dashboard ']");

// WEB ELEMENT STORE FOR ADD CUSTOME DROPDOWN MENU
By CUSTOMER_FIELD = By.xpath("//span[text() = 'Customers']");
By ADD_CUSTOMER_FIELD = By.xpath("//a[text() = 'Add Customer']");
By CUSTOMER_HEADER_FIELD = By.xpath("//h2[text() = ' Contacts ']");
By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id = 'cid']");
By EMAIL_FILED = By.xpath("//input[@id = 'email']");
By PHONE_FILED = By.xpath("//input[@id = 'phone']");
By ADDRESS_FIELD = By.xpath("//input[@id = 'address']");
By CITY_FIELD = By.xpath("//input[@id = 'city']");
By STATE_REGION_FIELD = By.xpath("//input[@id = 'state']");
By ZIP_POSTAL_CODE_FIELD = By.xpath("//input[@id = 'zip']");
By COUNTRY_DROP_DOWN_FIELD = By.xpath("//span[text() = 'United States']");
By TAGS_FIELD = By.xpath("//select[@id='tags']");
By TECH_FIELD = By.xpath("//li[@title='Tech']");
By SAVE_FIELD = By.xpath("//button[@class='md-btn md-btn-primary waves-effect waves-light']");

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
public void LoginTest() {

	driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
	driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
	driver.findElement(SIGN_IN_FIELD).click();
	Assert.assertTrue(driver.findElement(TITLE_FIELD).isDisplayed());
}

@Test
public void testDropDown() throws InterruptedException {

	LoginTest();
	Thread.sleep(1000);
	driver.findElement(CUSTOMER_FIELD).click();
	driver.findElement(ADD_CUSTOMER_FIELD).click();
	Assert.assertTrue(driver.findElement(CUSTOMER_HEADER_FIELD).isDisplayed());

	driver.findElement(FULL_NAME_FIELD).sendKeys("Manoj Phuyal");

	Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
	sel.selectByVisibleText("Techfios");

	driver.findElement(EMAIL_FILED).sendKeys("Manoj_al@yahoo.com");
	driver.findElement(PHONE_FILED).sendKeys("111-333-7777");
	driver.findElement(ADDRESS_FIELD).sendKeys("unit 8 HurstVille");
	driver.findElement(CITY_FIELD).sendKeys("Sydney");
	driver.findElement(STATE_REGION_FIELD).sendKeys("NSW");
	driver.findElement(ZIP_POSTAL_CODE_FIELD).sendKeys("2220");

	Select sel1 = new Select(driver.findElement(TAGS_FIELD));
	sel1.selectByVisibleText("Tech");

	driver.findElement(SAVE_FIELD).click();;
	

}

@After
public void tearDown() throws InterruptedException {
	Thread.sleep(3000);
	driver.close();
	driver.quit();

}

}

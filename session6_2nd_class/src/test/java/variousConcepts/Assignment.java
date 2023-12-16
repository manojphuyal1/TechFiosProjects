package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment {
WebDriver driver;
String browser;
String url;

//Test/Mock Data
	String fullName = "Manoj Phuyal";
	String company = "Techfios";
	String email = "manoj_al@gmail.com";
	String phone = "222-222-2222";
	String country = "Albania";
	String Tech;
	
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
	//By SAVE_FIELD = By.xpath("//button[@class='md-btn md-btn-primary waves-effect waves-light']");
	By SAVE_FIELD = By.xpath("//button[@class='md-btn md-btn-primary waves-effect waves-light']");
	

	@BeforeClass
	public void readConfig() {
		
		// FileReader //BufferedREader //InputStream //Scanner

		try {
			InputStream input = new FileInputStream("src/test/java/config/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void init() {
		if (browser.equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase(browser)){
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver");
			driver = new EdgeDriver();
			
		}else {
			
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Test
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

		//elect sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		//sel.selectByVisibleText("Techfios");
		
		selectFromDropdown(COMPANY_DROPDOWN_FIELD, company);

		driver.findElement(EMAIL_FILED).sendKeys("Manoj_al@yahoo.com");
		driver.findElement(PHONE_FILED).sendKeys("111-333-7777");
		driver.findElement(ADDRESS_FIELD).sendKeys("unit 8 HurstVille");
		driver.findElement(CITY_FIELD).sendKeys("Sydney");
		driver.findElement(STATE_REGION_FIELD).sendKeys("NSW");
		driver.findElement(ZIP_POSTAL_CODE_FIELD).sendKeys("2220");

		//Select sel1 = new Select(driver.findElement(TAGS_FIELD));
		//sel1.selectByVisibleText("Tech");

		selectFromDropdown(TAGS_FIELD, "Tech");

		driver.findElement(SAVE_FIELD).click();
		
		
	}
	
	
	private void selectFromDropdown(By field, String visibleText) {
		Select sel = new Select(driver.findElement(field));
		sel.selectByVisibleText(visibleText);
		
	}

	private int randomGenerator(int boundryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundryNum);
		return generatedNum;
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}


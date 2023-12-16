package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	public AddCustomerPage(WebDriver driver ) {
		this.driver = driver;
		}
	@FindBy(how = How.XPATH, using = "//h2[text() = ' Contacts ']") WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id = 'cid']") WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'email']") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'phone']") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'city']") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[text() = 'United States']") WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@class='md-btn md-btn-primary waves-effect waves-light']") WebElement SAVE_ELEMENT;

	public void verifyAddCustomerPage(String addCustomer) {
		Assert.assertEquals(ADD_CUSTOMER_HEADER_ELEMENT.getText(), addCustomer, "Add Customer page not found.");
	}
String insertedName;
	public void insertFullNameField(String fullName) {
		insertedName = fullName + generateRandomNum(99999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}
	

	public void selectCompanyDropdown(String company) {
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}

	public void insertEmailField(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNum(99) + email);
	}

	public void insertPhoneField(String phone) {
		PHONE_ELEMENT.sendKeys(phone);

	}

	public void insertAddressField(String address) {
		ADDRESS_ELEMENT.sendKeys(address);

	}

	public void insertCityField(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void countyDropdownMenu(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}

	public void saveField() {
		SAVE_ELEMENT.click();
	}

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	
	public void validateInsertedNameAndDelete() throws InterruptedException {
		
		for(int i = 1; i <= 10; i++) {
			//driver.findElement(By.xpath("//tbody/tr[i]/td[3]/a"));
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
//			Assert.assertEquals(actualName, insertedName, "Inserted name doesn't exist.");
			if(actualName.contains(insertedName)) {
				System.out.println("Inserted name exist.");
				Thread.sleep(1000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			break;
}
}
}
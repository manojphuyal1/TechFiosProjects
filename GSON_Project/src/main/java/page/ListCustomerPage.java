package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage extends BasePage{

WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_LIST_CUST_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_LIST_CUST_ELEMENT;
	
	public void clickAddCustomerOnListCust() throws InterruptedException {
		Thread.sleep(2000);
		ADD_CUSTOMER_LIST_CUST_ELEMENT.click();
	}
	
	public void insertOnSearchBar() {
		SEARCH_BAR_LIST_CUST_ELEMENT.sendKeys(AddCustomerPage.getInsertedName());
	}
	
	
	
	
	//tbody/tr[1]/td[3]/a
	//tbody/tr[2]/td[3]/a
	//tbody/tr[3]/td[3]/a
	//tbody/tr[i]/td[3]/a
	//tbody/tr[1]/td[7]/a[2]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	String after_xpath_profile = "]/td[7]/a[1]";
	
	public void validateInsertedNameAndDelete() throws InterruptedException {
		for(int i = 1; i <= 10; i++) {
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
			if(actualName.contains(AddCustomerPage.getInsertedName())) {
				System.out.println("Inserted name exist.");
				Thread.sleep(2000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			break;
		}
	}
	
	
	public void validateInsertedNameOnSearchAndProfile() throws InterruptedException {
		
		for(int i = 1; i <= 5; i++) {
			
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(actualName.contains(AddCustomerPage.getInsertedName())) {
				System.out.println("name exist!");
				Thread.sleep(2000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
			}
			
			break;
		}
	}
	
	
}

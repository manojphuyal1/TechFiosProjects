package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends TestBase {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver){
	this.driver = driver;
	}
	//elements
	@FindBy(how = How.XPATH, using = "//h2[text() = ' Dashboard ']") WebElement DASHBOARD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text() = 'Customers']") WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text() = 'Add Customer']") WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_MENU_ELEMENT;
	public void verifyDashboardPage(String dashboard) throws InterruptedException {
		
		Assert.assertEquals(DASHBOARD_ELEMENT.getText(), "Dashboard", "dashboard page verified");
		Thread.sleep(1000);
		
	}
	public void clickCustomerMenu() {
		CUSTOMER_MENU_ELEMENT.click();
	}

	public void clickAddNewCostomer() {
		ADD_CUSTOMER_ELEMENT.click();
	}
	public void clickOnListCustomerMenuButton() throws InterruptedException {
		Thread.sleep(2000);
		LIST_CUSTOMER_MENU_ELEMENT.click();
	}
	

}

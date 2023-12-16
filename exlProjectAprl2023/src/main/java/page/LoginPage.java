package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement USERNAME_ELEMMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_BUTTON_ELEMMENT;
	
	//Intractable Methods
	public void insertUserName(String userName) {
		USERNAME_ELEMMENT.sendKeys(userName);
	}
	public void insertPassword(String password) {
		PASSWORD_ELEMMENT.sendKeys(password);
	}
	public void clickSigninButton() {
		SIGNIN_BUTTON_ELEMMENT.click();
	}

	
	
}

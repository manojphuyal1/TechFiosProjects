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
	
	//ELEMENTS
	@FindBy(how = How.XPATH, using = "//input[@type ='text']") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement SIGNIN_ELEMENT;

	public void insertUsername(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void clickSigninButton() {
		SIGNIN_ELEMENT.click();
	}

}

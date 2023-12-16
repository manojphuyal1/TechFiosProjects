package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends TestBase{

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='user_name']")
	public WebElement UserName;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	public WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@id='login_submit']")
	public WebElement SignInButton;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	public WebElement BankAndCash;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	public WebElement NewAccount;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	public WebElement AccountPageHeader; // Accounts
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	public WebElement AccountTitle; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	public WebElement Description; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	public WebElement InitialBalance; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	public WebElement AccountNumber; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	public WebElement ContactPerson; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	public WebElement Phone; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	public WebElement InternetBankingUrl; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	public WebElement SubmitButton; 
	@FindBy(how = How.XPATH, using = "//h5[text()='Manage Accounts']")
	public WebElement ValidationPageHeader; 
	

	// Methods to interact with the elements
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSignInButton() {
		SignInButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getPageTitle() {
	return driver.getTitle();
	}
	
	

	
	

	
	
	public void clickBankAndCash() {
		BankAndCash.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}

	}

	public void clickNewAccount() {
		NewAccount.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}

	}
	public void verifyingAccountPage() {

	}
	public void insertAccountTitle(String title) {
		AccountTitle.sendKeys(title+generateRandomNum(99));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		

	}
	public void insertDescription(String description) {
		Description.sendKeys(description);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
	public void instertInitialBalance(String initialBalance) {
		InitialBalance.sendKeys(initialBalance);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}

	}
	public void insertAccauntNumber(String accnbr) {
		AccountNumber.sendKeys(accnbr+generateRandomNum(99999999));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}

	}
	public void instertContactPerson(String contactprs) {
		ContactPerson.sendKeys(contactprs+generateRandomNum(9999));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}

	}public void insertPhoneNumber(String phonenbr) {
		Phone.sendKeys(phonenbr+generateRandomNum(999999999));

	}
	public void insertInternetBankingUrl(String bankingUrl) {
		InternetBankingUrl.sendKeys(bankingUrl);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
	public void clickSubmitButton() {
		SubmitButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}

	}
	
	public String validationPage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		return ValidationPageHeader.getText();
		
				
	}
	
}

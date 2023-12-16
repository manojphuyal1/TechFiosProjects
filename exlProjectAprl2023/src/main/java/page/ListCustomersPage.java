package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListCustomersPage extends BasePage{
WebDriver driver;
	
	public ListCustomersPage(WebDriver driver) {
		this.driver = driver;
	}

	
	//tbody/tr[1]/td[3]/a
	//tbody/tr[2]/td[3]/a
	//tbody/tr[3]/td[3]/a
	//tbody/tr[i]/td[3]/a
	//tbody/tr[1]/td[7]/a[2]
	//tbody/tr[2]/td[7]/a[2]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	String insertedName ="Manoj";
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

package variousConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class edgeAndChrome {
	@Test
	public void init() {
		System.setProperty("webdriver.edge.driver","drivers/msedgedriver");
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new EdgeDriver();
		driver.quit();
		
	}

}
